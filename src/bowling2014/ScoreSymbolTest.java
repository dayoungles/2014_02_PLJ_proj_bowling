package bowling2014;

import junit.framework.TestCase;

public class ScoreSymbolTest extends TestCase {

	ScoreSymbol symbol;
	protected void setUp() throws Exception {
		
		super.setUp();
	}
	public void testgetSymbol() throws Exception {
		symbol = ScoreSymbol.NONE;
		assertEquals(" ", symbol.getSymbol());
	}
}
