package main.game.entities.controllables.unit.production;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import main.game.Entity;
import main.game.GameObject;
import main.game.entities.controllables.Unit;
import main.game.entities.resources.Crystal;
import main.utils.Point;

public class Worker extends Unit {
	
	private GameObject target = null;
	
	public Worker(Point pos) {
		super(null, pos);
		width = 12;
		height = 12;
		stats.setStat("inches", 5);
		System.out.println(stats.getStat("inches"));
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
		if(target == null) {
			target = GameObject.find(Crystal.class);
		} else {
			this.move((Entity) target);
		}
	}

}
