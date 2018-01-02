package io.github.frostqui.gui;

public class Sprite {

	public int x,y;
	public int xoff, yoff;
	public int size;
	public int[] pixels;
	public SpriteSheet sheet;

	
	public static Sprite grass = new Sprite(0,0,16,SpriteSheet.tiles);
	public static Sprite pink = new Sprite(16,16,16,SpriteSheet.tiles);

	public Sprite(int xoff, int yoff, int size, SpriteSheet sheet){
		
		/* Loads the position of the sprite in the spriteSheet */
		
	
		this.xoff= xoff;
		this.yoff= yoff;
		
		this.size = size;
		this.sheet = sheet;
		pixels = new int[size * size];
		load();
		
	}
	
	private void load(){
		for (int y = 0; y<size; y++){
			for (int x= 0; x<size; x++){
				pixels[x+y*size] = sheet.getPixels()[(x + this.xoff) + ( y + this.yoff) * sheet.getSize()]; 
			}
		}
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderSprite(x, y, this);
	}


}

