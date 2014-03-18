package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board extends BoardSuper {

	private Square[][] board;
	private final static Board INSTANCE = new Board();;
	private List<Piece> piecesOnBoard;
	private Piece selectedPiece = null;
	private int playerTurnToMove=-1;
	private Move lastPlayerMove= null;
	private Move lastCpuMove= null;
	

	
	private Board() {
		super();
		setUpBoard();

	}
	
	public void setUpBoard(){
		board = new Square[8][8];

		// creating square cells
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				board[i][j] = new Square(i, j);
			}
		}

		// joining cells left and right
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 7; j++) {
				board[i][j].setRight(board[i][j + 1]);
				board[i][j + 1].setLeft(board[i][j]);

			}
		}

		// joining cells up and down
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 7; j++) {
				board[j][i].setDown(board[j + 1][i]);
				board[j + 1][i].setUp(board[j][i]);
			}
		}

		// creating pawns
		for (int i = 0; i < 8; i++) {
			board[1][i].setPiece(new Pawn(1, board[1][i]));
			board[6][i].setPiece(new Pawn(0, board[6][i]));
		}

		board[0][0].setPiece(new Rook(1, board[0][0]));
		board[0][7].setPiece(new Rook(1, board[0][7]));
		board[7][0].setPiece(new Rook(0, board[7][0]));
		board[7][7].setPiece(new Rook(0, board[7][7]));

		board[0][1].setPiece(new Knight(1, board[0][1]));
		board[0][6].setPiece(new Knight(1, board[0][6]));
		board[7][1].setPiece(new Knight(0, board[7][1]));
		board[7][6].setPiece(new Knight(0, board[7][6]));

		board[0][2].setPiece(new Bishop(1, board[0][2]));
		board[0][5].setPiece(new Bishop(1, board[0][5]));
		board[7][2].setPiece(new Bishop(0, board[7][2]));
		board[7][5].setPiece(new Bishop(0, board[7][5]));

		board[0][3].setPiece(new Queen(1, board[0][3]));
		board[7][3].setPiece(new Queen(0, board[7][3]));

		board[0][4].setPiece(new King(1, board[0][4]));
		board[7][4].setPiece(new King(0, board[7][4]));

		piecesOnBoard = new ArrayList<Piece>();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[i][j].getPiece() != null) {
					piecesOnBoard.add(board[i][j].getPiece());
				}

			}
		}
	}

	public static Board getInstance() {

		return INSTANCE;
	}

	public void makeMove(Move m) {
		Square end = m.getEndPositon();
		Square start = m.getStartPositon();
		Piece p = m.getPiece();
		
		if(m.getEndPositon().getPiece() !=null){
			m.setCapturedPiece(m.getEndPositon().getPiece());
		}
		
		end.setPiece(p);
		start.setPiece(null);
		p.setLocation(end);
		
		if (p instanceof Pawn){
			((Pawn) p ).changeNumberOfMoves(1);
		}
		
		//this.lastPlayerMove=m;
		
	}

	public void undoMove(Move m) {
		m.getStartPositon().setPiece(m.getPiece());
		m.getPiece().setLocation(m.getStartPositon());
		m.getEndPositon().setPiece(null);
		
		if (m.getCapturedPiece()!=null){
			m.getEndPositon().setPiece(m.getCapturedPiece());
		}
			
		if(m.getPiece() instanceof Pawn){
			((Pawn) m.getPiece()).changeNumberOfMoves(-1);
		}

	}

	public Square[][] getBoard() {
		return board;
	}

	public Square getSquare(int i, int j) {
		return board[i][j];
	}

	public List<Piece> getPiecesOnBoard() {
		return piecesOnBoard;
	}

	public Piece getSelectedPiece() {
		return selectedPiece;
	}

	public void setSelectedPiece(Piece selectedPiece) {
		this.selectedPiece = selectedPiece;
	}

	public Piece getPieceAtSquare(int i, int j) {
		return board[i][j].getPiece();
	}

	/**
	 * @return the playerTurnToMove
	 */
	public int getPlayerTurnToMove() {
		return playerTurnToMove;
	}
	
	public void changePlayer(int player){
		player= 1-player;
	}

	
	public boolean undoPreviousMoves(){
		if(lastCpuMove==null || lastPlayerMove==null){
			return false;
		}
		
		undoMove(lastCpuMove);
		undoMove(lastPlayerMove);
		
		lastCpuMove=null;
		lastPlayerMove=null;
		
		return true;
	}
	
	
	public Square[][] cloneBoard(){
		Square[][] cloned = new Square[board.length][];
		for (int i=0;i<board.length;i++){
			cloned[i] = board[i].clone();
		}
		return cloned;
	}

	/**
	 * @return the lastPlayerMove
	 */
	public Move getLastPlayerMove() {
		return lastPlayerMove;
	}

	/**
	 * @param lastPlayerMove the lastPlayerMove to set
	 */
	public void setLastPlayerMove(Move lastPlayerMove) {
		this.lastPlayerMove = lastPlayerMove;
	}

	/**
	 * @return the lastCpuMove
	 */
	public Move getLastCpuMove() {
		return lastCpuMove;
	}

	/**
	 * @param lastCpuMove the lastCpuMove to set
	 */
	public void setLastCpuMove(Move lastCpuMove) {
		this.lastCpuMove = lastCpuMove;
	}
	
	public void clearBoard(){
		for(int i=0 ; i<8;i++){
			for(int j=0 ; j<8;j++){
				board[i][j].setPiece(null);
			}
		}
	}
	
	
}
