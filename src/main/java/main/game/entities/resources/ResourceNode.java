package main.game.entities.resources;

import main.game.Entity;
import main.utils.Point;

public abstract class ResourceNode extends Entity {

	private int amount, initAmount;
	
	public ResourceNode(Point pos, int amount) {
		super(null, pos);
		this.initAmount = amount;
		this.amount = amount;
	}
}
