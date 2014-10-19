package bowling2014;

import java.util.Scanner;

public class Ball {
	final int full = 10;
	
	int getScore(int boundary){
		boundary =  full - boundary;
		int score = -1;
		
		System.out.println("input score");
		Scanner scan = new Scanner(System.in);//여기에서 입력을 안받는 이유. 
		while(true){
			score = scan.nextInt();
			if(score <= boundary){
				break;
			}
			
			score = -1;
			System.out.println("input proper score");
		}
//		scan.close();//닫으라고 배웠는데 왜 닫으면 에러가 나지;
		return score;
	}
	

	
}
