package Model;

import java.util.Comparator;

public class MoveOrderComparator implements Comparator<Move> {
	
	
	
	@Override
	public int compare(Move move1, Move move2) {
		int c1 =move1.getPiece().getCentiPawnValue();
		int c2 = move2.getPiece().getCentiPawnValue();
		
		if(move1.getCapturedPiece()!=null){
			c1+=1000;
		}
		
		if(move2.getCapturedPiece()!=null){
			c2+=1000;
		}
		
		return 0 ;
	}

}
