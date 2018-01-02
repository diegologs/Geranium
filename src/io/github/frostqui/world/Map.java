package io.github.frostqui.world;

import java.util.Random;

import io.github.frostqui.gui.Screen;
import io.github.frostqui.gui.Sprite;
import io.github.frostqui.gui.Tile;



public class Map {

	public int w, h;
	public int[] tiles;
	
	private Random random;
	

 
	

	public Map(int w, int h) {
		this.w = w;
		this.h = h;
	
		tiles = new int[w * h];
		random = new Random();
		
		for(int i = 0; i< w / 16; i++) {
			for(int j = 0; j< h / 16; j++) {
				tiles[i+j*w] = random.nextInt(3);
			}
		}
		
		

	}

	

	public void render(Screen screen) {
		for(int i = 0; i< w / 16; i++) {
			for(int j = 0; j< h / 16; j++) {
				getTile(i,j).render(i*16,j*16,screen);
			}
		}
	
	

	}
	
	public Tile getTile(int x, int y) {
		if(tiles[x + y * w] == 0) {
			return Tile.grass;
		}else {
			return Tile.grass;
		}
	}
	
	

}
