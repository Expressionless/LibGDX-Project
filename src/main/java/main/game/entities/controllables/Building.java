package main.game.entities.controllables;

import com.badlogic.gdx.graphics.g2d.Sprite;

import main.game.Player;
import main.utils.Point;

public abstract class Building extends Unit {

	public Building(Sprite sprite, Player player, Point pos) {
		super(sprite, player, pos);
	}

}
