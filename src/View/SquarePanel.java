package View;

import java.awt.Dimension;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.SquareMouseListener;

public class SquarePanel extends JPanel {

	private BoardView boardView;
	private int i, j;
	private JLabel pieceImage;

	public SquarePanel(int i, int j, BoardView boardView) {
		this.i = i;
		this.j = j;
		this.boardView = boardView;

		if ((i + j) % 2 == 0) {
			this.setBackground(BoardView.LIGHTBROWN);
		} else {
			this.setBackground(BoardView.DARKBROWN);
		}

		this.setPreferredSize(new Dimension(50, 50));
		pieceImage = new JLabel();

		this.addSqaureMouseListener(new SquareMouseListener());
		this.add(pieceImage);

	}

	public void addSqaureMouseListener(MouseListener m) {
		this.addMouseListener(m);
	}

	public void setPieceImage(String image) {
		pieceImage.setIcon(new ImageIcon(ClassLoader
				.getSystemResource("Images/" + image + ".gif")));
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public JLabel getPieceImage() {
		return pieceImage;
	}

	public BoardView getBoardView() {
		return boardView;
	}

}
