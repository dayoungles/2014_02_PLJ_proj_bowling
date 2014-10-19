package bowling2014;

public class PrintBoard {
	void printFrame(){
		System.out.println("--------------------------------------------");
		for(int i = 0; i< 10; i++){
			System.out.print("| "+ (i+1)+" ");
			
		}
		System.out.print("|");
		System.out.println();
		System.out.println("---------------------------------------------");
	}
	
	void printGame(Game game){
//		System.out.print("|");
//		for(int i = 0; i < 10; i++){
//			Frame frame = game.frameList.get(i);
//			for(int j = 0; j < 2; j++){
//				
//				if(j == 0 ){//구문 반복. 함수로 뺄것. 
//					frame.box0.printBox();
//				}else {
//					frame.box1.printBox();
//				}
//				System.out.print("|");
//				
//			}
//		}
	}
}
