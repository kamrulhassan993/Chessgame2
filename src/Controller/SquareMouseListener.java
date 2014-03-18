package Controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import Model.Board;
import Model.KingSafety;
import Model.Move;
import Model.NoMovesAvailableException;
import Model.Piece;
import Model.Search;
import View.SquarePanel;

public class SquareMouseListener implements MouseListener {
	
	private final static Color PURPLE =new Color(176, 28, 132);

	public SquareMouseListener() {

	}

	@Override
	public void mouseClicked(MouseEvent m) {
		SquarePanel sp = ((SquarePanel) (m.getSource()));
		Piece p = Board.getInstance().getPieceAtSquare(sp.getI(), sp.getJ());

		if(sp.getBackground().equals(Color.red)){
			sp.getBoardView().recolorBoard();
			Board.getInstance().setSelectedPiece(null);
			
		}
		else if(sp.getBackground().equals(PURPLE)){
			Piece piece = Board.getInstance().getSelectedPiece();
			Board.getInstance().setSelectedPiece(null);
			Move move = new Move(piece.getLocation(), Board.getInstance().getSquare(sp.getI(), sp.getJ()), piece);
			Board.getInstance().makeMove(move);
			sp.getBoardView().setUpBoard();
			Board.getInstance().setLastPlayerMove(move);
			
			
			try {
				Move cpuMove = Search.decision();
				Board.getInstance().setLastCpuMove(cpuMove);
				Board.getInstance().makeMove(cpuMove);
				sp.getBoardView().setUpBoard();
			} catch (Exception e) {
			}
			
			
			
			
		}else if(p!=null && !p.equals(Board.getInstance().getSelectedPiece()) && p.getPlayer()!=1){
			Board.getInstance().setSelectedPiece(p);
			sp.getBoardView().recolorBoard();
			sp.setBackground(Color.red);
			ArrayList<Move> moves = p.generateMoves();
			moves = KingSafety.safeMoves(moves, 0);
			
			if(!moves.isEmpty()){
				for(Move mv: moves){
					sp.getBoardView().getSquarePanelAt(mv.getEndPositon().getI(),mv.getEndPositon().getJ()).setBackground(Color.green);
				}
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent m) {
		if(((SquarePanel) m.getSource()).getBackground().equals(Color.GREEN) ) {
			((SquarePanel) m.getSource()).setBackground(PURPLE);
		}

	}

	@Override
	public void mouseExited(MouseEvent m) {
		if(((SquarePanel) m.getSource()).getBackground().equals(PURPLE)){
			((SquarePanel)m.getSource()).setBackground(Color.GREEN);
		}

	}

	@Override
	public void mousePressed(MouseEvent m) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {

	}

}
