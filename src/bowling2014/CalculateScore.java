package bowling2014;

import java.util.ArrayList;

public class CalculateScore {
	int total = 0;
	ArrayList<Frame> game = new ArrayList<Frame>();
	public CalculateScore(ArrayList<Frame> game) {
		this.game = game;
	}
	
	/**
	 * 점수 계산...^^^^^
	 */
	void calculateGame(){
		Frame frame;

		for(int i =0; i< 10; i++){
			if(i == 9){
				calculateTenthFrame();
				break;
			}
			frame = game.get(i);
			if(!frame.isFrameEnd) break;
			if(!frame.isCalculateEnd&& frame.isFrameEnd){
				if(frame.isStrike()){
					if(game.get(i+1).isFrameEnd && !game.get(i+1).isStrike()){
						total += frame.box0.getScore() +   game.get(i+1).box0.getScore()
								+ game.get(i+1).box1.getScore();
					} else if(game.get(i+1).isStrike() && game.get(i+2).isFirstBoxFilled){
						total += (20 + game.get(i+2).box0.getScore());
					} else {
						break;
					}
				} else if(frame.isSpare()){
					if(game.get(i+1).isFirstBoxFilled){
						total += frame.box0.getScore() + frame.box1.getScore() + game.get(i+1).box0.getScore();
					}else {
						break;
					}
				} else {
					total += frame.box0.getScore()+ frame.box1.getScore();
				}
				
				frame.isCalculateEnd = true;
					
			}
				
		}
	}
	
	void under10(){
		
	}
	void strike(){
		
	}
	void spare(){
		
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
