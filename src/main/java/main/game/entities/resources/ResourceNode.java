package main.game.entities.resources;

import main.game.Entity;
import main.game.entities.controllables.Unit;
import main.utils.Point;

public abstract class ResourceNode extends Entity {

	private Resource type;
	private ResourceStore store;
	private int initAmount;
	
	public ResourceNode(Point pos, Resource type, int amount) {
		super(null, pos);
		this.initAmount = amount;
		this.type = type;
		this.store = this.createResourceStore(type, amount);
	}
	
	private ResourceStore createResourceStore(Resource res, int amount) {
		ResourceStore store = new ResourceStore(amount);
		store.add(res, amount);
		
		return store;
	}

	@Override
	protected void step() {
		if(this.getStore().get(type) == 0)
			this.dispose();
	}
	
	public boolean transfer(Unit target, int amount) {
		if(!target.getStore().hasRoom(type))
			return false;
		if(this.getStore().get(type) < amount)
			amount = this.getStore().get(type);
		
		target.getStore().add(type, amount);
		this.getStore().sub(type, amount);
		
		return true;
	}
	
	public int getInitAmount() {
		return initAmount;
	}
	
	public ResourceStore getStore() {
		return store;
	}
	
	public Resource getType() {
		return type;
	}
}
