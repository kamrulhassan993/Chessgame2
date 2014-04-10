package Model;

public class Square {
	private Square up=null;
	private Square down=null;
	private Square left=null;
	private Square right=null;
	private Piece piece = null;
	
	
	private final int i,j;
	
	public Square(int i, int j){
		this.i=i;
		this.j=j;
	}


	public Square getUp() {
		return up;
	}


	public void setUp(Square up) {
		this.up = up;
	}


	public Square getDown() {
		return down;
	}


	public void setDown(Square down) {
		this.down = down;
	}


	public Square getLeft() {
		return left;
	}


	public void setLeft(Square left) {
		this.left = left;
	}


	public Square getRight() {
		return right;
	}


	public void setRight(Square right) {
		this.right = right;
	}


	public Piece getPiece() {
		return piece;
	}


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
