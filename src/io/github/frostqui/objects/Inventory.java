package io.github.frostqui.objects;

import java.util.ArrayList;

import io.github.frostqui.gui.Screen;
import io.github.frostqui.gui.Sprite;

public class Inventory {
	
	private int w,h;
	
	public static ArrayList<Item> items = new ArrayList<Item>();
	
	public Inventory(int w, int h) {
		this.w = w;
		this.h = h;
		
		for(int i=0; i < 7; i++) {
			Item item = new Item(i,"Item número: "+i, Sprite.test);
			add(item);
		}
	}
	
	public void add(int id, int amount ) {
		
	}
	
	public void add(Item item) {
		items.add(item);
	}
	
	public void remove(Item item) {
		items.remove(item);
	}

	public void render(Screen screen) {
		for(int i=0; i<items.size(); i++) {
			screen.renderSprite((w / 2) + (i * 22), h - 25, items.get(i).sprite);
			screen.renderSprite((w / 2) + (i * 22), h - 25, Sprite.selected);
			
			
		}
	}
}
