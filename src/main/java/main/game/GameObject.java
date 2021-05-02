package main.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import main.utils.Point;

public abstract class GameObject {

	protected Point pos;
	protected Sprite sprite;
	
	protected abstract void draw();
	protected abstract void step();
	
	public GameObject(Sprite sprite, Point pos) {
		this.sprite = sprite;
		this.pos = pos;
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
	
}
