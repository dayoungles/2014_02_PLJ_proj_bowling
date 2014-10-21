package bowling2014;

import java.util.ArrayList;

public class CalculateScore {
	ArrayList<Frame> game = new ArrayList<Frame>();
	
	public CalculateScore(ArrayList<Frame> game) {
		this.game = game;
	}

	int calculateGame(){
		Frame frame;
		int score = 0;
		int size = game.size();
		for(int i = 0; i < size; i++){
			frame = game.get(i);
			if(frame.isCalculateEnd()){
				continue;
			}
			if(!frame.isFrameEnd()){
				break;
			}
			//10점 이하일 때는 계산해서 토탈을 리턴.
			if(frame.getFrameScore() < 10){
				score = calUnderTen(frame, score);
				continue;
			}
			//스페어 일 때는 다음 프레임의 isfirstfilled ==true일 때 다음 프레임의 그 값을 찾아서 더해준다. 
			if(frame.isSpare()){
				if(i == 9){
					score += frame.getFrameScore()+ frame.box2.getScore();
					frame.isCalculateEnd();
					continue;
				}
				if(!game.get(i+1).isFirstBoxFilled())
					break;
				
				score = calSpare(frame, score, i);
				continue;
				
				
			}
			//스트라이크일 때는 다음 프레임이 끝났는지 확인한다. + 다음 프레임의 1번이 스트라이크가 아닐 때-> 계산한다.
			//스트라이크 일 때는 다음 프레임이 끝났는지 확인한다 + 다음 프레임의 1번이 스트라이크면 > 다다음 프레임의 1번이 찼는지 확인한다. 
			//찼으면 계산, 안 찼으면 break;
			if(frame.isStrike()){
				if(i == 9){
					score += frame.getFrameScore() + frame.box2.getScore();
					frame.isCalculateEnd();
					continue;
				}
				if(!game.get(i+1).isFrameEnd())
					break;

				if(!game.get(i+1).isStrike()){
					frame.setCalculateEnd(true);
					score+= frame.getFrameScore() + game.get(i+1).getFrameScore();
					continue;
				} 
				if(i < 8){
					if(!game.get(i+2).isFirstBoxFilled)
						break;
					frame.setCalculateEnd(true);
					score += frame.getFrameScore() + game.get(i+1).getFrameScore() + game.get(i+2).getBox0Score();
				}else if(i == 8){
					if(!game.get(i+1).isSecondBoxFilled())
						break;
					frame.setCalculateEnd(true);
					score += frame.getFrameScore() + game.get(i+1).getFrameScore();
				}
			}
		}
		return score;
	}

	private int calSpare(Frame frame, int score, int i) {
		score +=  frame.getFrameScore() + game.get(i+1).getBox0Score();
		frame.setCalculateEnd(true);
		return score;
	}

	private int calUnderTen(Frame frame, int score) {
		score += frame.getFrameScore();
		frame.setCalculateEnd(true);
		return score;
	}
	
	
	


	void calculateTenthFrame() {
		int score;
		Frame frame = game.get(9);
		if(frame.isStrike()){
			score = frame.box0.getScore() + frame.box1.getScore()+ frame.box2.getScore();
		} else if(frame.isSpare()){
			score = frame.box0.getScore() + frame.box1.getScore() + frame.box2.getScore();
		} else {
			score = frame.box0.getScore()+ frame.box1.getScore();
		}
		
		frame.isCalculateEnd = true;
	}
	
}
