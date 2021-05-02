package main.game.entities.controllables.unit.production;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import main.game.GameObject;
import main.game.entities.controllables.Unit;
import main.utils.Point;

public class Worker extends Unit {
	
	GameObject target = null;
	
	public Worker(Point pos) {
		super(null, pos);
		width = 12;
		height = 12;
	}

	@Override
	protected void draw() {
		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.setColor(Color.RED);
		shapeRenderer.rect(pos.getX(), pos.getY(), width, height);
		shapeRenderer.end();
		
	}

	@Override
	protected void step() {
		// TODO Auto-generated method stub
		if(target == null) {
			GameObject.find(Crystal.class);
		}
	}

}
