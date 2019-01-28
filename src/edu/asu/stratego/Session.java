package edu.asu.stratego;

import java.net.Socket;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Game session handler.
 * 
 * @author Curtis Sapp
 */
public class Session {
	/** It is used for incremental unique session identifiers. */
	private static int ID = 0;

	/** TCP/IP socket reference of the first player. */
	private Socket player1 = null;

	/** TCP/IP socket reference of the second player. */
	private Socket player2 = null;

	/** Session identifier. */
	private int id = (Session.ID++);

	/** Queue of the players' sockets. */
	private Queue<Socket> sockets = new LinkedBlockingQueue<Socket>();

	/**
	 * Current static session identifier getter.
	 * 
	 * @return Session identifier.
	 */
	public static int getCurrnetID() {
		return Session.ID;
	}

	/**
	 * Constructor with paramtehters.
	 * 
	 * @param player1 TCP/IP socket of the first player.
	 * @param player2 TCP/IP socket of the second player.
	 */
	public Session(Socket player1, Socket player2) {
		super();

		this.player1 = player1;
		this.player2 = player2;
	}

	/**
	 * Session identifier getter.
	 * 
	 * @return Identifier.
	 */
	public int getId() {
		return id;
	}

	/**
	 * First player socket getter.
	 * 
	 * @return TCP/IP client socket.
	 */
	public Socket getPlayer1() {
		return player1;
	}

	/**
	 * Second player socket getter.
	 * 
	 * @return TCP/IP client socket.
	 */
	public Socket getPlayer2() {
		return player2;
	}

	/**
	 * First player socket setter.
	 * 
	 * @param playerOne TCP/IP client socket.
	 */
	public void setPlayer1(Socket playerOne) {
		this.player1 = playerOne;
	}

	/**
	 * Second player socket setter.
	 * 
	 * @param playerTwo TCP/IP client socket.
	 */
	public void setPlayer2(Socket playerTwo) {
		this.player2 = playerTwo;
	}

	/**
	 * Keep TCP/IP socket reference into internal queue.
	 * 
	 * @param socket TCP/IP client socket.
	 */
	public void add(Socket socket) {
		sockets.add(socket);
	}
}
