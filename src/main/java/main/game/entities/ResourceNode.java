package main.game.entities;

import main.game.Entity;
import main.utils.Point;

public abstract class ResourceNode extends Entity {

	protected int amount;
	
	public ResourceNode(Point pos) {
		super(null, pos);
		amount = 50;
	}

}
