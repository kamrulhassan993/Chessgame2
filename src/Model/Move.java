package Model;

public class Move {
	
	private Square startPositon;
	private Square endPositon;
	private Piece piece;
	private Piece capturedPiece=null;
	private int moveScore;
	
	/**
	 * creates an object which holds the information for the board to be able to make a move
	 * @param startPositon the start location for the move
	 * @param endPositon the end location for the move
	 * @param piece the piece being moved
	 */
	public Move(Square startPositon, Square endPositon, Piece piece) {
		this.startPositon = startPositon;
		this.endPositon = endPositon;
		this.piece = piece;
	}


	/**
	 * 
	 * @return the start location of the move
	 */
	public Square getStartPositon() {
		return startPositon;
	}


	/**
	 * 
	 * @param startPositon sets the start location of the piece
	 */
	public void setStartPositon(Square startPositon) {
		this.startPositon = startPositon;
	}


	/**
	 * 
	 * @return the end location for the pieces
	 */
	public Square getEndPositon() {
		return endPositon;
	}

	/**
	 * 
	 * @param endPositon sets the end location for the move being made
	 */
	public void setEndPositon(Square endPositon) {
		this.endPositon = endPositon;
	}


	/**
	 * 
	 * @return the piece that is being moved
	 */
	public Piece getPiece() {
		return piece;
	}

	/**
	 * 
	 * @param piece sets the piece being moved
	 */
	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	/**
	 * 
	 * @return returns the piece captured by the move if any has been captured
	 */
	public Piece getCapturedPiece() {
		return capturedPiece;
	}


	/**
	 * 
	 * @param capturedPiece gets the captured piece
	 */
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
	
	
	/**
	 * 
	 * @param startPositon the start location for the move
	 * @param endPositon the end location for the move 
	 * @param piece the piece being moved
	 */
	public void setMove(Square startPositon , Square endPositon , Piece piece ){
		this.startPositon=startPositon;
		this.endPositon=endPositon;
		this.piece=piece;
	}
	
	

}
