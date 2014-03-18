package Model;

public class Move {
	
	private Square startPositon;
	private Square endPositon;
	private Piece piece;
	private Piece capturedPiece=null;
	private int moveScore;
	
	
	public Move(Square startPositon, Square endPositon, Piece piece) {
		this.startPositon = startPositon;
		this.endPositon = endPositon;
		this.piece = piece;
	}


	public Square getStartPositon() {
		return startPositon;
	}


	public void setStartPositon(Square startPositon) {
		this.startPositon = startPositon;
	}


	public Square getEndPositon() {
		return endPositon;
	}


	public void setEndPositon(Square endPositon) {
		this.endPositon = endPositon;
	}


	public Piece getPiece() {
		return piece;
	}


	public void setPiece(Piece piece) {
		this.piece = piece;
	}


	public Piece getCapturedPiece() {
		return capturedPiece;
	}


	public void setCapturedPiece(Piece capturedPiece) {
		this.capturedPiece = capturedPiece;
	}


	/**
	 * @return the moveScore
	 */
	public int getMoveScore() {
		return moveScore;
	}


	/**
	 * @param moveScore the moveScore to set
	 */
	public void setMoveScore(int moveScore) {
		this.moveScore = moveScore;
	}
	
	public void setMove(Square startPositon , Square endPositon , Piece piece ){
		this.startPositon=startPositon;
		this.endPositon=endPositon;
		this.piece=piece;
	}
	
	

}
