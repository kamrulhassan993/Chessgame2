package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

import Controller.PromotionListener;
import Model.Piece;

public class PromotionWindow extends JFrame{
	
	private ButtonGroup bg;
	private JButton knight,queen,rook,bishop, submit;
	private JPanel centerPanel, bottomPanel;
	private JLabel selectedLabel;
	private BoardView bv;
	
	private Piece p;
	
	/**
	 * creates a boarder less window which cannot be closed or minimised until the 
	 * player has chose a new type for the pawn
	 * @param p the piece being promoted
	 * @param bv the view of the chess board
	 */
	public PromotionWindow(Piece p, BoardView bv){
		this.bv=bv;
		this.p=p;
		this.setSize(new Dimension(300,100));
		this.setUndecorated(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setVisible(true);
		
		bg = new ButtonGroup();
		knight = new JButton(new ImageIcon(ClassLoader.getSystemResource("Images/wn.gif")));
		queen = new JButton(new ImageIcon(ClassLoader.getSystemResource("Images/wq.gif")));
		rook = new JButton(new ImageIcon(ClassLoader.getSystemResource("Images/wr.gif")));
		bishop = new JButton(new ImageIcon(ClassLoader.getSystemResource("Images/wb.gif")));
		submit = new JButton("confirm");
		selectedLabel = new JLabel("selected: nothing");
		
		
		knight.addActionListener(new PromotionListener(selectedLabel,this));
		queen.addActionListener(new PromotionListener(selectedLabel,this));
		rook.addActionListener(new PromotionListener(selectedLabel,this));
		bishop.addActionListener(new PromotionListener(selectedLabel,this));
		submit.addActionListener(new PromotionListener(selectedLabel,this));
		
		knight.setActionCommand("knight");
		queen.setActionCommand("queen");
		rook.setActionCommand("rook");
		bishop.setActionCommand("bishop");
		submit.setActionCommand("submit");
		
		bg.add(knight);
		bg.add(queen);
		bg.add(rook);
		bg.add(bishop);
		
		centerPanel = new JPanel(new FlowLayout());
		centerPanel.add(knight);
		centerPanel.add(queen);
		centerPanel.add(rook);
		centerPanel.add(bishop);
		
		bottomPanel = new JPanel(new FlowLayout());
		bottomPanel.add(selectedLabel);
		bottomPanel.add(submit);
		
		
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(new JLabel("   promote the pawn"),BorderLayout.NORTH);
		this.getContentPane().add(centerPanel, BorderLayout.CENTER);
		this.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
		
	}

	/**
	 * @return the p
	 */
	public Piece getPiece() {
		return p;
	}

	/**
	 * @return the bv
	 */
	public BoardView getBoardView() {
		return bv;
	}
	
	
	
	
}
