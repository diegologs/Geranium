package io.github.frostqui.gui;

public class Sprite {

	public int x,y;
	public int size;
	public int[] pixels;
	public SpriteSheet sheet;

	
	public static Sprite grass = new Sprite(0,0,16,SpriteSheet.tiles);

	public Sprite(int x, int y, int size, SpriteSheet sheet){
		
		/* Loads the position of the sprite in the spriteSheet */
		
		this.x = x; 
		this.y = y; 
		
		this.size = size;
		this.sheet = sheet;
		pixels = new int[size * size];
		load();
		
	}
	
	private void load(){
		for (int y = 0; y<size; y++){
			for (int x= 0; x<size; x++){
				pixels[x+y*size] = sheet.getPixels()[(x + this.x) + ( y + this.y) * sheet.getSize()]; 
			}
		}
	}

}

