package bowling2014;

public class ScoreBox {
	
	private ScoreSymbol symbol = ScoreSymbol.BASIC;
	private int score;

		
	ScoreSymbol getSymbol(){
		return symbol;
	}
	/**
	 * 심볼 세팅. 
	 * @param symbol
	 */
	public void setSymbol(ScoreSymbol symbol) {
		this.symbol = symbol;
	}
	/**
	 * @return 필드의 스코어를 리턴.
	 */
	public int getScore() {
		return this.score;
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
	
	/**
	 * 스코어에 따라서 심볼을 설정.
	 * setScore()안에서 실행한다. 
	 * @param score
	 */
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
	 * @return 심볼이 있으면 심볼을 리턴하고, 심볼이 없으면 스코어를 리턴한다.
	 */
	String getBoxRepresentative(){
		if(this.symbol != ScoreSymbol.NONE ){
			return symbol.getSymbol();
		} 
		return String.valueOf(this.score);
	}
	
	
}
