package View;

import javax.swing.JFrame;

import Controller.LoadGameButtonListener;
import Controller.MenuStartButtonListener;
import Controller.NewGameButtonListener;
import Controller.ReturnToMenuButtonListener;
import Controller.SaveButtonListener;
import Controller.UndoMoveButtonListener;

public class GameFrame extends JFrame{
	
	public GameFrame(){
		this.setSize(550,550);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		
		switchToMenu();
		
		
		
	}
	
	public void switchToMenu(){
		this.getContentPane().removeAll();
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
		gp.addReturnToMenuButtonListener(new ReturnToMenuButtonListener(this));
		
		this.getContentPane().add(gp);
		
	}

}
