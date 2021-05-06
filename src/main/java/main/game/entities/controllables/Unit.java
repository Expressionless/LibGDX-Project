package main.game.entities.controllables;

import com.badlogic.gdx.graphics.g2d.Sprite;

import main.game.Entity;
import main.game.Player;
import main.game.entities.ResourceStore;
import main.utils.Point;

public abstract class Unit extends Entity {
	protected ResourceStore storage;
	protected Player player;

	public Unit(Sprite sprite, Player player, Point pos) {
		//TODO: Remove null
		super(null, pos);
		storage = new ResourceStore();
		this.player = player;
	}
}
