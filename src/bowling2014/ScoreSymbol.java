package bowling2014;

public enum ScoreSymbol {
	STRIKE("S", 10),
	SPARE("/"),
	GUTTER("G", 0),
	NONE(" "),
	BASIC(" ");

	
	int value;
	String symbol;
	private ScoreSymbol(String val, int value){
		this.value = value;
		this.symbol = val;
	}
	private ScoreSymbol(String val){
		this.symbol = val;
	}

	public int getValue(){
		return this.value;
	}
	
	public String getSymbol(){
		return this.symbol;
	}
	
	
	
};


