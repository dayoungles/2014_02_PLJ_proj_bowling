package bowling2014;

import java.util.ArrayList;

public class Game {
	ArrayList<Frame> frameList = new ArrayList<Frame>();
	CalculateScore cal = new CalculateScore(frameList);
	int totalPoint = 0;
	
	void initGame(){
		frameList.add(new Frame(0));
		frameList.add(new Frame(1));
		frameList.add(new Frame(2));
		frameList.add(new Frame(3));
		frameList.add(new Frame(4));
		frameList.add(new Frame(5));
		frameList.add(new Frame(6));
		frameList.add(new Frame(7));
		frameList.add(new Frame(8));
		frameList.add(new Frame(9));
		
	}
	public void playGame() {
		for(int i = 0; i< 10; i++){
			String no ;
			if(i == 0){
				no = "First"; 
			} else if(i ==1){
				no = "second";
			} else {
				no = (i+1) + "th";
			}
			System.out.println("Play "+ no +" frame");
			if(i == 9){
				frameList.get(i).playOneFrame(i);
			}else {
				frameList.get(i).playOneFrame(i);
			}
			printFrame();
			printBoard();
			
			cal.calculateGame();
			
			totalPoint = cal.total;
			System.out.println("total Point: "+totalPoint);
			
		}
	}
	@Override
	public String toString() {
		return "Game [frameList=" + frameList + "]";
	}
	
	public void printBoard() {
		Frame frame;
		for(int i = 0; i < 10; i++){
			System.out.print("|");
			frame = frameList.get(i); 
			
			if(frame.box0.getSymbol() != ScoreSymbol.NONE){
				System.out.print(frame.box0.getSymbol().getSymbol());
			} else {
				System.out.print(frame.box0.getScore());
			}
			System.out.print("|");
			
			if(frame.box1.getSymbol() != ScoreSymbol.NONE){
				System.out.print(frame.box1.getSymbol().getSymbol());
			} else {
				System.out.print(frame.box1.getScore());
			}
			
		}
		System.out.println();
		System.out.println("------------------------------------------");

	}
	void printFrame(){
		System.out.println("------------------------------------------");
		for(int i = 0; i< 10; i++){
			System.out.print("| "+ (i+1)+" ");
			
		}
		System.out.print("|");
		System.out.println();
	}	
	
	
	
	
}

