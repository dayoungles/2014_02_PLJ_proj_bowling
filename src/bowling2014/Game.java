package bowling2014;

import java.util.ArrayList;

public class Game {
	ArrayList<Frame> frameList = new ArrayList<Frame>();
	CalculateScore cal = new CalculateScore(frameList);
	int totalPoint = 0;
	ArrayList<String> boardList = new ArrayList<String>();
	
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
		PrintBoard printBoard = new PrintBoard();
		for(int i = 0; i< 10; i++){
			printBoard.printInformation(i);
			
			frameList.get(i).playOneFrame(i);//플레이 프레임 하나.
			
			//프레임 하나의 결과인 스코어 박스를 긁어서 스코어 보드에 집어넣어놓는다. 
			inputPointToBoard(i);
			PrintBoard.printFrame(); 
			printBoard.printBoardList(boardList);
			
			// total += cal.calculateGame();
			
			totalPoint += cal.calculateGame();
			System.out.println("total Point: "+totalPoint);
		}
	}
	
	private void inputPointToBoard(int i) {
		String playResult1;
		String playResult2;
		
		
		playResult1 = frameList.get(i).getBox0().getBoxRepresentative();
		playResult2 = frameList.get(i).getBox1().getBoxRepresentative();
		boardList.add(playResult1);
		boardList.add(playResult2);
		
		if(i == 9){
			if(frameList.get(i).box0.getScore() == 10 || frameList.get(i).box1.getSymbol() == ScoreSymbol.SPARE){
				boardList.add(frameList.get(i).box2.getBoxRepresentative());
			}
		}
	}

	@Override
	public String toString() {
		return "Game [frameList=" + frameList + "]";
	}


	
	
	
	
}

