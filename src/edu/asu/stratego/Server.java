package edu.asu.stratego;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import edu.asu.stratego.game.ServerGameManager;

/**
 * The Stratego server creates a socket and listens for connections from every
 * two players to form a game session. Each session is handled by a thread,
 * ServerGameManager, that communicates with the two players and determines the
 * status of the game.
 * 
 * @author Curtis Sapp
 */
public class Server {

	/** Keep track of all active game sessions. */
	private static List<Session> sessions = new ArrayList<Session>();

	/** Server listening port. */
	private static int port = 4212;

	/**
	 * Server application single entry point.
	 * 
	 * @param args Command line arguments.
	 * 
	 * @throws IOException It is done only to escape try-catch segments.
	 */
	public static void main(String[] args) throws IOException {
		// TODO Get server port from the command line interface.

		ServerSocket server = null;

		try {
			server = new ServerSocket(port);

			System.out.println("Server started @ " + InetAddress.getLocalHost().getHostAddress() + " ...");
			System.out.println("Waiting for incoming connections ...\n");

			while (true) {
				Socket playerOne = null;

				boolean isPlayerOneReconnecting = true;
				do {
					playerOne = server.accept();
					System.out.println("Session " + Session.getCurrnetID() + ": Player 1 has joined the session ...");

					ObjectInputStream fromPlayerOne = new ObjectInputStream(playerOne.getInputStream());

					try {
						isPlayerOneReconnecting = (Boolean) fromPlayerOne.readObject();
						if (isPlayerOneReconnecting == false) {
							break;
						}
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}

					/* Get game id from client. */
					int gameId = fromPlayerOne.readInt();
					// TODO It is not clear why game id is received at all.
				} while (true);

				Socket playerTwo = null;
				do {
					playerTwo = server.accept();
					System.out.println("Session " + Session.getCurrnetID() + ": Player 2 has joined the session ...");

					ObjectInputStream fromPlayerTwo = new ObjectInputStream(playerTwo.getInputStream());

					try {
						boolean isPlayerTwoReconnecting = (Boolean) fromPlayerTwo.readObject();
						if (isPlayerTwoReconnecting == false) {
							break;
						}
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}

					if (isPlayerOneReconnecting == true) {
						/* Get game id from client. */
						int gameId = 0;
						try {
							gameId = (Integer) fromPlayerTwo.readObject();
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}

						reconnectPlayerToSession(gameId, playerTwo);

						/*
						 * If reconnect was unsuccessful discard their information anyways. The client
						 * will make a new non reconnect request.
						 */
					}
				} while (true);

				System.out.println("Session built ...");

				Session session = new Session(playerOne, playerTwo);
				sessions.add(session);

				Thread thread = new Thread(new ServerGameManager(session, false));

				thread.setDaemon(true);
				thread.start();
			}
		} finally {
			if (server != null) {
				server.close();
			}
		}
	}

	/**
	 * Reconnect player to its session.
	 * 
	 * @param gameId Game identifier.
	 * @param socket TCP/IP sockect of the player.
	 * 
	 * @return True if the reconnection is successful, false otherwise.
	 */
	private static boolean reconnectPlayerToSession(int gameId, Socket socket) {
		for (Session session : sessions) {
			if (session.getId() != gameId) {
				continue;
			}

			session.add(socket);
			return true;
		}

		return false;
	}

	/**
	 * Game session finalization.
	 * 
	 * @param gameId Game identifier.
	 */
	public static void finishSession(int gameId) {
		for (Session session : sessions) {
			if (session.getId() != gameId) {
				continue;
			}

			sessions.remove(session);
		}
	}
}
