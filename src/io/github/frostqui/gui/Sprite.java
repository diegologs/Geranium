package io.github.frostqui.gui;

public class Sprite {
	
	public int x,y;
	public int[] pixels;
	public int size;
	
	
	public Sprite(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.pixels = new int[size*size];
		
		load();
	}
		
	private void load() {
		for(int i = 0; i < this.pixels.length; i++) {
			this.pixels[i] = 0xff00ff;
		}
	}
	
}
