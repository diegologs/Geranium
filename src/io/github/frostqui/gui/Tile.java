package io.github.frostqui.gui;

public class Tile extends Sprite {
	
	public static Tile grass = new Tile(0,0,0,0, 16, SpriteSheet.tiles);

	public Tile(int x, int y, int xoff, int yoff, int size, SpriteSheet sheet) {
		super(x, y, xoff, yoff, size, sheet);
		
	}
	
	public void render(Screen screen) {
		System.out.println("eeeee");
		screen.renderTile(this);
	}
	
	

}
