package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.MenuStartButtonListener;

public class MenuPanel extends JPanel {
	
	private JButton startButton, loadButton, exitButton;
	private JLabel diffLabel, logoLabel, firstMoveLabel;
	private String[] depth ={"Easy Depth 2","Medium Depth 3","Hard Depth 4"};
	private String[] first = {"White Wirst","Black first"};
	private JComboBox difficulty , firstMove;
	private JPanel centerPanel;
	
	public MenuPanel(){

		this.setLayout(new BorderLayout());
		this.logoLabel=new JLabel(new ImageIcon(ClassLoader.getSystemResource("Images/logo.png")));
		centerPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		startButton = new JButton(new ImageIcon(ClassLoader.getSystemResource("Images/startGame.png")));
		startButton.setBorder(BorderFactory.createEmptyBorder());
		startButton.setContentAreaFilled(false);
		
		loadButton = new JButton(new ImageIcon(ClassLoader.getSystemResource("Images/loadGame.png")));
		loadButton.setBorder(BorderFactory.createEmptyBorder());
		loadButton.setContentAreaFilled(false);
		loadButton.setActionCommand("menu");
		
		exitButton = new JButton(new ImageIcon(ClassLoader.getSystemResource("Images/exitGame.png")));
		exitButton.setBorder(BorderFactory.createEmptyBorder());
		exitButton.setContentAreaFilled(false);
		
		diffLabel = new JLabel("Select Difficulty");
		difficulty= new JComboBox(depth);
		
		firstMoveLabel = new JLabel("Move first");
		firstMove = new JComboBox(first);
		
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.ipady=10;
		
		gbc.gridwidth=2;
		gbc.gridx=1;
		gbc.gridy=1;
		centerPanel.add(startButton,gbc);
		
		gbc.gridwidth=1;
		gbc.gridx=1;
		gbc.gridy=2;
		centerPanel.add(diffLabel, gbc);
		
		gbc.gridwidth=1;
		gbc.gridx=2;
		gbc.gridy=2;
		centerPanel.add(difficulty, gbc);
		
		gbc.gridwidth=1;
		gbc.gridx=1;
		gbc.gridy=3;
		centerPanel.add(firstMoveLabel,gbc);
		
		gbc.gridwidth=1;
		gbc.gridx=2;
		gbc.gridy=3;
		centerPanel.add(firstMove,gbc);
		
		gbc.gridwidth=2;
		gbc.gridx=1;
		gbc.gridy=4;
		centerPanel.add(loadButton,gbc);
		
		gbc.gridwidth=2;
		gbc.gridx=1;
		gbc.gridy=5;
		centerPanel.add(exitButton,gbc);
		
		
		this.add(logoLabel, BorderLayout.NORTH);
		this.add(centerPanel,BorderLayout.CENTER);
		
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
				
			}
		});
		
		
		
	}
	
	public void addStartButtonListener(ActionListener al){
		startButton.addActionListener(al);
	}
	
	public void addLoadButtonListener(ActionListener al){
		loadButton.addActionListener(al);
	}
	
	
	

	
	
}
