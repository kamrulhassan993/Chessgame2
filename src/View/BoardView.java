package View;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import Model.Board;
import Model.Square;

public class BoardView extends JPanel{

	private SquarePanel[][] squares = new SquarePanel[8][8];
	public final static Color LIGHTBROWN =new Color(239, 191, 106);
	public final static Color DARKBROWN =new Color(102, 26, 12);
	
	
	public BoardView(){
		this.setLayout(new GridLayout(8,8,1,1));
		this.setUpBoard();
	}
	
	public void setUpBoard(){
		this.removeAll();
		
		//adding the chess board squares and pieces
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				squares[i][j] = new SquarePanel(i, j, this);
				this.add(squares[i][j]);
				Square sq = Board.getInstance().getSquare(i, j);
				if(sq.getPiece()!=null){
					squares[i][j].setPieceImage(sq.getPiece().getCharValue());
					//System.out.println(sq.getPiece().getCharValue());
				}
			}
		}
		
		
		this.repaint();
	}
	
	public void recolorBoard(){
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				squares[i][j].setBackground(((i + j) % 2 == 0)? LIGHTBROWN : DARKBROWN);
			}
		}	
		this.repaint();
	}
	
	public SquarePanel getSquarePanelAt(int i, int j){
		return squares[i][j];
	}
	
}
