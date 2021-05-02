package main.game;

import com.badlogic.gdx.graphics.g2d.Sprite;

import main.utils.Point;

public abstract class Entity extends GameObject {

	public Entity(Sprite sprite, Point pos) {
		super(sprite, pos);
	}

}
