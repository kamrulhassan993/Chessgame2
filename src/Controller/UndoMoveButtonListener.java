package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Model.Board;
import View.BoardView;

public class UndoMoveButtonListener implements ActionListener {

	
	private BoardView boardView;
	

	public UndoMoveButtonListener(BoardView boardView) {
		super();
		this.boardView = boardView;
	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		boolean previousMove = Board.getInstance().undoPreviousMoves();
		
		if(previousMove){
			boardView.setUpBoard();
		}else{
			JOptionPane.showMessageDialog(null, "only one undo move allowed");
		}

	}

}
