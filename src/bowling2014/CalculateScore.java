package bowling2014;

import java.util.ArrayList;

public class CalculateScore {
	int total = 0;
	ArrayList<Frame> game = new ArrayList<Frame>();
	
	public CalculateScore(ArrayList<Frame> game) {
		this.game = game;
	}
	
	/**
	 * 점수 계산...^^^^^미치겠다
	 * 일단은  isCalculated를 사용해서 수정할 수 있는 여지가 있음. 분명.
	 * 잔다.
	 */
	void calculateGame(int totalPoint){
		Frame frame;

		for(int i =0; i< 10; i++){
			if(i == 9){
				calculateTenthFrame();
				break;
			}
			frame = game.get(i);
			if(!frame.isFrameEnded()) break;
			
			if(!frame.isCalEnded() && frame.isFrameEnded()){
				if(frame.isStrike()){
					strike(i);
				} else if(frame.isSpare()){
					spare(i);
				} else {
					underTen(i);
				}
				
				frame.isCalculateEnd = true;
					
			}
				
		}
	}
	
	void underTen(int i){
		total += game.get(i).box0.getScore()+ game.get(i).box1.getScore();

	}
	
	void strike(int i){
		if(game.get(i+1).isFrameEnd && !game.get(i+1).isStrike()){
			total += game.get(i).box0.getScore() +   game.get(i+1).box0.getScore()
					+ game.get(i+1).box1.getScore();
		} else if(game.get(i+1).isStrike() && game.get(i+2).isFirstBoxFilled){
			total += (20 + game.get(i+2).box0.getScore());
		} else {
			return;
		}
	}
	void spare(int i){
		if(game.get(i+1).isFirstBoxFilled){
			total += game.get(i).box0.getScore() + game.get(i).box1.getScore() + game.get(i+1).box0.getScore();
		}else {
			return;
		}
	}

	void calculateTenthFrame() {
		
		Frame frame = game.get(9);
		if(frame.isStrike()){
			total += frame.box0.getScore() + frame.box1.getScore()+ frame.box2.getScore();
		} else if(frame.isSpare()){
			total += frame.box0.getScore() + frame.box1.getScore() + frame.box2.getScore();
		} else {
			total += frame.box0.getScore()+ frame.box1.getScore();
		}
		
		frame.isCalculateEnd = true;
	}
	
}
