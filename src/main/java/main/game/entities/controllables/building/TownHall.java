package main.game.entities.controllables.building;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import main.game.entities.controllables.Building;
import main.utils.Point;

public class TownHall extends Building {

	public TownHall(Point pos) {
		super(null, pos);
		width = 64;
		height = 64;
	}

	@Override
	protected void draw() {
		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.setColor(new Color(0.25f, 0.25f, 0.25f, 1));
		shapeRenderer.rect(pos.getX(), pos.getY(), width, height);
		shapeRenderer.end();
		
	}

	@Override
	protected void step() {		
	}

}
