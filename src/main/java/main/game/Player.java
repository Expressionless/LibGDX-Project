package main.game;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import main.game.entities.Controllable;
import main.game.entities.controllables.Building;
import main.game.entities.controllables.Unit;
import main.game.entities.resources.Resource;
import main.game.entities.resources.ResourceStore;
import main.utils.Point;

public class Player extends GameObject {
	private SpriteBatch batch;

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
		super(null, new Point(0, 0));
		selected = new ArrayList<>();
		units = new ArrayList<>();
		buildings = new ArrayList<>();
		
		resources = new ResourceStore();
		resources.setMaxStore(-1);
		resources.set(Resource.WOOD, 100);
		resources.set(Resource.STONE, 100);
		resources.set(Resource.CRYSTAL, 100);
		resources.set(Resource.GOLD, 100);
		
		batch = new SpriteBatch();
	}
	
	public ResourceStore getResources() {
		return resources;
	}
	
	public void renderUI(SpriteBatch batch) {
		batch.begin();
		String string = "Crystal: " + Integer.toString(resources.get(Resource.CRYSTAL));
		font.draw(batch, string, 10, 100);
		batch.end();
	}

	@Override
	protected void draw(SpriteBatch b) {
		renderUI(batch);
		
	}

	@Override
	protected void step() {
		
	}
	
}
