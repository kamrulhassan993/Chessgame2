package View;

import javax.swing.JFrame;

import Controller.LoadGameButtonListener;
import Controller.MenuStartButtonListener;
import Controller.NewGameButtonListener;
import Controller.SaveButtonListener;
import Controller.UndoMoveButtonListener;

public class GameFrame extends JFrame{
	
	public GameFrame(){
		this.setSize(550,550);
		this.setLocationRelativeTo(null);
		
		this.setVisible(true);
		
		switchToMenu();
		
		
		
	}
	
	public void switchToMenu(){
		MenuPanel mv = new MenuPanel();
		this.getContentPane().add(mv);
		mv.addStartButtonListener(new MenuStartButtonListener(this));
		
		
		this.setSize(551,551);
		this.setSize(550,550);
	}
	
	public void switchToGame(){
		this.getContentPane().removeAll();
		
		BoardView bv = new BoardView();
		GamePanel gp = new GamePanel(bv);
		gp.addNewGameButtonListener(new NewGameButtonListener(bv));
		gp.addUndoMoveButtonListener(new UndoMoveButtonListener(bv));
		gp.addSaveButtonListener(new SaveButtonListener(bv));
		gp.addLoadButtonListener(new LoadGameButtonListener(bv));
		this.getContentPane().add(gp);
		
	}

}
