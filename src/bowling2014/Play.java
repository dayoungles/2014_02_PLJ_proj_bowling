package bowling2014;

import java.util.Scanner;

public class Play {
	Game game;
	int frameCount = 0;
	public static void main(String[] args) {
		Play play = new Play();
		play.startGame();

	}

	private void startGame() {
		inputFrame(getScore());
		
	}
	
	private int getScore(){
		System.out.println("input score ");
		Scanner scan = new Scanner(System.in);
		int score = scan.nextInt();
		return score;
	}
	
	private void inputFrame(int score){
		game.inputFrame(score, frameCount);
		frameCount++;
	}

}
