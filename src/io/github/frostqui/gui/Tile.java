package io.github.frostqui.gui;

public class Tile {
	

	public Sprite sprite;


	
	public static Tile grass = new Tile(Sprite.grass);

	public Tile(Sprite sprite) {
		this.sprite = sprite;
		
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x, y, this);
	}
	

}
