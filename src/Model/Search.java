package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Search {
	
	final private static int globalDepth=3;
	
	public static Move maxMove=null;
	private static Move bestMove;
	static int count=0;
	
	
	public static ArrayList<Move> getAvailableMoves(int player){
		ArrayList<Move> moves = new ArrayList<Move>();
		
		
		if(player==0){
			for(Piece p: Board.getInstance().getWhitePieces()){
				moves.addAll(p.generateMoves());
			}
		}else{
			for(Piece p: Board.getInstance().getBlackPieces()){
				moves.addAll(p.generateMoves());
			}
		}
		
		
		return moves;
	}
	
	
	
	public static Move decision(Move root){
		
		bestMove=null;	
		
		ArrayList<Move> moves = KingSafety.safeMoves(getAvailableMoves(1), 1);
		
		/*if(moves.isEmpty()){
			System.out.println("check mate");
			
		}*/
		
		for(Move m : moves){
			Board.getInstance().makeMove(m);
			m.setMoveScore(alphaBetaMin(-1000000, 100000, globalDepth));
			Board.getInstance().undoMove(m);
		}
		
		//System.out.println(moves.size());
		
		Collections.sort(moves, new MoveComparator());
		
		//alphaBetaPrune(globalDepth, root, -1000000, 1000000, 1);
		//return bestMove;
		
		/*for(Move m : moves){
			System.out.println(m.getMoveScore());
		}
		System.out.println("****");*/
		return moves.get(0);
	}
	
	public Move depthFirst(){
		Move m = null;
		ArrayList<Move> moves = KingSafety.safeMoves(getAvailableMoves(1), 1);
		for(Move move:moves){
			Board.getInstance().makeMove(move);
			int eval = Evaluate.evaluate();
			Board.getInstance().undoMove(move);
			
			
		}	
		
		return m;
	}
	
	
	public static int alphaBetaMax(int alpha , int beta , int depth){
		ArrayList<Move> moves = getAvailableMoves(1);
		if(depth==0){
			return Evaluate.evaluate();
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
		ArrayList<Move> moves = getAvailableMoves(0);
		if( depth==0){
			return (Evaluate.evaluate());
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
