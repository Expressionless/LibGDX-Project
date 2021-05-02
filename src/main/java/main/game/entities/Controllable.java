package main.game.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;

import main.game.Entity;
import main.utils.Point;

public abstract class Controllable extends Entity {

	public Controllable(Sprite sprite, Point pos) {
		super(sprite, pos);
	}
}
