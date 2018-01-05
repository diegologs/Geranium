package io.github.frostqui.world;

import java.util.Random;

import io.github.frostqui.gui.Screen;
import io.github.frostqui.gui.Sprite;
import io.github.frostqui.gui.Tile;
import io.github.frostqui.world.tiles.GrassTile;



public class Map {

	public int w, h;
	public GrassTile[] tiles;
	
	private Random random;
	

 
	

	public Map(int w, int h) {
		this.w = w;
		this.h = h;
	
		tiles = new GrassTile[w * h];
		random = new Random();
		
		for(int i = 0; i< w / 16; i++) {
			for(int j = 0; j< h / 16; j++) {
				tiles[i+j*w] = new GrassTile(Sprite.grass);;
				
				
			}
			
			
		}
		
		
		

	}

	

	public void render(Screen screen) {
		
		for(int i = 0; i< w / 16; i++) {
			for(int j = 0; j< h / 16; j++) {
				tiles[i+j*w].render(i*16,j*16,screen);
				tiles[i+j*w].update();
			}
		}
		
		
		
	
	

	}
	

	

}
