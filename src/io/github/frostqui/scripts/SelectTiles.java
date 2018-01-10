package io.github.frostqui.scripts;

import io.github.frostqui.gui.Screen;
import io.github.frostqui.gui.Sprite;
import io.github.frostqui.gui.Tile;
import io.github.frostqui.input.Mouse;
import io.github.frostqui.world.Map;
import io.github.frostqui.world.tiles.PlantTile;

public class SelectTiles {

	private int w, h, scale;
	public Tile selected;

	public SelectTiles(int w, int h, int scale) {
		this.selected = new Tile();
		this.w = w;
		this.h = h;
		this.scale = scale;
	}

	public void select(Mouse mouse, Map map, Screen screen) {

		if (mouse.getY() < h * scale - 30 * scale) {

			if (mouse.getX() > 0 && mouse.getY() > 0) {

				selected = map.getTile((mouse.getX() / scale) / 16, (mouse.getY() / scale) / 16);

			}

			//screen.renderSprite(0, 0, Sprite.selected);

		}
	}

}
