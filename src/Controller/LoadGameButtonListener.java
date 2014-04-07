package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

import Model.Bishop;
import Model.Board;
import Model.King;
import Model.Knight;
import Model.Pawn;
import Model.Piece;
import Model.PieceFactory;
import Model.Queen;
import Model.Rook;
import Model.Square;
import View.BoardView;

public class LoadGameButtonListener implements ActionListener {

	private BoardView bv;
	private final JFileChooser fc = new JFileChooser();
	private File file;
	
	public LoadGameButtonListener(BoardView bv){
		this.bv=bv;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		fc.setCurrentDirectory(new File("./"));
		int val = fc.showOpenDialog(null);
		
		if(val == JFileChooser.APPROVE_OPTION){
			file = fc.getSelectedFile();
			System.out.println(file.getPath());
		}
		
		readFromFile();

	}
	
	
	public void readFromFile() {
		
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = null;
			
			String[][] savedata= new String[8][8];
			int lineNum =0;
	        while ((line=br.readLine()) != null) {
	            savedata[lineNum] = line.split(" ");
	            lineNum++;
	        }
	        
	        PieceFactory pf = new PieceFactory();
	        
	        Square[][] board = Board.getInstance().getBoard();
	        for(int i=0;i<8;i++){
	        	for(int j=0;j<8;j++){
	        		Piece p= pf.createPiece(savedata[i][j], board[i][j]);
		        	board[i][j].setPiece(p);
		        }	
	        }
	        
	        
	        for(int i=2;i<6;i++){
	        	for(int j=0;j<8; j++){
	        		Square sq = board[i][j];
	        		if(sq.getPiece()!=null && sq.getPiece() instanceof Pawn){
	        			((Pawn) sq.getPiece() ).changeNumberOfMoves(1);
	        		}
	        		
	        	}
	        	
	        }
	        
			bv.setUpBoard();
	        
	        br.close();
		}catch(IOException ie){
			ie.printStackTrace();
		}
		
	}
	
	
	
	
	

}
