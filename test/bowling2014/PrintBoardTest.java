package bowling2014;

import junit.framework.TestCase;

public class PrintBoardTest extends TestCase {
	PrintBoard  board;
	protected void setUp() throws Exception {
		super.setUp();
		board = new PrintBoard();
	}
	
	public void testPrintFrame() throws Exception {
		board.printFrame();
	}
	
	public void testPrintGame() throws Exception {
		board.printFrame();
		Game game = new Game();
		game.initGame();
		game.playGame();
	}
	

}
