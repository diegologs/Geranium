package io.github.frostqui.scenes;

import java.awt.Canvas;

import io.github.frostqui.events.Event;
import io.github.frostqui.events.EventListener;
import io.github.frostqui.gui.Font;
import io.github.frostqui.gui.Screen;
import io.github.frostqui.gui.Sprite;
import io.github.frostqui.gui.Tile;
import io.github.frostqui.input.Keyboard;
import io.github.frostqui.input.Mouse;
import io.github.frostqui.objects.Inventory;
import io.github.frostqui.scripts.SelectTiles;
import io.github.frostqui.world.Map;
import io.github.frostqui.world.tiles.PlantTile;

public class MainScene implements EventListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int w, h, scale;

	private Font font;

	private Inventory inventory;

	private Map map;
	private SelectTiles selectTiles;

	private Keyboard key;
	private Mouse mouse;
	private Screen screen;

	public MainScene(int w, int h, int scale, Mouse mouse, Keyboard key, Screen screen)
			throws InstantiationException, IllegalAccessException {

		this.mouse = mouse;
		this.key = key;
		this.w = w;
		this.h = h;
		this.scale = scale;
		this.screen = screen;

		map = new Map(w * 2, h * 2);
		System.out.println(w * h);

		font = new Font();

		inventory = new Inventory(w, h);

		selectTiles = new SelectTiles(w, h, scale);

	}

	public void render() {

		map.render(screen);
		inventory.render(screen);
		
		if (mouse.getY() < h * scale - 30 * scale && selectTiles.selected != null) {
			screen.renderSprite(selectTiles.selected.x, selectTiles.selected.y, Sprite.selected);
		}
		

	}

	public void update() {

		selectTiles.select(mouse, map, screen);
		map.update();
		

		if (key.up) {
			screen.camera.y--;
		}

		if (key.right) {
			screen.camera.x++;
		}

		if (key.down) {
			screen.camera.y++;
		}

		if (key.left) {
			screen.camera.x--;
		}

	}

	@Override
	public void onEvent(Event event) {
		// TODO Auto-generated method stub

	}

}
