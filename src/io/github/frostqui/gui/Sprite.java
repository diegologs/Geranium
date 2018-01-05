package io.github.frostqui.gui;

public class Sprite {

	public int x,y;
	public int xoff, yoff;
	public int size;
	public int[] pixels;
	public SpriteSheet sheet;
	public static int sprites_size = 16;
	
	public static Sprite wildgrass1 = new Sprite(0*sprites_size,1*sprites_size,16,SpriteSheet.tiles);
	public static Sprite wildgrass2 = new Sprite(0*sprites_size,2*sprites_size,16,SpriteSheet.tiles);
	public static Sprite wildgrass3 = new Sprite(0*sprites_size,3*sprites_size,16,SpriteSheet.tiles);
	public static Sprite grass = new Sprite(0*sprites_size,0*sprites_size,16,SpriteSheet.tiles);
	public static Sprite selected = new Sprite(0,0,16,SpriteSheet.objects);

	public Sprite(int xoff, int yoff, int size, SpriteSheet sheet){
		
		/* Loads the position of the sprite in the spriteSheet */
		
	
		this.xoff= xoff;
		this.yoff= yoff;
		
		this.size = size;
		this.sheet = sheet;
		pixels = new int[size * size];
		load();
		
	}
	
	public Sprite(int[] pixels, int width, int height) {
		size = (width == height) ? width : -1;
		
		this.pixels = new int[pixels.length];
		for (int i = 0; i < pixels.length; i++) {
			this.pixels[i] = pixels[i];
		}
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
	
	public static Sprite[] split(SpriteSheet sheet) {
		int amount = (sheet.getWidth() * sheet.getHeight()) / (sheet.SPRITE_WIDTH * sheet.SPRITE_HEIGHT);
		Sprite[] sprites = new Sprite[amount];
		int current = 0;
		int[] pixels = new int[sheet.SPRITE_WIDTH * sheet.SPRITE_HEIGHT];
		for (int yp = 0; yp < sheet.getHeight() / sheet.SPRITE_HEIGHT; yp++) {
			for (int xp = 0; xp < sheet.getWidth() / sheet.SPRITE_WIDTH; xp++) {

				for (int y = 0; y < sheet.SPRITE_HEIGHT; y++) {
					for (int x = 0; x < sheet.SPRITE_WIDTH; x++) {
						int xo = x + xp * sheet.SPRITE_WIDTH;
						int yo = y + yp * sheet.SPRITE_HEIGHT;
						pixels[x + y * sheet.SPRITE_WIDTH] = sheet.getPixels()[xo + yo * sheet.getWidth()];
					}
				}

				sprites[current++] = new Sprite(pixels, sheet.SPRITE_WIDTH, sheet.SPRITE_HEIGHT);
			}
		}

		return sprites;
	}
	
	public int getWidth() {
		return size;
	}

	public int getHeight() {
		return size;
	}




}

