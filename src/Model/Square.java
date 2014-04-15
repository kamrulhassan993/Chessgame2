package Model;

public class Square {
	private Square up=null;
	private Square down=null;
	private Square left=null;
	private Square right=null;
	private Piece piece = null;
	
	
	private final int i,j;
	
	/**
	 * 
	 * @param i y coordinate for this squares location 
	 * @param j x coordinate for this squares location
	 */
	public Square(int i, int j){
		this.i=i;
		this.j=j;
	}


	/**
	 * 
	 * @return the square which is connected to the top of this square
	 */
	public Square getUp() {
		return up;
	}


	/**
	 * 
	 * @param up set the square which is connected to the top of this square
	 */
	public void setUp(Square up) {
		this.up = up;
	}


	
	/**
	 * 
	 * @return the square which is connected to the bottom of this square
	 */
	public Square getDown() {
		return down;
	}


	/**
	 * 
	 * @param down sets the square which is connected to the bottom of this square
	 */
	public void setDown(Square down) {
		this.down = down;
	}

	

	/**
	 * 
	 * @return the square which is connected to the left of this square
	 */
	public Square getLeft() {
		return left;
	}


	/**
	 * 
	 * @param left sets the square which is connected to the left of this square
	 */
	public void setLeft(Square left) {
		this.left = left;
	}


	/**
	 * 
	 * @return the square which is connected to the right of this square
	 */
	public Square getRight() {
		return right;
	}


	/**
	 * 
	 * @param right the square which is connected to the right of this square
	 */
	public void setRight(Square right) {
		this.right = right;
	}


	/**
	 * 
	 * @return the piece that is currently on this square
	 */
	public Piece getPiece() {
		return piece;
	}

	/**
	 * 
	 * @param piece sets the piece that is currently on this square
	 */
	public void setPiece(Piece piece) {
		this.piece = piece;
	}


	/**
	 * @return the i
	 */
	public int getI() {
		return i;
	}


	/**
	 * @return the j
	 */
	public int getJ() {
		return j;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		Square sq = (Square) obj;
		if(this.i!=sq.getI() && this.j!=sq.getJ()){
			return false;
		}
		return true;
	} 
	
	
	
	
	
	
	
	
}
