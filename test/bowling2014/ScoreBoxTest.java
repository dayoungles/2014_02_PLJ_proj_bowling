package bowling2014;

import junit.framework.TestCase;

public class ScoreBoxTest extends TestCase {
	ScoreBox box; 
	protected void setUp() throws Exception {
		this.box = new ScoreBox();
		super.setUp();
	}
	
	public void testThrowGetScore() throws Exception {
		box = new ScoreBox();
		box.setScore(0);
		assertEquals(0, box.getScore());	
	}
	
	public void testSetSymbol() throws Exception {
//		box.setScore(0);//입력 숫자대로 값이 세팅.10점.
//		assertEquals(ScoreSymbol.STRIKE,box.getSymbol());
		box.setScore(10);//0점 세팅. 
		assertEquals(ScoreSymbol.GUTTER, box.getSymbol());
	}
	
	public void testIsSymbolExist() throws Exception {
		box.setScore(0);
		box.printBox();
		assertTrue(box.isSymbolExist());
		
	}
}
