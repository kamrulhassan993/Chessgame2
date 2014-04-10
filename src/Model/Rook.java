package Model;

import java.util.ArrayList;

public class Rook implements Piece {
	
	private int player;
	private Square location;
	
	private int[][] pieceSquareValueWhite={
		 {0,  0,  0,  0,  0,  0,  0,  0},
		 { 5, 10, 10, 10, 10, 10, 10,  5},
		 {-5,  0,  0,  0,  0,  0,  0, -5},
		 {-5,  0,  0,  0,  0,  0,  0, -5},
		 {-5,  0,  0,  0,  0,  0,  0, -5},
		 {-5,  0,  0,  0,  0,  0,  0, -5},
		 {-5,  0,  0,  0,  0,  0,  0, -5},
		 { 0,  0,  0,  5,  5,  0,  0,  0}	
	};
	
	private int[][] pieceSquareValueBlack={
		{ 0,  0,  0,  5,  5,  0,  0,  0},
		{-5,  0,  0,  0,  0,  0,  0, -5},
		{-5,  0,  0,  0,  0,  0,  0, -5},
		{-5,  0,  0,  0,  0,  0,  0, -5},
		{-5,  0,  0,  0,  0,  0,  0, -5},
		{-5,  0,  0,  0,  0,  0,  0, -5},
		{ 5, 10, 10, 10, 10, 10, 10,  5},
		{0,  0,  0,  0,  0,  0,  0,  0}
	};
	
	public Rook(int player, Square location) {
		this.player = player;
		this.location=location;
	}

	@Override
	public ArrayList<Move> generateMoves() {
		ArrayList<Move> moves = new ArrayList<Move>(); 
				
		moves.addAll(MoveCalculator.genUp(location, player, this));
		moves.addAll(MoveCalculator.genDown(location, player, this));
		moves.addAll(MoveCalculator.genLeft(location, player, this));
		moves.addAll(MoveCalculator.genRight(location, player, this));
		
		///something about castling here
		
		return moves;
	}

	@Override
	public int getPlayer() {
		return player;
	}

	@Override
	public String getCharValue() {
		return (player==0)? "wr":"br";
	}

	public Square getLocation() {
		return location;
	}

	public void setLocation(Square location) {
		this.location = location;
	}

	@Override
	public int getCentiPawnValue() {
		return 700;
	}

	public int getPieceSquareValue() {
		return (player==0)? pieceSquareValueWhite[location.getI()][location.getJ()]
				:pieceSquareValueBlack[location.getI()][location.getJ()];
	}
	
	
	
	
	
	
	
	
	
	
}
