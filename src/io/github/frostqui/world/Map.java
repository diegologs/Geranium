package io.github.frostqui.world;

import java.util.Random;

import io.github.frostqui.gui.Screen;
import io.github.frostqui.gui.Sprite;
import io.github.frostqui.gui.Tile;
import io.github.frostqui.world.tiles.DirtTile;
import io.github.frostqui.world.tiles.FlowerTile;
import io.github.frostqui.world.tiles.GrassTile;
import io.github.frostqui.world.tiles.PlantTile;

public class Map {

	public int w, h;
	public PlantTile[] tiles;

	private Random random;

	private int total_ratio = 99;
	private int random_ratio = 0;

	public Map(int w, int h) throws InstantiationException, IllegalAccessException {
		this.w = w;
		this.h = h;

		PlantTile.plants_tile.add(new GrassTile());
		PlantTile.plants_tile.add(new DirtTile());
		PlantTile.plants_tile.add(new FlowerTile());

		tiles = new PlantTile[w * h];
		random = new Random();

		for (int i = 0; i < w / 16; i++) {
			for (int j = 0; j < h / 16; j++) {

				random_ratio = random.nextInt(total_ratio);

				if(random.nextInt(8) < 3)
				{
					tiles[i+j*w] = new DirtTile();
				}else if(random.nextInt(8) < 6){
					tiles[i+j*w] = new GrassTile();
				}else {
					tiles[i+j*w] = new FlowerTile();
}

				
			}

		}

	}

	public void render(Screen screen) {

		for (int i = 0; i < w / 16; i++) {
			for (int j = 0; j < h / 16; j++) {
				tiles[i + j * w].render(i * 16, j * 16, screen);
				tiles[i + j * w].update();

			}
		}

	}
	
	public PlantTile getTile(int i, int j) {
		return tiles[i+j*w];
	}

}
