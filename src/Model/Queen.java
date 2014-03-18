package Model;

import java.util.ArrayList;

public class Queen implements Piece{

	private int player;
	private Square location;
	
	private int[][] pieceSquareValueWhite={
		{-20,-10,-10, -5, -5,-10,-10,-20},
		{-10,  0,  0,  0,  0,  0,  0,-10},
		{-10,  0,  5,  5,  5,  5,  0,-10},
		{ -5,  0,  5,  5,  5,  5,  0, -5},
		{0,  0,  5,  5,  5,  5,  0, -5},
		{-10,  5,  5,  5,  5,  5,  0,-10},
		{-10,  0,  5,  0,  0,  0,  0,-10},
		{-20,-10,-10, -5, -5,-10,-10,-20}
	};
	
	private int[][] pieceSquareValueBlack={
		{-20,-10,-10, -5, -5,-10,-10,-20},
		{-10,  0,  5,  0,  0,  0,  0,-10},
		{-10,  5,  5,  5,  5,  5,  0,-10},
		{0,  0,  5,  5,  5,  5,  0, -5},
		{ -5,  0,  5,  5,  5,  5,  0, -5},
		{-10,  0,  5,  5,  5,  5,  0,-10},
		{-10,  0,  0,  0,  0,  0,  0,-10},
		{-20,-10,-10, -5, -5,-10,-10,-20},
	};
	
	public Queen(int player, Square location) {
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
		moves.addAll(MoveCalculator.genUpRight(location, player, this));
		moves.addAll(MoveCalculator.genDownRight(location, player, this));
		moves.addAll(MoveCalculator.genDownLeft(location, player, this));
		moves.addAll(MoveCalculator.genUpLeft(location, player, this));
		return moves;
	}

	@Override
	public int getPlayer() {
		return player;
	}

	@Override
	public String getCharValue() {
		return (player==0)? "wq":"bq";
	}

	public Square getLocation() {
		return location;
	}

	public void setLocation(Square location) {
		this.location = location;
	}

	@Override
	public int getCentiPawnValue() {
		return 1350;
	}

	public int getPieceSquareValue() {
		return (player==0)? pieceSquareValueWhite[location.getI()][location.getJ()]
				:pieceSquareValueBlack[location.getI()][location.getJ()];
	} 
	
	
}
