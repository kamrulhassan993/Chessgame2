package Model;

public class IntMove {
	
	private int number;
	private Move bestMove;
	
	public IntMove(){
		this.number =0;
		this.bestMove=null;
		
	}
	
	public IntMove(int number , Move bestMove){
		this.number=number;
		this.bestMove=bestMove;
		
	}
	
	
	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	/**
	 * @return the bestMove
	 */
	public Move getBestMove() {
		return bestMove;
	}
	/**
	 * @param bestMove the bestMove to set
	 */
	public void setBestMove(Move bestMove) {
		this.bestMove = bestMove;
	}
	
	

}
