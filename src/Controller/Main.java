package Controller;

import View.BoardView;
import View.ChessFrame;

public class Main {
	
	static BoardView bv;
	
	public static void main(String[] args) {
		bv = new BoardView();
		ChessFrame frame = new ChessFrame(bv);
		
		
		frame.addNewGameButtonListener(new NewGameButtonListener(bv));
		frame.addUndoMoveButtonListener(new UndoMoveButtonListener(bv));
		frame.addSaveButtonListener(new SaveButtonListener(bv));
		frame.addLoadButtonListener(new LoadGameButtonListener(bv));
		
		

		
	}
	
	
	
	
}
