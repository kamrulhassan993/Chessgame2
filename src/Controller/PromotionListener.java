package Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Model.Piece;
import Model.PieceFactory;
import Model.Queen;
import View.PromotionWindow;

public class PromotionListener implements ActionListener{

	private JLabel label;
	private JFrame f;
	private static String pieceName ="";
	
	public PromotionListener(JLabel label,JFrame f ){
		this.label=label;
		this.f=f;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getActionCommand().equals("submit")){
			if(!pieceName.equals("")){
				Piece p = ((PromotionWindow) f).getPiece();
				System.out.println(pieceName);
				Piece newPiece = new PieceFactory().createPiece(pieceName, p.getLocation());
				p.getLocation().setPiece(newPiece);
				p.setLocation(null);
				((PromotionWindow) f).getBoardView().setUpBoard();
				f.dispose();
			}
		
		}else{
			
			label.setText("selected:" + ae.getActionCommand() );
			if(ae.getActionCommand().equals("knight")){
				System.out.println("here");
				pieceName="wn";
			}else if(ae.getActionCommand().equals("rook")){
				pieceName="wr";
			}else if(ae.getActionCommand().equals("queen")){
				pieceName="wq";
			}else{
				pieceName="wb";
			}
			
		}	
	}

}
