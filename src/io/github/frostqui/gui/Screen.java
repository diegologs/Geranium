package io.github.frostqui.gui;

import java.util.Random;

public class Screen {

	private int w, h;
	public int[] pixels;

	private Random random;

	private int[] tiles;

	public Screen(int w, int h) {
		this.w = w;
		this.h = h;
		this.pixels = new int[w * h];
		this.random = new Random();
	}

	public void render(int xOff, int yOff) {

		for (int j = 0; j < h; j++) {
			int yy = j + yOff;

			// if(yy < 0 || yy >= height)break;

			for (int i = 0; i < w; i++) {
				int xx = i + xOff;

				// if(xx < 0 || xx >= width)break;

				int tileIndex = ((xx >> 4) & 7) + ((yy >> 4) & 7) * 8;
				// pixels[i + j * width] = random.nextInt(0xffffff);

				pixels[i + j * w] = random.nextInt(0xffffff);

			}

		}
	}

	public void renderSprite(Sprite sprite) {
		for (int j = 0; j < sprite.size; j++) {
			int ya = j + sprite.y;
			for (int i = 0; i < sprite.size; i++) {
				int xa = i + sprite.x;
				if(xa<0 || ya < 0 || xa >= w || ya >= h)break;
				pixels[xa + ya * w] = sprite.pixels[i + j * sprite.size];
			}
		}

		
	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0x000000;
		}
	}

}
