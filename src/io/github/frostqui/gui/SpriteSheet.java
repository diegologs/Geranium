package io.github.frostqui.gui;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	public static SpriteSheet tiles = new SpriteSheet(480, "/sheet.png");
	private int width, height;
	private String path;
	private int size;
	private int[] pixels;
	
	
	
	
	public SpriteSheet(int size, String path){
		
		this.path = path;
		this.setSize(size);
		setPixels(new int[size*size]);
		load();
		
	}
	
	public void load(){
		
		try {
		
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			width = image.getWidth();
			height = image.getHeight();
			image.getRGB(0, 0, width, height, getPixels(), 0, width);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	
	


}