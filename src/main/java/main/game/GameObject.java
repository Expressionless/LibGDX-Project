package main.game;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import main.utils.Point;

public abstract class GameObject {
	public static final ArrayList<GameObject> OBJECTS = new ArrayList<GameObject>();

	protected static ShapeRenderer shapeRenderer = new ShapeRenderer();

	protected Point pos;
	protected Sprite sprite;
	
	protected abstract void draw();
	protected abstract void step();
	
	public GameObject(String spriteRef, Point pos) {
		//this.sprite = ;
		this.pos = pos;
		
		OBJECTS.add(this);
	}
	
	public void render(SpriteBatch batch) {
		if(sprite != null) {
			sprite.draw(batch);
		}
		draw();
	}
	
	public void update() {
		step();
	}
	
	public Point getPos() {
		return pos;
	}
	
	public Sprite getSprite() {
		return sprite;
	}
	
	public void setSprite(Sprite s) {
		this.sprite = s;
	}
	
	public static <T extends GameObject> T find(Class<T> searchClass) {
		for(GameObject object : OBJECTS) {
			if(searchClass.isInstance(object))
				return (T)object;
		}
		return null;
		
	}
}
