package bowling2014;

public class Frame {
	ScoreBox box0 = new ScoreBox();
	ScoreBox box1 = new ScoreBox();
	ScoreBox box2;
	int frameNo;
	boolean isFirstBoxFilled = false;
	boolean isFrameEnd = false;//점수 입력이 끝나야 true로 변환.
	boolean isCalculateEnd = false;//점수 계산이 끝나야 true로 변환. 
	boolean isSecondBoxFilled = false;
	
	Frame(int frameNo){
		this.frameNo = frameNo;
	}
	public int getFrameNo() {
		return frameNo;
	}
	
	void playOneFrame(int frameNo){
		fillScoreBox(0, frameNo);
		isFirstBoxFilled = true;
		fillScoreBox(1, frameNo);
		isSecondBoxFilled = true;
		isFrameEnd = true;
		
	}
	
	

	/**
	 * frame의 각 스코어박스를 채우는 함수. 이미 프레임안의 scorebox0, 1이 각각 필드로 구성되어 있음
	 * 이 함수에서 많은 일을 하고 있음. 분리 필요할 듯. 
	 * @param throwBoxNo
	 */
	void fillScoreBox(int throwBoxNo, int frameNo){
		if(throwBoxNo == 0){
			box0.setScore(0);
			return;
		} 
		if(throwBoxNo ==1){
			int firstScore = box0.getScore();
			if(firstScore == 10 && frameNo != 9) 
				return;
			else if(firstScore != 10 && frameNo != 9){
				box1.setScore(firstScore);
				if(box1.getScore() + box0.getScore() == 10){
					box1.setSymbol(ScoreSymbol.SPARE);
				}
			} else if(frameNo == 9){
				box2 = new ScoreBox();
				 if(box0.getScore()==10 ){
					 box1.setScore(0);
					 box2.setScore(0);
				 } else {//10점이 아닐 때.
					 box1.setScore(box0.getScore());
					if(box1.getScore() + box0.getScore() == 10){
						box1.setSymbol(ScoreSymbol.SPARE);
						box2 = new ScoreBox();
						box2.setScore(0);
					}
				 }
			}
			return;
		} 

	}

	boolean isStrike(){
		if(box0.getSymbol() == ScoreSymbol.STRIKE) 
			return true;
		return false;
	}
	
	boolean isSpare(){
		if(box1.getSymbol() == ScoreSymbol.SPARE)
			return true;
		return false;
	}
	@Override
	public String toString() {
		return "Frame [box0=" + box0 + ", box1=" + box1 + ", box2=" + box2
				+ "]";
	}
	
	
	
	

}
