package main.game;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import main.game.alarm.Alarm;
import main.utils.Point;

public abstract class GameObject {
	public static final ArrayList<GameObject> OBJECTS = new ArrayList<GameObject>();

	private boolean shouldDispose = false;
	
	protected static ShapeRenderer shapeRenderer = new ShapeRenderer();
	protected static BitmapFont font = new BitmapFont();
	
	protected abstract void draw(SpriteBatch batch);
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
		draw(batch);
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
	
	@SuppressWarnings("unchecked")
	public static <T extends GameObject> T find(Class<T> searchClass) {
		for(GameObject object : OBJECTS) {
			if(searchClass.isInstance(object))
				return (T)object;
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public <T extends GameObject> T findNearest(Class<T> searchClass) {
		GameObject current = null;
		for(GameObject object : OBJECTS) {
			if(!searchClass.isInstance(object))
				continue;
			if(current == null) {
				current = object;
				continue;
			}
			
			float dis1 = this.getPos().getDistTo(object.getPos());
			float dis2 = this.getPos().getDistTo(current.getPos());
			if(dis1 < dis2)
				current = object;
		}
		if(current != null)
			return (T)current;
		else return null;
	}
	
	public boolean toDispose() {
		return shouldDispose;
	}
	
	public void dispose() {
		shouldDispose = true;
	}
}
