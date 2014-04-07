package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.LoadGameButtonListener;
import Controller.NewGameButtonListener;
import Controller.SaveButtonListener;
import Controller.UndoMoveButtonListener;

public class GamePanel extends JPanel {

	private BoardView bv;
	private JPanel buttonPanel;
	private JButton newGameButton ,saveButton , loadButton , undoMoveButton, menuButton, helpButton;
	
	public GamePanel(BoardView bv){
		this.bv=bv;
		setUpChessBoard();
		setUpButtons();
		
	}
	
	public void setUpChessBoard(){
		this.setLayout(new BorderLayout());
		this.add(bv, BorderLayout.CENTER);
		/*this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(500,500));
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);*/
	}
	
	public void setUpButtons(){
		this.buttonPanel = new JPanel(new GridLayout(1, 6, 10, 10));
		newGameButton = new JButton("New Game");
		saveButton = new JButton("Save");
		loadButton = new JButton("Load");
		undoMoveButton = new JButton("Undo Move");
		menuButton = new JButton("Menu");
		helpButton = new JButton("help");
		
		buttonPanel.add(newGameButton);
		buttonPanel.add(saveButton);
		buttonPanel.add(loadButton);
		buttonPanel.add(undoMoveButton);
		buttonPanel.add(menuButton);
		buttonPanel.add(helpButton);
		
		this.add(buttonPanel, BorderLayout.NORTH);	
	}
	
	public void addNewGameButtonListener(ActionListener al){
		newGameButton.addActionListener(al);
	}
	
	public void addUndoMoveButtonListener(ActionListener al){
		undoMoveButton.addActionListener(al);
	}
	
	public void addSaveButtonListener(ActionListener al){
		saveButton.addActionListener(al);
	}
	
	public void addLoadButtonListener(ActionListener al){
		loadButton.addActionListener(al);
	}
	
	 

}
