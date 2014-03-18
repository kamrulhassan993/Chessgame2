package Model;

import java.util.ArrayList;

public class Evaluate {
	
	public static int evaluate(int player ,ArrayList<Move> moves){
		int score=0;
		int matScore = evaluateMaterial(player);
		score+= matScore;
		score+= evaluatePosition(player , matScore);
		score+= evaluateAvailableMoves(player, moves);
		
		matScore = evaluateMaterial(1-player);
		score-= matScore;
		score-= evaluatePosition(1-player, matScore);
		score-= evaluateAvailableMoves(player, moves);
		return -score;
	}
	
	public static int evaluateMaterial(int player){
		int mat = 0;
		Square[][] b = Board.getInstance().getBoard();
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				Square sq = b[i][j];
				if(sq.getPiece()!=null && sq.getPiece().getPlayer()!=player){
					mat+=sq.getPiece().getCentiPawnValue();	
				}
			}
		}
		return mat;
	}
	
	public static int evaluatePosition(int player, int mat){
		int pos=0;
		Square[][] b = Board.getInstance().getBoard();
		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				Square sq = b[i][j];
				
				if(sq.getPiece()!=null && sq.getPiece().getPlayer()!=player){
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
	
	public static int evaluateAvailableMoves(int player , ArrayList<Move> moves) {
		int score=0;
		score = moves.size()*5;
		return score;
	}
	
}
