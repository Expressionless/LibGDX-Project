package main.game.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;

import main.game.Entity;
import main.utils.Point;

public abstract class Unit extends Entity {

	public Unit(Sprite sprite, Point pos) {
		super(sprite, pos);
	}

}
