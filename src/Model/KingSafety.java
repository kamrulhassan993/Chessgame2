package Model;

import java.util.ArrayList;

public class KingSafety {
	
	public static boolean kingSafe(Move friendlyMove , int player){
		//System.out.println("aaaa");
		Board.getInstance().makeMove(friendlyMove);
		ArrayList<Move> moves = Search.getAvailableMoves(1-player);
		for(Move mv: moves){
			Board.getInstance().makeMove(mv);
			if(mv.getCapturedPiece()!=null){
				if(mv.getCapturedPiece() instanceof King){
					Board.getInstance().undoMove(mv);
					Board.getInstance().undoMove(friendlyMove);
					return false;
				}
			}
			
			Board.getInstance().undoMove(mv);
		}
		
		Board.getInstance().undoMove(friendlyMove);
		return true;
	}
	
	public static ArrayList<Move> safeMoves(ArrayList<Move> generatedMoves, int player){
		ArrayList<Move> safeMoves = new ArrayList<Move>();
		for(Move m: generatedMoves){
			if(kingSafe(m, player)){
				safeMoves.add(m);
			}
		}
		return safeMoves;
	}
	
}
