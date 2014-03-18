package Model;

import java.util.Comparator;

public class MoveComparator implements Comparator<Move> {

	@Override
	public int compare(Move m1, Move m2) {
		if(m1.getMoveScore()> m2.getMoveScore()){
			return -1;
		}else if (m1.getMoveScore()< m2.getMoveScore()){
			return 1;
		}else{
			return 0;
		}
	}
	
}
