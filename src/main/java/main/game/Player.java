package main.game;

import java.util.ArrayList;

import main.game.entities.Controllable;
import main.game.entities.ResourceStore;
import main.game.entities.controllables.Building;
import main.game.entities.controllables.Unit;

public class Player {

	private String name;
	private boolean AI;
	
	private ArrayList<Controllable> selected;
	private ArrayList<Unit> units;
	private ArrayList<Building> buildings;
	
	private ResourceStore resources;
	
	/**
	 * Create a new basic ai player
	 * @param name
	 */
	public Player(String name) {
		this(name, true);
	}
	
	public Player(String name, boolean AI) {
		selected = new ArrayList<>();
		units = new ArrayList<>();
		buildings = new ArrayList<>();
		
		resources = new ResourceStore();
		resources.setWood(400);
		resources.setStone(400);
		resources.setGold(200);
		resources.setCrystal(100);
	}
	
	public ResourceStore getResources() {
		return resources;
	}
	
}
