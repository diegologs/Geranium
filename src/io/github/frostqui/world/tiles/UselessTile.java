package io.github.frostqui.world.tiles;

import java.util.ArrayList;
import java.util.Random;

import io.github.frostqui.gui.Screen;
import io.github.frostqui.gui.Sprite;
import io.github.frostqui.gui.SpriteSheet;
import io.github.frostqui.gui.Tile;

public class UselessTile extends Tile{
	
	// Tile created for decoration with random sprites
	

	public String name;
	public Random random;
	

	public ArrayList<Sprite> randomSprites;
	public Sprite sprite;
	
	private int list_size;
	
	
	public UselessTile() {
		
		random = new Random();
		randomSprites = new ArrayList<Sprite>();
		randomSprites.add(new Sprite(0,16*3,16,SpriteSheet.tiles));
		randomSprites.add(new Sprite(16,16*3,16,SpriteSheet.tiles));
		
		list_size = randomSprites.size();
		
		
		
		sprite = randomSprites.get(random.nextInt(list_size));
		
		super.setSprite(sprite);
		
	}
	
	public void render(Screen screen) {
		super.render(x, y, screen);
	}

}
