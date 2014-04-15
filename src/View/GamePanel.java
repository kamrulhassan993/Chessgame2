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
	
	/**
	 * 
	 * @param bv the board view of the chess board
	 */
	public GamePanel(BoardView bv){
		this.bv=bv;
		setUpChessBoard();
		setUpButtons();
		
	}
	
	/**
	 * adds the chess board to the centre of the this panel
	 */
	private void setUpChessBoard(){
		this.setLayout(new BorderLayout());
		this.add(bv, BorderLayout.CENTER);

	}
	
	/**
	 * creates the buttons for this panel
	 */
	private void setUpButtons(){
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
	
	/**
	 * 
	 * @param al the actionListener for the new game button
	 */
	public void addNewGameButtonListener(ActionListener al){
		newGameButton.addActionListener(al);
	}
	
	/**
	 * 
	 * @param al the ActionListener for the undo move button
	 */
	public void addUndoMoveButtonListener(ActionListener al){
		undoMoveButton.addActionListener(al);
	}
	
	/**
	 * 
	 * @param al the ActionListener for the save button
	 */
	public void addSaveButtonListener(ActionListener al){
		saveButton.addActionListener(al);
	}
	
	/**
	 * 
	 * @param al the ActionListener for the load button
	 */
	public void addLoadButtonListener(ActionListener al){
		loadButton.addActionListener(al);
	}
	
	
	/**
	 * 
	 * @param al the ActionListenr for the button to return to the main Menu
	 */
	public void addReturnToMenuButtonListener(ActionListener al){
		menuButton.addActionListener(al);
		
	}
	
	 

}
