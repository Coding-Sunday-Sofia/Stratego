package edu.asu.stratego.test;

import static junit.framework.TestCase.assertEquals;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

import edu.asu.stratego.game.ClientGameManager;
import edu.asu.stratego.game.ClientSocket;
import edu.asu.stratego.game.Game;
import edu.asu.stratego.game.PieceColor;
import edu.asu.stratego.game.Player;
import edu.asu.stratego.game.ServerGameManager;

public class ClientGameManagerTest {
	ClientGameManager client;
	Method getPlayerColor, calculateShift;

	@Test
	public void givenBlueThenRed() throws InvocationTargetException, IllegalAccessException {
		Player pOne = new Player();
		pOne.setColor(PieceColor.BLUE);
		new Game();
		Game.setOpponent(pOne);
		assertEquals(PieceColor.RED, getPlayerColor.invoke(client));
	}

	private void startPseudoClient() throws Exception {
		new Thread(() -> {

			try {
				Thread.sleep(200);
				ClientSocket.connect("localhost", 4212);
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}

	private boolean startPseudoServer() throws Exception {
		try {
			ServerSocket listener = new ServerSocket(4212);
			startPseudoClient();
			startPseudoClient();
			Socket playerOne = listener.accept();
			Socket playerTwo = listener.accept();
			new ServerGameManager(playerOne, playerTwo, 0);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Test
	public void testConnectToServer() throws Exception {
		assertEquals(startPseudoServer(), true);
	}

}