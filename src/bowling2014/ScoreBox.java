package bowling2014;



public class ScoreBox {
	
	private ScoreSymbol symbol = ScoreSymbol.BASIC;
	private int score;

		
	ScoreSymbol getSymbol(){
		return symbol;
	}

	public void setSymbol(ScoreSymbol symbol) {
		this.symbol = symbol;
	}

	public int getScore() {
		return score;
	}
	/**
	 * 스코어를 스코어박스에 설정하고, 심볼도 설정한다. 
	 * @param boundary
	 */
	public void setScore(int boundary) {
		Ball ball = new Ball();
		score = ball.getScore(boundary);
		setSymbol(score);
	}
	
	void setSymbol(int score){
		switch (score){
			case 10:
				this.symbol = ScoreSymbol.STRIKE;
				break;
			case 0:
				this.symbol = ScoreSymbol.GUTTER;
				break;
			default:
				this.symbol = ScoreSymbol.NONE;
		}
	}
	/**
	 * 심볼이 있는지 확인하는 함수. 
	 * @return
	 */
	boolean isSymbolBasic(){
		if(symbol == ScoreSymbol.BASIC) 
			return true;
		return false;
	}
	/**
	 * 심볼이 있으면 심볼을 출력하고 아니면 스코어의 숫자를 출력. 
	 */
	void printBox(){
		if(isSymbolBasic()){
			System.out.print(getSymbol());
			return;
		}
		System.out.print(score);
		
	}
	
	String getBoxRepresentative(){
		if(this.symbol != ScoreSymbol.NONE ){
			return symbol.getSymbol();
		} 
		return String.valueOf(this.score);
	}
	
	void setBoxRepresentative(int score){
		if(score == 10){
			
		}
	}
	
	@Override
	public String toString() {
		return "ScoreBox [symbol=" + symbol + ", score=" + score + "]";
	}
	
	
}
