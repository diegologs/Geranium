package io.github.frostqui.gui;

import java.util.Random;

import io.github.frostqui.world.Map;

public class Screen {

	private int w, h;
	public int[] pixels;

	private Random random;
	private Map map;

	private int[] tiles;

	public Screen(int w, int h) {
		this.w = w;
		this.h = h;
		this.pixels = new int[w * h];
		this.random = new Random();
		this.map = new Map(w, h);
	}

	public void render(int xOff, int yOff) {

		for (int j = 0; j < h; j++) {
			int yy = j + yOff;

			 if(yy < 0 || yy >= h)break;

			for (int i = 0; i < w; i++) {
				int xx = i + xOff;

				if(xx < 0 || xx >= w)break;

			
				

				pixels[i + j * w] = random.nextInt(0xffffff);

			}

		}
	}


	
	public void renderSprite(int x, int y, Sprite sprite) {
	
		for (int j = 0; j < sprite.size; j++) {
			int ya = j + y;
			for (int i = 0; i < sprite.size; i++) {
				int xa = i + x;
				if(xa<0 || ya < 0 || xa >= w || ya >= h )break;
				pixels[xa + ya * w] = sprite.pixels[i + j * sprite.size];
			}
		}

		
	}
	
	public void renderTile(Tile tile) {
		
		for (int j = 0; j < tile.size; j++) {
			int ya = j + tile.y;
			for (int i = 0; i < tile.size; i++) {
				int xa = i + tile.x;
				if(xa<0 || ya < 0 || xa >= w || ya >= h )break;
				pixels[xa + ya * w] = tile.pixels[i + j * tile.size];
			}
		}

		
	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0x000000;
		}
	}

}
