package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

import Model.Board;
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
		Board.getInstance().clearBoard();
		
	
		try{
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = null;
			
			
	        while ((line=br.readLine()) != null) {
	            System.out.println(line);
	        }

			
		}catch(IOException ie){
			ie.printStackTrace();
		}
		
	}
	
	
	
	

}
