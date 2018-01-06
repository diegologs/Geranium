package io.github.frostqui.world.tiles;

import io.github.frostqui.gui.Screen;
import io.github.frostqui.gui.Sprite;
import io.github.frostqui.gui.SpriteSheet;

public class DirtTile extends PlantTile {
	private static Sprite xs = new Sprite(0,16,16,SpriteSheet.tiles);
	private static Sprite s = new Sprite(16,16,16,SpriteSheet.tiles);
	private static Sprite m = new Sprite(16*2,16,16,SpriteSheet.tiles);
	private static Sprite l = new Sprite(16*3,16,16,SpriteSheet.tiles);
	private static Sprite xl = new Sprite(16*4,16,16,SpriteSheet.tiles);

	public DirtTile(Sprite sprite) {
		super(xs,s,m,l,xl);
		this.name = "Dirt";
	}
	
	public void render(Screen screen) {
		super.render(x,y,screen);
	}
	
	public void update() {
		super.update();
	}

}
