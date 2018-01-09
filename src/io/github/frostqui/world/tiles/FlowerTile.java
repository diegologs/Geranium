package io.github.frostqui.world.tiles;


import io.github.frostqui.gui.Screen;
import io.github.frostqui.gui.Sprite;
import io.github.frostqui.gui.SpriteSheet;
import io.github.frostqui.gui.Tile;

public class FlowerTile extends PlantTile{
	
	private static Sprite xs = new Sprite(0,32,16,SpriteSheet.tiles);
	private static Sprite s = new Sprite(16,32,16,SpriteSheet.tiles);
	private static Sprite m = new Sprite(16*2,32,16,SpriteSheet.tiles);
	private static Sprite l = new Sprite(16*3,32,16,SpriteSheet.tiles);
	private static Sprite xl = new Sprite(16*4,32,16,SpriteSheet.tiles);

	public FlowerTile() {
		super(xs,s,m,l,xl);
		this.name = "Flower"; 
		this.grow_speed = 30;
		this.ratio = 90;
		
	}
	
	public FlowerTile(int x, int y) {
		super(xs,s,m,l,xl);
		this.name = "Flower"; 
		this.grow_speed = 30;
		this.ratio = 10;
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
