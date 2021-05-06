package main.game.entities.resources;

import main.game.entities.controllables.Unit;

public class ResourceStore {

	private int[] resources;
	private int maxStore = 100;
	
	public ResourceStore() {
		resources = new int[Resource.values().length];
		
		for(int i = 0; i < resources.length; i++) {
			resources[i] = 0;
		}
	}
	
	public float percent(Resource resource) {
		return (float)get(resource) / (float)maxStore;
	}
	
	public int get(Resource resource) {
		return resources[resource.code];
	}
	
	public boolean set(Resource resource, int val) {
		if(val < 0) 
			return false;
		
		resources[resource.code] = val;
		return true;
	}
	
	public boolean add(Resource resource, int val) {
		if(val + resources[resource.code] > maxStore && maxStore != -1)
			return false;
		resources[resource.code] += val;
		return true;
	}
	
	public boolean sub(Resource resource, int val) {
		if(val > resources[resource.code])
			return false;
		resources[resource.code] -= val;
		return true;
	}
	
	public boolean hasRoom(Resource resource) {
		if(maxStore != -1)
			return resources[resource.code] < maxStore;
		return true;
	}
	
	public boolean transfer(Resource resource, Unit target) {
		return this.transfer(resource, target.getStore());
	}
	
	public boolean transfer(Resource resource, ResourceStore target) {
		return this.transfer(resource, target, this.get(resource));
	}
	
	public boolean transfer(Resource resource, Unit target, int amount) {
		return this.transfer(resource, target.getStore(), amount);
	}
	
	public boolean transfer(Resource resource, ResourceStore target, int amount) {
		if(!target.hasRoom(resource))
			return false;
		if(this.get(resource) < amount)
			return false;
		
		target.add(resource, amount);
		this.sub(resource, amount);
		return true;
	}
	
	public void setMaxStore(int maxStore) {
		this.maxStore = maxStore;
	}
}
