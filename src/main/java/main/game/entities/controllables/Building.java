package main.game.entities.controllables;

import com.badlogic.gdx.graphics.g2d.Sprite;

import main.game.entities.Controllable;
import main.utils.Point;

public abstract class Building extends Controllable {

	public Building(Sprite sprite, Point pos) {
		super(sprite, pos);
	}

}
