package io.github.frostqui.events.types;

import io.github.frostqui.events.Event;

public class MousePressedEvent extends MouseButtonEvent {

	public MousePressedEvent(int button, int x, int y) {
		super(button, x, y, Event.Type.MOUSE_PRESSED);
	}

}
