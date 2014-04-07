package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.GameFrame;

public class MenuStartButtonListener implements ActionListener {

	private GameFrame gf;
	
	public MenuStartButtonListener(GameFrame gf){
		this.gf=gf;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("here");
		gf.switchToGame();
		gf.repaint();
		gf.setSize(551,551);
		gf.setSize(550,550);
	}

		
}
