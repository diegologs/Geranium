package io.github.frostqui.world.tiles;

import io.github.frostqui.gui.Screen;
import io.github.frostqui.gui.Sprite;
import io.github.frostqui.gui.SpriteSheet;
import io.github.frostqui.gui.Tile;

public class GrassTile extends PlantTile{
	
	private static Sprite xs = new Sprite(0,0,16,SpriteSheet.tiles);
	private static Sprite s = new Sprite(16,0,16,SpriteSheet.tiles);
	private static Sprite m = new Sprite(16*2,0,16,SpriteSheet.tiles);
	private static Sprite l = new Sprite(16*3,0,16,SpriteSheet.tiles);
	private static Sprite xl = new Sprite(16*4,0,16,SpriteSheet.tiles);

	public GrassTile() {
		super(xs,s,m,l,xl);
		this.name = "Grass"; 
		this.grow_speed = 50;
		this.ratio = 50;
		
	}
	
	public GrassTile(int x, int y) {
		super(xs,s,m,l,xl);
		this.name = "Grass"; 
		this.grow_speed = 50;
		this.ratio = 50;
		this.x = x;
		this.y = y;
		
	}
	
	public void render(Screen screen) {
		super.render(x,y,screen);
	}
	
	public void update() {
		super.update();
	}

	

}
