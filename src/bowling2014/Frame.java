package bowling2014;

public class Frame {
	ScoreBox box0 = new ScoreBox();
	ScoreBox box1 = new ScoreBox();
	ScoreBox box2;
	int frameNo;
	boolean isFirstBoxFilled = false;//첫 박스가 채워지면 true
	boolean isFrameEnd = false;//점수 입력이 끝나야 true로 변환.
	boolean isCalculateEnd = false;//점수 계산이 끝나야 true로 변환. 
	boolean isSecondBoxFilled = false;//두번째 박스가 채워지면 true
	
	Frame(int frameNo){
		this.frameNo = frameNo;
	}
	
	public int getFrameNo() {
		return frameNo;
	}
	/**
	 * 프레임 하나를 플레이 하는 함수. 
	 * @param frameNo
	 */
	void playOneFrame(int frameNo){
		fillScoreBox(0, frameNo);
		setFirstBoxFilled(true);
		fillScoreBox(1, frameNo);
		setSecondBoxFilled(true);
		setFrameEnd(true);
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
			if(frameNo != 9){
				if(firstScore == 10) {
					return;
				}
				
				box1.setScore(firstScore);
				if(box1.getScore() + box0.getScore() == 10){
					box1.setSymbol(ScoreSymbol.SPARE);
				}
				return;
			}
			//10번 프레임이면 
			box2 = new ScoreBox();
			 if(box0.getScore()==10 ){
				 box1.setScore(0);
				 box2.setScore(0);
			 } else {//10점이 아닐 때.
				box1.setScore(box0.getScore());
				if(getFrameScore() == 10){
					box1.setSymbol(ScoreSymbol.SPARE);
					box2.setScore(0);
				}
			 }
			return;
		} 

	}
	
	/**
	 * 스트라이크를 확인하는 함수 
	 * @return
	 */
	boolean isStrike(){
		if(box0.getSymbol() == ScoreSymbol.STRIKE) 
			return true;
		return false;
	}
	/**
	 * 스페어를 확인하는 함수. 
	 * @return
	 */
	boolean isSpare(){
		if(box1.getSymbol() == ScoreSymbol.SPARE)
			return true;
		return false;
	}
	
	ScoreBox getBox0() {
		return box0;
	}

	ScoreBox getBox1() {
		return box1;
	}

	boolean isFirstBoxFilled() {
		return isFirstBoxFilled;
	}
	void setFirstBoxFilled(boolean isFirstBoxFilled) {
		this.isFirstBoxFilled = isFirstBoxFilled;
	}
	boolean isFrameEnd() {
		return isFrameEnd;
	}
	void setFrameEnd(boolean isFrameEnd) {
		this.isFrameEnd = isFrameEnd;
	}
	boolean isSecondBoxFilled() {
		return isSecondBoxFilled;
	}
	void setSecondBoxFilled(boolean isSecondBoxFilled) {
		this.isSecondBoxFilled = isSecondBoxFilled;
	}
	boolean isCalculateEnd() {
		return isCalculateEnd;
	}
	void setCalculateEnd(boolean isCalculateEnd) {
		this.isCalculateEnd = isCalculateEnd;
	}
	
	int getBox0Score(){
		return box0.getScore();
	}
	
	int getFrameScore(){
		return box0.getScore()+ box1.getScore();
	}
}
