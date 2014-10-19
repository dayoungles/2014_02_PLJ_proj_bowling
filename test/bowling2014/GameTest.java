package bowling2014;

import junit.framework.TestCase;

public class GameTest extends TestCase {
	Game game;
	CalculateScore cal;
	protected void setUp() throws Exception {
		super.setUp();
		game = new Game();
		game.initGame();
	}
	public void testPlayGame() throws Exception {
		game.playGame();
		
	}
	
	public void testPrintBoard() throws Exception {
		game.printBoard();
	}
}
