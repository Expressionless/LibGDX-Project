package main;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.ScreenUtils;

import main.input.Input;
import main.input.Mouse;

public class Boot extends Game {

	private AssetManager manager;
	private SpriteBatch batch;
	private OrthographicCamera camera;
	private Input input;
	private Mouse mouse;
	
	private ShapeRenderer loadRenderer;
	
	@Override
	public void create() {
		manager = new AssetManager();
		camera = new OrthographicCamera();
		camera.setToOrtho(true, 1280, 720);
		
		mouse = new Mouse(0, 0);
		input = new Input(mouse);
		loadRenderer = new ShapeRenderer();
		
		Gdx.input.setInputProcessor(input);
	}
	
	@Override
	public void render() {
		ScreenUtils.clear(Color.WHITE);
		if(manager.update()) {			
			camera.update();
		}
		loadRenderer.begin(ShapeType.Filled);
		loadRenderer.setColor(Color.BLACK);
		loadRenderer.rect(100, 100, 300, 300);
		loadRenderer.end();
		float progress = manager.getProgress();
	}
	
}
