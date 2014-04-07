package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Evaluate {
	
	public static int evaluate(int player ,ArrayList<Move> moves){
		
		
		
		
		int score=0;
		int score2= 0;
		int matScore = evaluateMaterial(player);
		
		score+= matScore;
		score+= evaluatePosition(player , matScore);
		score+= evaluateAvailableMoves(player, moves);
		
		matScore = evaluateMaterial(1-player);
		score2+= matScore;
		score2+= evaluatePosition(1-player, matScore);
		score2+= evaluateAvailableMoves(player, moves);
		return score-score2;
	}
	
	private static int evaluateMaterial(int player){
		int mat = 0;
		
		/*for(Piece p: pieces){
			mat+= p.getCentiPawnValue();
			
		}*/
		Square[][] b = Board.getInstance().getBoard();
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				Square sq = b[i][j];
				if(sq.getPiece()!=null && sq.getPiece().getPlayer()==player){
					mat+=sq.getPiece().getCentiPawnValue();	
				}
			}
		}
		
		
		return mat;
	}
	
	private static int evaluatePosition(int player, int mat){
		int pos=0;
		Square[][] b = Board.getInstance().getBoard();
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				Square sq = b[i][j];
				
				if(sq.getPiece()!=null && sq.getPiece().getPlayer()==player){
					if(sq.getPiece() instanceof King && mat<=2500 ){
						pos+=((King) sq.getPiece()).getKingEndgame();
					}else{
						pos+=sq.getPiece().getPieceSquareValue();
					}
				}
			}
		}
		return pos;
	}
	
	private static int evaluateAvailableMoves(int player , ArrayList<Move> moves) {
		int score=0;
		score = moves.size()*5;
		return score;
	}
	
	
	
}
