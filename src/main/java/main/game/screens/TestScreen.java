package main.game.screens;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import main.game.GameObject;
import main.game.Player;
import main.game.Screen;
import main.game.entities.controllables.building.TownHall;
import main.game.entities.controllables.unit.production.Worker;
import main.game.entities.resources.Crystal;
import main.utils.Point;

public class TestScreen extends Screen {
	
	private GameObject worker;
	private SpriteBatch batch;
	private Player player;
	
	@Override
	public void show() {
		batch = new SpriteBatch();
		player = new Player("Steve");
		worker = new Worker(player, new Point(50, 50));
		
		new TownHall(player, new Point(100, 100));

		new Crystal(new Point( 300, 300));
		new Crystal(new Point( 300, 200));

		new Crystal(new Point( 100, 500));

		new Crystal(new Point( 50, 40));
	}
	
	@Override
	public void loadResources(AssetManager manager) {
	}
	
	@Override
	public void render(float delta) {
		GameObject.OBJECTS.removeIf((GameObject object) -> {
			return object.toDispose();
		});
		
		batch.begin();
		for(GameObject object : GameObject.OBJECTS) {
			object.render(batch);
		}
		batch.end();
		
		for(GameObject object : GameObject.OBJECTS) {
			object.update();
		}
	}

}
