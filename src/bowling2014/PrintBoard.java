package bowling2014;

import java.util.ArrayList;

public class PrintBoard {
	final static int maxFrameNum = 10;
	
	static void printFrame(){
		System.out.println("------------------------------------------");
		for(int i = 0; i< maxFrameNum; i++){
			System.out.print("| "+ (i+1)+" ");
		}
		System.out.println("|");
		
	}	

	
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
