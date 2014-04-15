package Model;

public class PieceFactory {
	
	public PieceFactory(){
		
	}
	
	/**
	 * 
	 * @param charval the text value for the piece that user wants to create
	 * @param location the location for the piece being created
	 * @return returns a new piece object of type Piece wanted 
	 */
	public Piece createPiece(String charval, Square location){
		Piece p = null;
		
		if(charval.equals("bp")){
			p= new Pawn(1, location); 
		}else if(charval.equals("bk")){
			p= new King(1, location);
		}else if(charval.equals("bq")){
			p= new Queen(1, location);
		}else if(charval.equals("bn")){
			 p= new Knight(1, location);
		}else if(charval.equals("br")){
			p= new Rook(1, location);
		}else if(charval.equals("bb")){
			p= new Bishop(1, location);
		}else if(charval.equals("wp")){
			p= new Pawn(0, location); 
		}else if(charval.equals("wk")){
			p= new King(0, location); 
		}else if(charval.equals("wq")){
			 p= new Queen(0, location); 
		}else if(charval.equals("wn")){
			p= new Knight(0, location); 
		}else if(charval.equals("wr")){
			p= new Rook(0, location); 
		}else if(charval.equals("wb")){
			p= new Bishop(0, location); 
		}
		
		
		return p; 
	}
	
	
	
	

}
