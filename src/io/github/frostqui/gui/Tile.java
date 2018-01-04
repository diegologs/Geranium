package io.github.frostqui.gui;

public class Tile {
	

	public Sprite sprite;


	
	public static Tile wildgrass1 = new Tile(Sprite.wildgrass1);
	public static Tile wildgrass2 = new Tile(Sprite.wildgrass2);
	public static Tile wildgrass3 = new Tile(Sprite.wildgrass3);
	public static Tile grass = new Tile(Sprite.grass);

	public Tile(Sprite sprite) {
		this.sprite = sprite;
		
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x, y, this);
	}
	

}
