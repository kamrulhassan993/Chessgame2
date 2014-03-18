package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.Board;
import View.BoardView;

public class NewGameButtonListener implements ActionListener {

	private BoardView bv;
	
	public NewGameButtonListener(BoardView bv){
		this.bv=bv;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object[] options = {"Yes" , "No"};
		int n = JOptionPane.showOptionDialog(null, 
				"do you want to start a new game?",
				"New game?", 
				JOptionPane.YES_NO_CANCEL_OPTION, 
				JOptionPane.QUESTION_MESSAGE, 
				null, options, options[1]);
		if(n==0){
			Board.getInstance().setUpBoard();
			bv.setUpBoard();
		}
		
		
	}

}
