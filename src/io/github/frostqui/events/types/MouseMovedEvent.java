package io.github.frostqui.events.types;

import io.github.frostqui.events.Event;

public class MouseMovedEvent extends Event {

	private int x, y;
	private boolean dragged;
	
	public MouseMovedEvent(int x, int y, boolean dragged) {
		super(Event.Type.MOUSE_MOVED);
		this.x = x;
		this.y = y;
		this.dragged = dragged;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean getDragged() {
		return dragged;
	}
	
}
