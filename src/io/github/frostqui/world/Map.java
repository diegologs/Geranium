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
				tiles[i+j*w] = 120;
				
				
			}
			
			
		}
		
		for(int i = 0; i< w / 16; i++) {
			for(int j = 0; j< h / 16; j++) {
				tiles[i+0*w] = 0;					
				tiles[i+1*w] = 1;	
				tiles[i+2*w] = 2;	
				tiles[0+j*w] = 0;					
					
				
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
		switch(tiles[x + y * w]) {
		case 0: return Tile.wildgrass1;
		case 1:return Tile.wildgrass2;
		case 2: return Tile.wildgrass3; 
	
		default: return Tile.grass;
		}
		
	}
	
	

}
