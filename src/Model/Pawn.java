package Model;

import java.util.ArrayList;

public class Pawn implements Piece {

	private int player;
	private boolean hasMoved = false;
	private Square location;
	private int numberOfmoves = 0;
	private Move move = new Move(null, null, null);
	
	private int[][] pieceSquareValueBlack = {
			{0,  0,  0,  0,  0,  0,  0,  0}	,
			{5, 10, 10,-20,-20, 10, 10,  5} ,
			{5, -5,-10,  0,  0,-10, -5,  5} ,
			{0,  0,  0, 20, 20,  0,  0,  0} ,
			{5,  5, 10, 25, 25, 10,  5,  5} ,
			{10, 10, 20, 30, 30, 20, 10, 10},
			{50, 50, 50, 50, 50, 50, 50, 50},
			{0,  0,  0,  0,  0,  0,  0,  0}
			
	};
	
	private int[][] pieceSquareValueWhite = {
		
			{0,  0,  0,  0,  0,  0,  0,  0},
			{50, 50, 50, 50, 50, 50, 50, 50},
			{10, 10, 20, 30, 30, 20, 10, 10},
			{5,  5, 10, 25, 25, 10,  5,  5},
			{0,  0,  0, 20, 20,  0,  0,  0},
			{5, -5,-10,  0,  0,-10, -5,  5},
			{5, 10, 10,-20,-20, 10, 10,  5},
			{0,  0,  0,  0,  0,  0,  0,  0}
			
	};
	
	
	
	public Pawn(int player, Square location) {
		this.player = player;
		this.location = location;

		
	}

	@Override
	public ArrayList<Move> generateMoves() {
		ArrayList<Move> moves = new ArrayList<Move>();
		if (player == 0) {
			// forward movement
			if (location.getUp() != null) {

				if (location.getUp().getPiece() == null) {
					moves.add(new Move(location, location.getUp(),this));
					if (numberOfmoves==0
							&& location.getUp().getUp().getPiece() == null) {
						moves.add(new Move(location, location.getUp().getUp(),this));
						
					}
				}


				// left movement
				if (location.getUp().getLeft() != null
						&& location.getUp().getLeft().getPiece() != null
						&& location.getUp().getLeft().getPiece().getPlayer() != 0) {
					moves.add(new Move(location, location.getUp().getLeft(), this));
				}
				// right movement
				if(location.getUp().getRight() !=null
						&& location.getUp().getRight().getPiece() !=null
						&& location.getUp().getRight().getPiece().getPlayer() !=0){
					moves.add(new Move(location, location.getUp().getRight(), this));
					
				}

			}

			// forward left movement

		} else {
			// forward movement
			if (location.getDown() != null ) {
				if(location.getDown().getPiece() == null){
					moves.add(new Move(location, location.getDown(), this));
					if (numberOfmoves == 0
							&& location.getDown().getDown().getPiece() == null) {
						moves.add(new Move(location, location.getDown().getDown(),this));
					}
				}
				
				// left movement
				if (location.getDown().getLeft() != null
						&& location.getDown().getLeft().getPiece() != null
						&& location.getDown().getLeft().getPiece().getPlayer() != 1) {
					moves.add(new Move(location, location.getDown().getLeft(), this));
				}
				// right movement
				if(location.getDown().getRight() !=null
						&& location.getDown().getRight().getPiece() !=null
						&& location.getDown().getRight().getPiece().getPlayer() !=1){
					moves.add(new Move(location, location.getDown().getRight(), this));
					
				}
				
			}
		}
				

		return moves;
	}

	@Override
	public int getPlayer() {
		return player;
	}

	@Override
	public String getCharValue() {
		return (player == 0) ? "wp" : "bp";
	}

	public void hasMoved() {
		if (!hasMoved)
			hasMoved = true;
	}

	public boolean getHasMoved() {
		return hasMoved;
	}

	public Square getLocation() {
		return location;
	}

	public void setLocation(Square location) {
		this.location = location;
	}
	
	public void changeNumberOfMoves(int num){
		numberOfmoves+=num;
	}

	@Override
	public int getCentiPawnValue() {
		return 100;
	}

	@Override
	public int getPieceSquareValue() {
		return (player==0)? pieceSquareValueWhite[location.getI()][location.getJ()]
				:pieceSquareValueBlack[location.getI()][location.getJ()];
	} 

}
