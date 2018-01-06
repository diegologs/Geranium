package io.github.frostqui.gui;

public class Tile {	

	public Sprite sprite;
	
	public int x,y;


	public Tile(Sprite sprite) {
		this.sprite = sprite;
		
	}
	
	public void render(int x, int y, Screen screen) {
		this.x = x;
		this.y = y;
		screen.renderTile(x, y, this);
	}
	
	public void update() {
		
	}
	

}
