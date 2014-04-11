package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Controller.LoadGameButtonListener;
import Controller.NewGameButtonListener;
import Controller.ReturnToMenuButtonListener;
import Controller.SaveButtonListener;
import Controller.UndoMoveButtonListener;

public class GamePanel extends JPanel {

	private BoardView bv;
	private JPanel buttonPanel, bottomButtonPanel;
	private JButton newGameButton ,saveButton , loadButton , undoMoveButton, menuButton, helpButton;
	
	public GamePanel(BoardView bv){
		this.bv=bv;
		setUpChessBoard();
		setUpButtons();
		
	}
	
	public void setUpChessBoard(){
		this.setLayout(new BorderLayout());
		this.add(bv, BorderLayout.CENTER);

	}
	
	public void setUpButtons(){
		this.buttonPanel = new JPanel(new GridLayout(1, 4));
		this.bottomButtonPanel = new JPanel(new GridLayout(1,2));
		GridBagConstraints gbc = new GridBagConstraints();
		newGameButton = new JButton("New Game");
		saveButton = new JButton("Save");
		loadButton = new JButton("Load");
		undoMoveButton = new JButton("Undo Move");
		menuButton = new JButton("Return to the menu screen");
		helpButton = new JButton("How to play the game");
		
		buttonPanel.add(newGameButton);
		buttonPanel.add(saveButton);
		buttonPanel.add(loadButton);
		buttonPanel.add(undoMoveButton);
		
		bottomButtonPanel.add(menuButton);
		bottomButtonPanel.add(helpButton);
		
		this.add(buttonPanel, BorderLayout.NORTH);	
		this.add(bottomButtonPanel, BorderLayout.SOUTH);
		
		helpButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!HelpPage.isOpen()){
					new HelpPage(); 
				}
				
			}
		});
		
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
	
	public void addReturnToMenuButtonListener(ActionListener al){
		menuButton.addActionListener(al);
		
	}
	
	 

}
