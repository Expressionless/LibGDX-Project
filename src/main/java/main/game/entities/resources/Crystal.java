package main.game.entities.resources;

import java.util.Random;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import main.utils.Point;

public class Crystal extends ResourceNode {
	public static final int MAX_NODES = 5;
	public static final float CRYSTAL_RADIUS = 48;
	public static final float MAX_NODE_WIDTH = 16;

	private Point[] nodes;

	public Crystal(Point pos, int amount) {
		super(pos, Resource.CRYSTAL, amount);

		initNodes();
	}

	private void initNodes() {
		nodes = new Point[MAX_NODES];
		Random r = new Random();
		float x, y;

		for (int i = 0; i < MAX_NODES; i++) {
			x = pos.getX() - CRYSTAL_RADIUS / 2 + r.nextFloat() * CRYSTAL_RADIUS;
			y = pos.getY() - CRYSTAL_RADIUS / 2 + r.nextFloat() * CRYSTAL_RADIUS;
			nodes[i] = new Point(x, y);
		}
	}

	@Override
	protected void draw(SpriteBatch batch) {
		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.setColor(Color.BLUE);

		for (Point nodePos : nodes) {

			shapeRenderer.rect(nodePos.getX(), nodePos.getY(), MAX_NODE_WIDTH, MAX_NODE_WIDTH);
		}

		shapeRenderer.setColor(new Color(0f, 0.5f, 1f, 1f));
		
		float margin = 6;
		
		for (Point nodePos : nodes) {

			shapeRenderer.rect(nodePos.getX() + margin / 2, nodePos.getY() + margin / 2 , MAX_NODE_WIDTH - margin, MAX_NODE_WIDTH - margin);
		}

		shapeRenderer.end();
	}

}
