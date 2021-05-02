package main.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;

public abstract class Screen extends ScreenAdapter {

	public abstract void loadResources(AssetManager manager);
	
}
