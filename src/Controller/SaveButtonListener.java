package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

import Model.Board;
import Model.Square;
import View.BoardView;

public class SaveButtonListener implements ActionListener {

	
	private BoardView bv;
	private JFileChooser fc = new JFileChooser();
	
	public SaveButtonListener(BoardView bv){
		this.bv=bv;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		fc.setCurrentDirectory(new File("./"));
		int val = fc.showOpenDialog(null);
		if(val == JFileChooser.APPROVE_OPTION){
		}
		
		writeToSaveFile(fc.getSelectedFile().toString());
	}
	
	public void writeToSaveFile(String filelocation) {
		try{
			BufferedWriter out = new BufferedWriter(new FileWriter(filelocation + ".sav"));
			System.out.println(filelocation);
			
			Square[][] board = Board.getInstance().getBoard();
			for(int i=0;i<8;i++){
				String line ="";
				for(int j=0;j<8;j++){
					if(board[i][j].getPiece()!=null){
						line +=board[i][j].getPiece().getCharValue() + " ";
					}else{
						line += "ee ";
					}
				}
				line =line.trim();
				out.write(line);
				out.newLine();
			}
			out.close();
			
		}catch(IOException ie){
			ie.printStackTrace();
		}
				
	} 

}
