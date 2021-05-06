package main.game;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import main.game.alarm.Alarm;
import main.utils.Point;

public abstract class GameObject {
	public static final ArrayList<GameObject> OBJECTS = new ArrayList<GameObject>();

	protected static ShapeRenderer shapeRenderer = new ShapeRenderer();
	
	protected abstract void draw();
	protected abstract void step();

	protected Point pos;
	protected Sprite sprite;
	
	protected Alarm[] alarm;
	
	public GameObject(String spriteRef, Point pos) {
		//this.sprite = ;
		this.pos = pos;
		alarm = new Alarm[Alarm.ALARM_COUNT];
		for(int i = 0; i < Alarm.ALARM_COUNT; i++) {
			alarm[i] = new Alarm();
		}
		OBJECTS.add(this);
	}
	
	public void render(SpriteBatch batch) {
		if(sprite != null) {
			sprite.draw(batch);
		}
		draw();
	}
	
	public void update() {
		for(Alarm alarm : alarm) {
			alarm.update();
		}
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
