package bowling2014;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ball {
	final int full = 10;
	
	int getScore(int boundary){
		boundary =  full - boundary;
		int score = -1;
		
		System.out.println("input score");
		Scanner scan = new Scanner(System.in);//여기에서 입력을 안받는 이유. 
		try{
			while(true){
				score = scan.nextInt();
				if(score <= boundary){
					break;
				}
				
				score = -1;
				System.out.println("input proper score");
			}
		}catch(InputMismatchException e){
			e.printStackTrace();
			System.out.println("input integer");
			System.out.println("game closed because developer doesn't know how to get this routine start again ");
		}
		
//		scan.close();//닫으라고 배웠는데 왜 닫으면 에러가 나지;
		return score;
	}
	

	
}
