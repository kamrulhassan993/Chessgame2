package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Evaluate {
	
	public static int evaluate( ){
		
		int score=0;
		int score2= 0;
		int matScore = evaluateMaterial(1);
		
		//black player
		score+= matScore;
		score+= evaluatePosition(1 , matScore);
		score+= bishopPair(1);
		
		//score+= evaluateAvailableMoves(player, moves);
		
		
		//white player
		matScore = evaluateMaterial(0);
		score2+= matScore;
		score2+= evaluatePosition(0, matScore);
		score2+= bishopPair(0);
		//score2+= evaluateAvailableMoves(player, moves);
		return score-score2;
	}
	
	private static int evaluateMaterial(int player){
		int mat = 0;
		List<Piece> pieces = Board.getInstance().getPiecesOnBoard(player);
		for(Piece p: pieces){
			mat+= p.getCentiPawnValue();
		}
		
		return mat;
	}
	
	private static int evaluatePosition(int player, int mat){
		int pos=0;
		
		
		List<Piece> pieces = Board.getInstance().getPiecesOnBoard(1-player);
		
		for(Piece p : pieces){
			if(p instanceof King && mat<=2500){
				pos+= ((King)p).getKingEndgame();
			}else{
				pos+= p.getPieceSquareValue();
			}
			
		}
		
		
		
		return pos;
	}
	
	public static int bishopPair(int player){
		List<Piece> pieces = Board.getInstance().getPiecesOnBoard(player);
		String bishop;
		int count=0;
		if(player==0){
			bishop="wb";
		}else{
			bishop="bb";
		}
		
		for(Piece p : pieces){
			if(p.getCharValue().equals(bishop)){
				count++;
			}
		}
		
		if(count==1){
			return -100;
		}
		return 0;
	}
	
	private static int evaluateAvailableMoves(int player , ArrayList<Move> moves) {
		int score=0;
		score = moves.size()*5;
		return score;
	}
	
	
	
}
