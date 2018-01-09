package io.github.frostqui.objects;

import io.github.frostqui.gui.Sprite;

public class Item {
	
	public int id;
	public int amount;
	public String name;
	public Sprite sprite;
	
	public Item(int id, String name, Sprite sprite) {
		this.id = id;
		this.name = name;
		this.sprite = sprite;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
