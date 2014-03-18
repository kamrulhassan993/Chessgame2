package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.BoardView;

public class SaveButtonListener implements ActionListener {

	
	private BoardView bv;
	
	public SaveButtonListener(BoardView bv){
		this.bv=bv;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("aaa");
	}

}
