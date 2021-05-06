package main.game.entities.controllables.building;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import main.game.Player;
import main.game.entities.controllables.Building;
import main.game.entities.resources.Resource;
import main.utils.Point;

public class TownHall extends Building {

	public TownHall(Player player, Point pos) {
		super(null, player, pos);
		width = 64;
		height = 64;
	}

	@Override
	protected void draw(SpriteBatch batch) {
		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.setColor(new Color(0.25f, 0.25f, 0.25f, 1));
		shapeRenderer.rect(pos.getX(), pos.getY(), width, height);
		
		float width = 48;
		float height = 8;
		
		shapeRenderer.setColor(Color.BLUE);
		shapeRenderer.rect(pos.getX() - width / 2, pos.getY() + height * 2, width * this.getStore().percent(Resource.CRYSTAL), height);
		shapeRenderer.end();
	}

	@Override
	protected void step() {		
	}

}
