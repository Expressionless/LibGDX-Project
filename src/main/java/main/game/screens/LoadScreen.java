package main.game.screens;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

import main.game.Screen;

public class LoadScreen extends Screen {
	
	@Override
	public void loadResources(AssetManager manager) {
		manager.load("res/button.png", Texture.class);
	}
	
	@Override
	public void render(float delta) {
		
	}
	
	@Override
	public void show() {
		
	}

	@Override
	public void hide() {
		
	}

}
