package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author Kamrul
 *
 */
public class Board extends BoardSuper {

	private Square[][] board;
	private final static Board INSTANCE = new Board();;
	private List<Piece> whitePieces;
	private List<Piece> blackPieces;
	private Piece selectedPiece = null;
	private int playerTurnToMove=-1;
	private Move lastPlayerMove= null;
	private Move lastCpuMove= null;
	


	private Board() {
		super();
		setUpBoard();

	}
	
	
	/**
	 * creates the board with the pieces at the current set locations
	 */
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

		whitePieces = new ArrayList<Piece>();
		blackPieces = new ArrayList<Piece>();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[i][j].getPiece() != null && board[i][j].getPiece().getPlayer()==0) {
					whitePieces.add(board[i][j].getPiece());
				}else if(board[i][j].getPiece() != null && board[i][j].getPiece().getPlayer()==1){
					blackPieces.add(board[i][j].getPiece());
				}

			}
		}
	}

	/**
	 * 
	 * @return the singleton instance of the board class
	 */
	public static Board getInstance() {

		return INSTANCE;
	}

	/**
	 * make the move that is being passed as a parameter 
	 * @param m the move being made
	 */
	public void makeMove(Move m) {
		Square end = m.getEndPositon();
		Square start = m.getStartPositon();
		Piece p = m.getPiece();
		
		if(m.getEndPositon().getPiece() !=null){
			m.setCapturedPiece(m.getEndPositon().getPiece());
			int cap = m.getCapturedPiece().getPlayer();
				removePiece(m.getCapturedPiece(), cap);
		}
		
		end.setPiece(p);
		start.setPiece(null);
		p.setLocation(end);
		
		if (p instanceof Pawn){
			((Pawn) p ).changeNumberOfMoves(1);
		}
		
		//this.lastPlayerMove=m;
		
	}

	/**
	 * undos the move which has been passed as parameter 
	 * @param m the move being undone 
	 */
	public void undoMove(Move m) {
		m.getStartPositon().setPiece(m.getPiece());
		m.getPiece().setLocation(m.getStartPositon());
		m.getEndPositon().setPiece(null);
		
		
		if (m.getCapturedPiece()!=null){
			m.getEndPositon().setPiece(m.getCapturedPiece());
			int cap = m.getCapturedPiece().getPlayer();
			addPiece(m.getCapturedPiece(), cap);
			
		}
			
		if(m.getPiece() instanceof Pawn){
			((Pawn) m.getPiece()).changeNumberOfMoves(-1);
		}

	}

	
	/**
	 * @return the square multidimensional
	 */
	public Square[][] getBoard() {
		return board;
	}

	
	/**
	 * @param i the y coordinate for the square
	 * @param j the x coordinate for the square
	 * @return the square object on the board at location i and j
	 */
	public Square getSquare(int i, int j) {
		return board[i][j];
	}

	
	/**
	 * 
	 * @return the piece that is currently selected 
	 */
	public Piece getSelectedPiece() {
		return selectedPiece;
	}

	/**
	 * 
	 * @param selectedPiece set the selected pieces to this piece
	 */
	public void setSelectedPiece(Piece selectedPiece) {
		this.selectedPiece = selectedPiece;
	}

	/**
	 * 
	 * @param i y coordinate for the board
	 * @param j x coordinate for the board 
	 * @return the piece on the board at location i and j
	 */
	public Piece getPieceAtSquare(int i, int j) {
		return board[i][j].getPiece();
	}

	/**
	 * @return the playerTurnToMove
	 */
	public int getPlayerTurnToMove() {
		return playerTurnToMove;
	}
	
	/**
	 * 
	 * @param player changes the player to the current players opposing player
	 */
	public void changePlayer(int player){
		player= 1-player;
	}

	/**
	 * 
	 * @return true if undo move is possible , false if not
	 */
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
	
	/**
	 * clears the board by setting all pieces to null
	 */
	public void clearBoard(){
		for(int i=0 ; i<8;i++){
			for(int j=0 ; j<8;j++){
				board[i][j].setPiece(null);
			}
		}
		
		whitePieces.clear();
		blackPieces.clear();
	}
	
	
	
	
	/**
	 * @return the whitePieces currently on the boards
	 */
	public List<Piece> getWhitePieces() {
		return whitePieces;
	}

	/**
	 * @return the blackPieces currently on the board
	 */
	public List<Piece> getBlackPieces() {
		return blackPieces;
	}

	
	/**
	 * adds the piece to a list of pieces that is currently on the board
	 * @param p the piece being added to the list
	 * @param player the player for which the piece belongs to
	 */
	public void addPiece(Piece p, int player){
		if(player==0){
			whitePieces.add(p);
			
		}else{
			blackPieces.add(p);
		}
		
	}
	
	/**
	 * removes the pieces from a list of pieces currently on the board
	 * @param p the piece being removed from the list
	 * @param player the player for which the piece belongs to
	 */
	public void removePiece(Piece p, int player){
		if(player==0){
			whitePieces.remove(p);
			
		}else{
			blackPieces.remove(p);
		}
		
	}
	
	public List<Piece> getPiecesOnBoard(int player){
		if(player==0){
			return whitePieces;
		}else {
			return blackPieces;
		}
		
	}
	
	
}
