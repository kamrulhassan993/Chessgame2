package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Search {
	
	final private static int globalDepth=4;
	
	public static Move maxMove=null;
	private static Move bestMove;
	
	public static ArrayList<Move> getAvailableMoves(int player){
		ArrayList<Move> moves = new ArrayList<Move>();
		ArrayList<Piece> piecesOnBoard = new ArrayList<Piece>();
		Square[][] squares = Board.getInstance().getBoard();
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				if(squares[i][j].getPiece()!=null && squares[i][j].getPiece().getPlayer()==player){
					piecesOnBoard.add(squares[i][j].getPiece());
				}
			}
		}
		
		for(Piece p: piecesOnBoard){
			moves.addAll(p.generateMoves());
		}
		
		
		
		return moves;
	}
	
	public static Move decision(Move root){
		
		/*bestMove = null;
		alphaBetaPrune(globalDepth, root, -1000000, 1000000, 1);
		return bestMove;*/
		ArrayList<Move> moves = getAvailableMoves(1);
		moves= KingSafety.safeMoves(moves, 1);
		for(Move m : moves){
			Board.getInstance().makeMove(m);
			//m.setMoveScore(alphabeta(m, globalDepth, -1000000, 1000000, true));
			//m.setMoveScore(alphaBetaMax(-1000000, 1000000, globalDepth));
			m.setMoveScore(alphaBetaPrune(globalDepth, root, -1000000, 1000000, 1));
			Board.getInstance().undoMove(m);
		}
		
		
		
		Collections.sort(moves, new MoveComparator());
		
		for(Move m: moves){
			System.out.println(m.getMoveScore());
		}
		System.out.println("*******************");
		
		return moves.get(0);
		
	}
	
	public static int alphaBetaPrune(int depth, Move root, int alpha , final int beta, int player){
		
		if(depth==0 ){
			return Evaluate.evaluate(player, getAvailableMoves(player));
		}
		
		ArrayList<Move> availableMoves =getAvailableMoves(player); 
		for(Move currentMove: availableMoves){
			Board.getInstance().makeMove(currentMove);
			final int score = -alphaBetaPrune(depth-1,currentMove, -beta, -alpha, 1-player);
			Board.getInstance().undoMove(currentMove);
			
			if (alpha < score) {
	            alpha = score;
	            bestMove = currentMove;
	        }
	        if (beta <= alpha) {
	            return alpha;
	        }
			
		}
		return alpha;
	
	}
	
	

	
	public static int alphabeta(Move move, int depth,int alpha , int beta , boolean maximizingPlayer){
		ArrayList<Move> availableMoves = getAvailableMoves((maximizingPlayer)? 1:0);
		if( depth==0){
			return Evaluate.evaluate((maximizingPlayer)?1:0, availableMoves);
		}
		if(maximizingPlayer){
			for(Move m : availableMoves){
		
				Board.getInstance().makeMove(m);
				alpha = Math.max(alpha, alphabeta(m, depth-1, alpha, beta, false));
				Board.getInstance().undoMove(m);
				if(alpha>=beta){
		
					return beta;
				}
			}
			return alpha;
		}else{
			for(Move m: availableMoves){
				Board.getInstance().makeMove(m);
				beta = Math.min(beta, alphabeta(m, depth-1, alpha, beta, true));
				Board.getInstance().undoMove(m);
				if(beta <= alpha){
					return alpha;
				}
			}
			return beta;
		}
		
	}
	
	public static int alphaBetaMax(int alpha , int beta , int depth){
		ArrayList<Move> moves = getAvailableMoves(0);
		if(depth==0){
			return Evaluate.evaluate(0, moves);
		}
		
		for(Move m: moves){
			Board.getInstance().makeMove(m);
			int score = alphaBetaMin(alpha, beta, depth-1);
			Board.getInstance().undoMove(m);
			
			if(score>=beta){
				return beta; //beta cutoff 
			}else{
				alpha=score; // new max score
			}
		}
		
		return alpha;
	}
	
	public static int alphaBetaMin(int alpha , int beta , int depth){
		ArrayList<Move> moves = getAvailableMoves(1);
		if( depth==0){
			return -(Evaluate.evaluate(1, moves));
		}
		
		for(Move m: moves){
			Board.getInstance().makeMove(m);
			int score = alphaBetaMax(alpha, beta, depth-1);
			Board.getInstance().undoMove(m);
			
			if(score<=alpha){
				return alpha;
			}else{
				beta=score;
			}
		}
		
		return beta;
	}
	
	
	
	

}
