package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.GameFrame;

public class ReturnToMenuButtonListener implements ActionListener {

	private GameFrame gf;
	
	public ReturnToMenuButtonListener(GameFrame gf){
		this.gf=gf;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		gf.switchToMenu();
		gf.repaint();
		gf.setSize(551,551);
		gf.setSize(550,550);
		
	}

}
