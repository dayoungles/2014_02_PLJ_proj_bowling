package bowling2014;

import junit.framework.TestCase;

public class FrameTest extends TestCase {
	Frame frame;
	protected void setUp() throws Exception {
		super.setUp();
		frame = new Frame(9); 
	}
	
	public void testFillScoreBox() throws Exception {
		frame.playOneFrame(9);
		System.out.println(frame);
	}

}
