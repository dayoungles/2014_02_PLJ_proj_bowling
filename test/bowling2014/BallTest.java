package bowling2014;
import junit.framework.TestCase;
import bowling2014.Ball;


public class BallTest extends TestCase {
	
	public void testGetScore() throws Exception {
		Ball ball = new Ball();
		//assertEquals(5, ball.getScore(5));
		//assertEquals(0, ball.getScore(10));
		assertEquals(10, ball.getScore(0));
		//assertEquals(1, ball.getScore(9));
	}
}
