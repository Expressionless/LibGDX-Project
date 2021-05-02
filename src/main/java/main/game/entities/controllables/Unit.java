package main.game.entities.controllables;

import com.badlogic.gdx.graphics.g2d.Sprite;

import main.game.Entity;
import main.utils.Point;

public abstract class Unit extends Entity {

	public Unit(Sprite sprite, Point pos) {
		//TODO: Remove null
		super(null, pos);
	}

}