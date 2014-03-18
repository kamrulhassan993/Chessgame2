package Model;

import java.util.ArrayList;

public interface Piece {
	public ArrayList<Move> generateMoves();
	public int getPlayer();
	public String getCharValue();
	public Square getLocation();
	public void setLocation(Square Location);
	public int getCentiPawnValue();
	public int getPieceSquareValue();

}