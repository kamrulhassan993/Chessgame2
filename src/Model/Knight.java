package Model;

import java.util.ArrayList;

public class Knight implements Piece{

	private int player;
	private Square location;
	
	private int[][] pieceSquareValueWhite={
			{-50,-40,-30,-30,-30,-30,-40,-50},
			{-40,-20,  0,  0,  0,  0,-20,-40},
			{-30,  0, 10, 15, 15, 10,  0,-30},
			{-30,  5, 15, 20, 20, 15,  5,-30},
			{-30,  0, 15, 20, 20, 15,  0,-30},
			{-30,  5, 10, 15, 15, 10,  5,-30},
			{-40,-20,  0,  5,  5,  0,-20,-40},
			{-50,-40,-30,-30,-30,-30,-40,-50}
	};
	
	private int[][] pieceSquareValueBlack={
			{-50,-40,-30,-30,-30,-30,-40,-50},
			{-40,-20,  0,  5,  5,  0,-20,-40},
			{-30,  5, 10, 15, 15, 10,  5,-30},
			{-30,  0, 15, 20, 20, 15,  0,-30},
			{-30,  5, 15, 20, 20, 15,  5,-30},
			{-30,  0, 10, 15, 15, 10,  0,-30},
			{-40,-20,  0,  0,  0,  0,-20,-40},
			{-50,-40,-30,-30,-30,-30,-40,-50}
	};
	
	
	
	public Knight(int player, Square location) {
		this.player = player;
		this.location=location;
	}

	@Override
	public ArrayList<Move> generateMoves() {
		ArrayList<Move> moves = new ArrayList<Move>();
		
		moves.addAll(getUpMoves());
		moves.addAll(getDownMoves());
		moves.addAll(getLeftMoves());
		moves.addAll(getRightMoves());
		
		return moves;
	}

	@Override
	public int getPlayer() {
		return player;
	}

	@Override
	public String getCharValue() {
		return (player==0)?"wn":"bn";
	}

	public Square getLocation() {
		return location;
	}

	public void setLocation(Square location) {
		this.location = location;
	}
	
	public ArrayList<Move> getUpMoves (){
		ArrayList<Move> moves = new ArrayList<Move>();
		if(location.getUp()!=null  && location.getUp().getUp()!=null ){
			if(location.getUp().getUp().getRight()!=null){
				if(location.getUp().getUp().getRight().getPiece()==null){
					moves.add(new Move(location, location.getUp().getUp().getRight(), this));
				}else if (location.getUp().getUp().getRight().getPiece().getPlayer()!=player){
					moves.add(new Move(location, location.getUp().getUp().getRight(), this));
				}
			}
			
			if(location.getUp().getUp().getLeft()!=null){
				if(location.getUp().getUp().getLeft().getPiece()==null){
					moves.add(new Move(location, location.getUp().getUp().getLeft(), this));
				}else if (location.getUp().getUp().getLeft().getPiece().getPlayer()!=player){
					moves.add(new Move(location, location.getUp().getUp().getLeft(), this));
				}
			}
		}
		return moves;
	}
	
	
	public ArrayList<Move> getDownMoves (){
		ArrayList<Move> moves = new ArrayList<Move>();
		if(location.getDown()!=null  && location.getDown().getDown()!=null ){
			if(location.getDown().getDown().getRight()!=null){
				if(location.getDown().getDown().getRight().getPiece()==null){
					moves.add(new Move(location, location.getDown().getDown().getRight(), this));
				}else if (location.getDown().getDown().getRight().getPiece().getPlayer()!=player){
					moves.add(new Move(location, location.getDown().getDown().getRight(), this));
				}
			}
			
			if(location.getDown().getDown().getLeft()!=null){
				if(location.getDown().getDown().getLeft().getPiece()==null){
					moves.add(new Move(location, location.getDown().getDown().getLeft(), this));
				}else if (location.getDown().getDown().getLeft().getPiece().getPlayer()!=player){
					moves.add(new Move(location, location.getDown().getDown().getLeft(), this));
				}
			}
		}
		return moves;
	}
	
	public ArrayList<Move> getLeftMoves (){
		ArrayList<Move> moves = new ArrayList<Move>();
		if(location.getLeft()!=null && location.getLeft().getLeft()!=null){
			if(location.getLeft().getLeft().getUp()!=null){
				if(location.getLeft().getLeft().getUp().getPiece()==null){
					moves.add(new Move(location, location.getLeft().getLeft().getUp(), this));
				}else if (location.getLeft().getLeft().getUp().getPiece().getPlayer()!=player){
					moves.add(new Move(location, location.getLeft().getLeft().getUp(), this));
				}
			}
			
			if(location.getLeft().getLeft().getDown()!=null){
				if(location.getLeft().getLeft().getDown().getPiece()==null){
					moves.add(new Move(location, location.getLeft().getLeft().getDown(), this));
				}else if (location.getLeft().getLeft().getDown().getPiece().getPlayer()!=player){
					moves.add(new Move(location, location.getLeft().getLeft().getDown(), this));
				}
			}
		}
		return moves;
	}
	
	public ArrayList<Move> getRightMoves (){
		ArrayList<Move> moves = new ArrayList<Move>();
		if(location.getRight()!=null && location.getRight().getRight()!=null){
			if(location.getRight().getRight().getUp()!=null){
				if(location.getRight().getRight().getUp().getPiece()==null){
					moves.add(new Move(location, location.getRight().getRight().getUp(), this));
				}else if (location.getRight().getRight().getUp().getPiece().getPlayer()!=player){
					moves.add(new Move(location, location.getRight().getRight().getUp(), this));
				}
			}
			
			if(location.getRight().getRight().getDown()!=null){
				if(location.getRight().getRight().getDown().getPiece()==null){
					moves.add(new Move(location, location.getRight().getRight().getDown(), this));
				}else if (location.getRight().getRight().getDown().getPiece().getPlayer()!=player){
					moves.add(new Move(location, location.getRight().getRight().getDown(), this));
				}
			}
		}
		return moves;
	}

	@Override
	public int getCentiPawnValue() {
		return 400;
	}

	public int getPieceSquareValue() {
		return (player==0)? pieceSquareValueWhite[location.getI()][location.getJ()]
				:pieceSquareValueBlack[location.getI()][location.getJ()];
	}
	
	

}
