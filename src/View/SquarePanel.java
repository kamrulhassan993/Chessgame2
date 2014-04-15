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

	/**
	 * creates the square panel and sets colour and image depending on location 
	 * and the piece at its location
	 * @param i the y coordinate for the square
	 * @param j the x coordinate for the square
	 * @param boardView the chess board
	 */
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

	/**
	 * 
	 * @param m the mouse listener
	 */
	public void addSqaureMouseListener(MouseListener m) {
		this.addMouseListener(m);
	}

	/**
	 * 
	 * @param image the text value for the image to be set on the panel
	 */
	public void setPieceImage(String image) {
		pieceImage.setIcon(new ImageIcon(ClassLoader
				.getSystemResource("Images/" + image + ".gif")));
	}

	/**
	 * 
	 * @return the i location value
	 */
	public int getI() {
		return i;
	}

	/**
	 * 
	 * @param i sets the i location value 
	 */
	public void setI(int i) {
		this.i = i;
	}

	/**
	 * 
	 * @return the j location value
	 */
	public int getJ() {
		return j;
	}

	/**
	 * 
	 * @param j sets the j location value
	 */
	public void setJ(int j) {
		this.j = j;
	}

	/**
	 * 
	 * @return the jlabel that contains the images icon
	 */
	public JLabel getPieceImage() {
		return pieceImage;
	}

	/**
	 * 
	 * @return the board view 
	 */
	public BoardView getBoardView() {
		return boardView;
	}

}
