package io.github.frostqui;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends Canvas implements Runnable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 420;
	public static final int HEIGHT = WIDTH / 16 * 9;
	public static final int SCALE = 3;
	public static final String TITLE = "Geranium";
	
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData(); //Pixels of the screen

	
	private JFrame frame;
	
	private boolean running;
	private Thread thread;
	private Random random;
	
	private int x;
	
	public Game() {
		
		Dimension dim = new Dimension(WIDTH * SCALE, HEIGHT * SCALE );
		setPreferredSize(dim);
		frame = new JFrame();
		
	}

	public static void main(String args[]) {
		createWindow();
		
	}
	
	public static void createWindow() {
	
		Game game= new Game();
		game.frame.setTitle("Geranium");
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setVisible(true);
		game.frame.setLocationRelativeTo(null);
		game.start();
		
		
		
		
		
		
	}
	
	public void start() {
		running  = true;
		thread = new Thread(this, "Display");
		thread.start();
	}
	
	public void stop() {
		running = false;
		try{
			thread.join();
		}catch (Exception e) {
			e.printStackTrace();
}
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime(); //nanoTime is better than currentTimeint timer = 0;
		long timer = System.currentTimeMillis();
		final double nanoSecs = 1000000000.0 / 60.0;
		double delta = 0;
		int fps = 0;
		int ticks = 0;
		
		
		
		while(running ){
			long now = System.nanoTime(); //Not the same time than lastTime
			delta += (now - lastTime) / nanoSecs; 
			lastTime  = now;
			
			
			while (delta >= 1){
				tick();
				ticks++;
				delta--;
			}
			
			render();
			fps++;
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println(ticks+" ticks,  "+fps+" fps");
				ticks = 0;
				fps = 0;
			}
			
		}
		stop();
		
	}

	private void render() {
		BufferStrategy bs = getBufferStrategy();
		
		if(bs == null){
			
			/*
			 * If we got the screen and the storage where the pixels are calculated, we need to wait if we want to calculate another until the first one is calculated. 
			 * But with the screen and two storage we can process two at the same time
			 */
			
			createBufferStrategy(3);
			
			
			return;
			
			
			
		}
		

		
		for(int i=0; i<pixels.length; i++){
			pixels[i] = i + x;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		
		g.dispose();
		bs.show();
		
	}

	private void tick() {
		x++;
		
	}
	
}