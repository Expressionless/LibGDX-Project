package main.game;

import main.utils.Point;

public abstract class Entity extends GameObject {

	protected float width;
	protected float height;

	public Entity(String sprite, Point pos) {
		super(sprite, pos);
	}

}
