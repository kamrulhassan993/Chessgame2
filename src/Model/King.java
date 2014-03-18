package Model;

import java.util.ArrayList;

public class King implements Piece {

	private int player;
	private Square location;
	
	private int[][] pieceSquareValueWhite={
		{-30,-40,-40,-50,-50,-40,-40,-30},
		{-30,-40,-40,-50,-50,-40,-40,-30},
		{-30,-40,-40,-50,-50,-40,-40,-30},
		{-30,-40,-40,-50,-50,-40,-40,-30},
		{-20,-30,-30,-40,-40,-30,-30,-20},
		{-10,-20,-20,-20,-20,-20,-20,-10},
		{ 20, 20,  0,  0,  0,  0, 20, 20},
		{20, 30, 10,  0,  0, 10, 30, 20}	
	};
	
	private int[][] pieceSquareValueBlack={
		{20, 30, 10,  0,  0, 10, 30, 20},
		{ 20, 20,  0,  0,  0,  0, 20, 20},
		{-10,-20,-20,-20,-20,-20,-20,-10},
		{-20,-30,-30,-40,-40,-30,-30,-20},
		{-30,-40,-40,-50,-50,-40,-40,-30},
		{-30,-40,-40,-50,-50,-40,-40,-30},
		{-30,-40,-40,-50,-50,-40,-40,-30},
		{-30,-40,-40,-50,-50,-40,-40,-30}
	};
	
	private int[][] kingEndGameWhite={
		{-50,-40,-30,-20,-20,-30,-40,-50},
		{-30,-20,-10,  0,  0,-10,-20,-30},
		{-30,-10, 20, 30, 30, 20,-10,-30},
		{-30,-10, 30, 40, 40, 30,-10,-30},
		{-30,-10, 30, 40, 40, 30,-10,-30},
		{-30,-10, 20, 30, 30, 20,-10,-30},
		{-30,-30,  0,  0,  0,  0,-30,-30},
		{-50,-30,-30,-30,-30,-30,-30,-50}
	};
	
	private int[][] kingEndGameBlack={
		{-50,-30,-30,-30,-30,-30,-30,-50},
		{-30,-30,  0,  0,  0,  0,-30,-30},
		{-30,-10, 20, 30, 30, 20,-10,-30},
		{-30,-10, 30, 40, 40, 30,-10,-30},
		{-30,-10, 30, 40, 40, 30,-10,-30},
		{-30,-10, 20, 30, 30, 20,-10,-30},
		{-30,-20,-10,  0,  0,-10,-20,-30},
		{-50,-40,-30,-20,-20,-30,-40,-50}
	};
	
	public King(int player, Square location){
		this.player=player;
		this.location=location;
	}
	
	@Override
	public ArrayList<Move> generateMoves() {
		ArrayList<Move> moves = new ArrayList<Move>();
		
		//up , up right , up left
		if(location.getUp()!=null){
			if(location.getUp().getPiece()==null || location.getUp().getPiece().getPlayer()!=player){
				moves.add(new Move(location, location.getUp(),this ));
			}
			
			if(location.getUp().getRight()!=null 
					&& (location.getUp().getRight().getPiece()==null 
					|| location.getUp().getRight().getPiece().getPlayer()!=player ) ){
				moves.add(new Move(location, location.getUp().getRight(),this ));
			}
			
			if(location.getUp().getLeft()!=null 
					&& (location.getUp().getLeft().getPiece()==null 
					|| location.getUp().getLeft().getPiece().getPlayer()!=player ) ){
				moves.add(new Move(location, location.getUp().getLeft(),this ));
				
			}
		}
		
		// down , down left , down right 
		if(location.getDown()!=null){
			if(location.getDown().getPiece()==null || location.getDown().getPiece().getPlayer()!=player){
				moves.add(new Move(location, location.getDown(),this ));
			}
			
			if(location.getDown().getRight()!=null 
					&& (location.getDown().getRight().getPiece()==null 
					|| location.getDown().getRight().getPiece().getPlayer()!=player ) ){
				moves.add(new Move(location, location.getDown().getRight(),this ));
			}
			
			if(location.getDown().getLeft()!=null 
					&& (location.getDown().getLeft().getPiece()==null 
					|| location.getDown().getLeft().getPiece().getPlayer()!=player ) ){
				moves.add(new Move(location, location.getDown().getLeft(),this ));
			}
		}
		
		//left
		if(location.getLeft()!=null){
			if(location.getLeft().getPiece()==null || location.getLeft().getPiece().getPlayer()!=player){
				moves.add(new Move(location, location.getLeft(),this ));
			}
		}

		//right
		if(location.getRight()!=null){
			if(location.getRight().getPiece()==null || location.getRight().getPiece().getPlayer()!=player){
				moves.add(new Move(location, location.getRight(),this ));
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
		return (player==0)?"wk":"bk";
	}

	public Square getLocation() {
		return location;
	}

	public void setLocation(Square location) {
		this.location = location;
	}

	@Override
	public int getCentiPawnValue() {
		return 400;
	}

	public int getPieceSquareValue() {
		return (player==0)? pieceSquareValueWhite[location.getI()][location.getJ()]
				:pieceSquareValueBlack[location.getI()][location.getJ()];
	}
	
	public int getKingEndgame(){
		return (player==0)? kingEndGameWhite[location.getI()][location.getJ()]
				:kingEndGameBlack[location.getI()][location.getJ()];
	}
	

}
