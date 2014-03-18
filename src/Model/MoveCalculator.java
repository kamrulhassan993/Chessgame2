package Model;

import java.util.ArrayList;

public class MoveCalculator {

	
	public static ArrayList<Move> genUp(Square initialLocation, int player , Piece p){
		ArrayList<Move> moves = new ArrayList<Move>();
		Square loc = initialLocation;
		while(loc.getUp()!=null){
			if(loc.getUp().getPiece()==null){
				moves.add(new Move(initialLocation, loc.getUp(), p));
			}else{
				if(loc.getUp().getPiece().getPlayer()==player){
					return moves;
				}else{
					moves.add(new Move(initialLocation, loc.getUp(), p));
					return moves;
				}
			}
			loc=loc.getUp();
		}
		
		return moves;
	}
	
	public static ArrayList<Move> genDown(Square initialLocation, int player , Piece p){
		ArrayList<Move> moves = new ArrayList<Move>();
		Square loc = initialLocation;
		while(loc.getDown()!=null){
			if(loc.getDown().getPiece()==null){
				moves.add(new Move(initialLocation, loc.getDown(), p));
			}else{
				if(loc.getDown().getPiece().getPlayer()==player){
					return moves;
				}else{
					moves.add(new Move(initialLocation, loc.getDown(), p));
					return moves;
				}
			}
			loc=loc.getDown();
		}
		
		return moves;
	}
	
	public static ArrayList<Move> genLeft(Square initialLocation, int player , Piece p){
		ArrayList<Move> moves = new ArrayList<Move>();
		Square loc = initialLocation;
		while(loc.getLeft()!=null){
			if(loc.getLeft().getPiece()==null){
				moves.add(new Move(initialLocation, loc.getLeft(), p));
			}else{
				if(loc.getLeft().getPiece().getPlayer()==player){
					return moves;
				}else{
					moves.add(new Move(initialLocation, loc.getLeft(), p));
					return moves;
				}
			}
			loc=loc.getLeft();
		}
		
		return moves;
	}
	
	public static ArrayList<Move> genRight(Square initialLocation, int player , Piece p){
		ArrayList<Move> moves = new ArrayList<Move>();
		Square loc = initialLocation;
		while(loc.getRight()!=null){
			if(loc.getRight().getPiece()==null){
				moves.add(new Move(initialLocation, loc.getRight(), p));
			}else if(loc.getRight().getPiece().getPlayer()==player){
				return moves;
			}else{ 
					moves.add(new Move(initialLocation, loc.getRight(), p));
					return moves;
			}
			
			loc=loc.getRight();
		}
		
		return moves;
	}
	
	
	public static ArrayList<Move> genUpRight(Square initialLocation, int player , Piece p){
		ArrayList<Move> moves = new ArrayList<Move>();
		Square nextSquare = initialLocation;
			while(nextSquare.getUp()!=null || nextSquare.getRight()!=null){
				if(nextSquare.getUp()==null || nextSquare.getRight()==null ||nextSquare.getUp().getRight()==null){
					return moves;
				}else if(nextSquare.getUp().getRight().getPiece()==null){
					moves.add(new Move(initialLocation, nextSquare.getUp().getRight(), p));
				}else if (nextSquare.getUp().getRight().getPiece().getPlayer()==player){
					return moves;
				}else{
					moves.add(new Move(initialLocation, nextSquare.getUp().getRight(), p));
					return moves;
				}
				nextSquare = nextSquare.getUp();
				nextSquare = nextSquare.getRight();
			}
		return moves;
	}
	
	public static ArrayList<Move> genDownRight(Square initialLocation, int player , Piece p){
		ArrayList<Move> moves = new ArrayList<Move>();
		Square nextSquare = initialLocation;
			while(nextSquare.getDown()!=null || nextSquare.getRight()!=null){
				if(nextSquare.getDown()==null || nextSquare.getRight()==null ||nextSquare.getDown().getRight()==null){
					return moves;
				}else if(nextSquare.getDown().getRight().getPiece()==null){
					moves.add(new Move(initialLocation, nextSquare.getDown().getRight(), p));
				}else if (nextSquare.getDown().getRight().getPiece().getPlayer()==player){
					return moves;
				}else{
					moves.add(new Move(initialLocation, nextSquare.getDown().getRight(), p));
					return moves;
				}
				nextSquare = nextSquare.getDown();
				nextSquare = nextSquare.getRight();
			}
		return moves;
	}
	
	public static ArrayList<Move> genDownLeft(Square initialLocation, int player , Piece p){
		ArrayList<Move> moves = new ArrayList<Move>();
		Square nextSquare = initialLocation;
			while(nextSquare.getDown()!=null || nextSquare.getLeft()!=null){
				if(nextSquare.getDown()==null || nextSquare.getLeft()==null ||nextSquare.getDown().getLeft()==null){
					return moves;
				}else if(nextSquare.getDown().getLeft().getPiece()==null){
					moves.add(new Move(initialLocation, nextSquare.getDown().getLeft(), p));
				}else if (nextSquare.getDown().getLeft().getPiece().getPlayer()==player){
					return moves;
				}else{
					moves.add(new Move(initialLocation, nextSquare.getDown().getLeft(), p));
					return moves;
				}
				nextSquare = nextSquare.getDown();
				nextSquare = nextSquare.getLeft();
			}
		return moves;
	}

	public static ArrayList<Move> genUpLeft(Square initialLocation, int player , Piece p){
		ArrayList<Move> moves = new ArrayList<Move>();
		Square nextSquare = initialLocation;
			while(nextSquare.getUp()!=null || nextSquare.getLeft()!=null){
				if(nextSquare.getUp()==null || nextSquare.getLeft()==null ||nextSquare.getUp().getLeft()==null){
					return moves;
				}else if(nextSquare.getUp().getLeft().getPiece()==null){
					moves.add(new Move(initialLocation, nextSquare.getUp().getLeft(), p));
				}else if (nextSquare.getUp().getLeft().getPiece().getPlayer()==player){
					return moves;
				}else{
					moves.add(new Move(initialLocation, nextSquare.getUp().getLeft(), p));
					return moves;
				}
				nextSquare = nextSquare.getUp();
				nextSquare = nextSquare.getLeft();
			}
		return moves;
	}
	
	
}
