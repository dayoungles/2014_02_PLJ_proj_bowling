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
			
			inputPointToBoard(i);
			PrintBoard.printFrame(); 
			printBoard.printBoardList(boardList);
			
			totalPoint += cal.calculateGame();
			System.out.println("total Point: "+totalPoint);
		}
	}
	/**
	 * 출력을 위한 어레이리스트인 boardList를 따로 채우는 함수.
	 * @param i
	 */
	private void inputPointToBoard(int i) {
		Frame frame = frameList.get(i);
		
		boardList.add(frame.getBox0().getBoxRepresentative());
		boardList.add(frame.getBox1().getBoxRepresentative());
		
		if(i == 9){
			if(frame.box0.getScore() == 10 || frame.box1.getSymbol() == ScoreSymbol.SPARE){
				boardList.add(frame.box2.getBoxRepresentative());
			}
		}
	}

	@Override
	public String toString() {
		return "Game [frameList=" + frameList + "]";
	}


	
	
	
	
}

