package Model;

import java.util.ArrayList;

/**
 * @author Kamrul
 *
 */
public interface Piece {
	
	
	/**
	 * @return a list moves that the piece can make
	 */
	public ArrayList<Move> generateMoves();
	
	/**
	 * @return the numerical value for the player
	 */
	public int getPlayer();
	
	
	/**
	 * @return the character values for the piece  
	 */
	public String getCharValue();
	
	
	/**
	 * @return the square location for the piece
	 */
	public Square getLocation();
	
	/**
	 * 
	 * @param Location the location for the pieces new location
	 */
	public void setLocation(Square Location);
	
	/**
	 * @return the centipawn value for the piece
	 */
	public int getCentiPawnValue();
	
	/**
	 * @return the location value's for the piece
	 */
	public int getPieceSquareValue();

}