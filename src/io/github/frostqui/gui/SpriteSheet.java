package io.github.frostqui.gui;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	public static SpriteSheet tiles = new SpriteSheet(480, "/sheet.png");

	public int width, height;

	public final int SPRITE_WIDTH, SPRITE_HEIGHT;

	private String path;
	public int size;
	private int[] pixels;

	public SpriteSheet(int size, String path) {

		SPRITE_WIDTH = size;
		SPRITE_HEIGHT = size;
		this.path = path;
		this.setSize(size);
		setPixels(new int[size * size]);
		load();

	}

	public void load() {
		try {
			System.out.print("Trying to load: " + path + "...");
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			System.out.println(" succeeded!");
			width = image.getWidth();
			height = image.getHeight();
			pixels = new int[width * height];
			image.getRGB(0, 0, width, height, pixels, 0, width);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println(" failed!");
		}

	}

	public int[] getPixels() {
		return pixels;
	}

	public void setPixels(int[] pixels) {
		this.pixels = pixels;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

}