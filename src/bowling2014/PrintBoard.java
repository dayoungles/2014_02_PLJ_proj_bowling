package bowling2014;

import java.util.ArrayList;

public class PrintBoard {
	final static int maxFrameNum = 10;
	/**
	 * 점수판의 프레임,  상단을 출력. 
	 */
	static void printFrame(){
		System.out.println("------------------------------------------");
		for(int i = 0; i< maxFrameNum; i++){
			System.out.print("| "+ (i+1)+" ");
		}
		System.out.println("|");
		
	}	

	/**
	 * 점수판의 점수 부를 출력하는 함수. 
	 * @param boardList
	 */
	void printBoardList(ArrayList<String> boardList) {
		int size = boardList.size();
		for(int i = 0; i< size; i++){
			System.out.print("|" + boardList.get(i));
		}
		System.out.print("|");
		for(int i = 0; i< maxFrameNum*2-size; i++){
			System.out.print(" |");
		}
		System.out.println();
	}
	/**
	 * 몇번째 프레임인지 알려주는 함수. 
	 * @param i
	 */
	void printInformation(int i){
		String no ;
		if(i == 0){
			no = "First"; 
		} else if(i ==1){
			no = "second";
		} else {
			no = (i+1) + "th";
		}
		System.out.println("Play "+ no +" frame");
	}
}
