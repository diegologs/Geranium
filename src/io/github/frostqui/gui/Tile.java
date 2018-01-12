package io.github.frostqui.gui;

public class Tile {	

	public Sprite sprite;
	
	public int x,y;


	public Tile(Sprite sprite) {
		this.sprite = sprite;
		
	}
	
	public Tile() {
		
	}
	
	public void render(int x, int y, Screen screen) {
		this.x = x;
		this.y = y;
		
		screen.renderTile(x, y, this);
	}
	
	public void update() {
		
	}
	
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}
	

}
