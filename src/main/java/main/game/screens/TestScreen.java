package main.game.screens;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import main.game.GameObject;
import main.game.Screen;
import main.game.entities.controllables.building.TownHall;
import main.game.entities.controllables.unit.production.Worker;
import main.game.entities.resources.Crystal;
import main.utils.Point;

public class TestScreen extends Screen {
	
	private GameObject worker;
	private SpriteBatch batch;
	
	@Override
	public void show() {
		batch = new SpriteBatch();
		worker = new Worker(new Point(50, 50));
		
		new TownHall(new Point(100, 100));
		
		new Crystal(new Point( 300, 300));
	}
	
	@Override
	public void loadResources(AssetManager manager) {
	}
	
	@Override
	public void render(float delta) {
		batch.begin();
		for(GameObject object : GameObject.OBJECTS) {
			object.render(batch);
		}
		batch.end();
	}

}
