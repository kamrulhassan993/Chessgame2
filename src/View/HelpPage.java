package View;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HelpPage extends JFrame{
	private JLabel help;
	
	private static boolean isOpen = false;
	
	/**
	 * creates a JFrame which show the instructions on how to play the game
	 * only one frame can be open at any time
	 */
	public HelpPage(){
		super("How to play");
		this.isOpen=true;
		this.setSize(550,550);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);

		
		help = new JLabel(new ImageIcon(ClassLoader.getSystemResource("Images/instructions.png")));
		
		
		this.getContentPane().add(help);
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent arg0) {
				HelpPage.this.isOpen=false;
				HelpPage.this.dispose();
				
			}
			
			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	/**
	 * 
	 * @return boolean value to see if the window is already open 
	 */
	public static boolean isOpen(){
		return isOpen;
	}
}
