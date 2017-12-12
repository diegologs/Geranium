import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Geranium extends Canvas{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 420;
	public static final int HEIGHT = WIDTH / 16 * 9;
	public static final int SCALE = 3;
	public static final String TITLE = "Geranium";
	
	private JFrame frame;
	
	public Geranium() {
		
		Dimension dim = new Dimension(WIDTH * SCALE, HEIGHT * SCALE );
		setPreferredSize(dim);
		frame = new JFrame();
		
	}

	public static void main(String args[]) {
		createWindow();
	}
	
	public static void createWindow() {
	
		Geranium geranium = new Geranium();
		geranium.frame.setTitle("Geranium");
		geranium.frame.add(geranium);
		geranium.frame.pack();
		geranium.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		geranium.frame.setVisible(true);
		geranium.frame.setLocationRelativeTo(null);
		
		
		
	}
	
}
