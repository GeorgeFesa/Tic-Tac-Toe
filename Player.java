public class Player {
	
	private String name;
	private String XorO;
	private boolean turn;

	public Player(String name, String XorO) {
		this.name = name;
		this.XorO = XorO;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getXorO() {
		return this.XorO;
	}
	
	public boolean getTurn() {
		return this.turn;
	}
	
	public void setTurn(boolean turn) {
		this.turn = turn;
	}

}
