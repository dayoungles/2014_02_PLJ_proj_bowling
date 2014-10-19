package bowling2014;



public class ScoreBox {
	
	private ScoreSymbol symbol = ScoreSymbol.NONE;
	private int score;
	
	String getSymbolString() {
		return symbol.getSymbol();
	}
		
	ScoreSymbol getSymbol(){
		return symbol;
	}

	public void setSymbol(ScoreSymbol symbol) {
		this.symbol = symbol;
	}

	public int getScore() {
		return score;
	}

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
		}
	}
	/**
	 * 심볼이 있는지 확인하는 함수. 
	 * @return
	 */
	boolean isSymbolExist(){
		if(symbol == ScoreSymbol.NONE) 
			return false;
		return true;
	}
	/**
	 * 심볼이 있으면 심볼을 출력하고 아니면 스코어의 숫자를 출력. 
	 */
	void printBox(){
		if(isSymbolExist()){
			System.out.print(getSymbol());
			return;
		}
		System.out.print(score);
		
	}
	@Override
	public String toString() {
		return "ScoreBox [symbol=" + symbol + ", score=" + score + "]";
	}
}
