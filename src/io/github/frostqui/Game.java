package io.github.frostqui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import java.util.Random;

import javax.swing.JFrame;

import io.github.frostqui.events.Event;
import io.github.frostqui.events.EventListener;
import io.github.frostqui.gui.Font;
import io.github.frostqui.gui.Screen;
import io.github.frostqui.gui.Sprite;
import io.github.frostqui.gui.SpriteSheet;
import io.github.frostqui.gui.Tile;
import io.github.frostqui.input.Keyboard;
import io.github.frostqui.input.Mouse;
import io.github.frostqui.world.Map;

public class Game extends Canvas implements Runnable, EventListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 350;
	public static final int HEIGHT = WIDTH / 16 * 9;
	public static final int SCALE = 4;
	public static final String TITLE = "Geranium";

	public Font font;

	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData(); // Pixels of the screen

	private JFrame frame;

	private boolean running;
	private Thread thread;
	private Random random;

	private static Screen screen;

	private static Map map;

	private Keyboard key;
	private Mouse mouse;

	private int x;

	public Game() {
		key = new Keyboard();
		mouse = new Mouse(this);
		addMouseListener(mouse);
		addMouseMotionListener(mouse);

		font = new Font();
		addKeyListener(key);
		Dimension dim = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
		setPreferredSize(dim);
		frame = new JFrame();

	}

	public static void main(String args[]) {
		createWindow();
		screen = new Screen(WIDTH, HEIGHT);
		map = new Map(WIDTH * 2, HEIGHT * 2);

	}

	public static void createWindow() {

		Game game = new Game();
		game.frame.setTitle("Geranium");
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setVisible(true);
		game.frame.setLocationRelativeTo(null);
		game.start();

	}

	public void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
	}

	public void stop() {
		running = false;
		try {
			thread.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime(); // nanoTime is better than currentTimeint timer = 0;
		long timer = System.currentTimeMillis();
		final double nanoSecs = 1000000000.0 / 60.0;
		double delta = 0;
		int fps = 0;
		int ticks = 0;

		while (running) {
			long now = System.nanoTime(); // Not the same time than lastTime
			delta += (now - lastTime) / nanoSecs;
			lastTime = now;

			while (delta >= 1) {
				tick();
				ticks++;
				delta--;
			}

			render();
			fps++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println(ticks + " ticks,  " + fps + " fps");
				ticks = 0;
				fps = 0;
			}

		}
		stop();

	}

	private void render() {
		BufferStrategy bs = getBufferStrategy();

		if (bs == null) {

			/*
			 * If we got the screen and the storage where the pixels are calculated, we need
			 * to wait if we want to calculate another until the first one is calculated.
			 * But with the screen and two storage we can process two at the same time
			 */

			createBufferStrategy(3);

			return;

		}

		screen.clear();

		map.render(screen);

		font.render(0, 0, "GERANIUM", screen);



		if (mouse.getX() > 0 && mouse.getY() > 0) {
			

			Sprite selected = Sprite.selected;
			screen.renderSprite((mouse.getX() / SCALE), mouse.getY() / SCALE, selected);
			
		}

		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = screen.pixels[i];
		}

		Graphics g = bs.getDrawGraphics();

		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.setColor(new Color(0xff00ff));
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(image, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);

		g.dispose();
		bs.show();

	}

	private void tick() {
		key.update();

		if (key.up) {
			screen.camera.y--;
		}

		if (key.right) {
			screen.camera.x++;
		}

		if (key.down) {
			screen.camera.y++;
		}

		if (key.left) {
			screen.camera.x--;
		}

	}

	@Override
	public void onEvent(Event event) {
		// TODO Auto-generated method stub

	}

}