package main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;

import main.game.GameObject;
import main.game.screens.TestScreen;
import main.input.Input;
import main.input.Mouse;

public class Game extends com.badlogic.gdx.Game {

	private AssetManager manager;

	private OrthographicCamera camera;
	private Input input;
	private Mouse mouse;
	
	@Override
	public void create() {
		manager = new AssetManager();
		camera = new OrthographicCamera();
		camera.setToOrtho(true, 1280, 720);
		mouse = new Mouse(0, 0);
		input = new Input(mouse);
		
		Gdx.input.setInputProcessor(input);

		this.setScreen(new TestScreen());
	}
	
	@Override
	public void render() {
		ScreenUtils.clear(new Color(0, 0.25f, 0, 1));
		// Load anything there is to load
		// if nothing to load -> update the screen
		if(manager.update()) {			
			camera.update();
			this.getScreen().render(1);
		}
	}
	
	public AssetManager getAssets() {
		return manager;
	}
	
}
