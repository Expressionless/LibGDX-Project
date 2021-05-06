package main.game.entities.controllables.unit.production;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import main.game.GameObject;
import main.game.Player;
import main.game.entities.ResourceNode;
import main.game.entities.controllables.Unit;
import main.game.entities.controllables.building.TownHall;
import main.game.entities.resources.Crystal;
import main.game.entities.resources.Resource;
import main.utils.Point;

public class Worker extends Unit {
	private GameObject target = null;
	public final int HARVEST_TIME = 90;

	public Worker(Player player, Point pos) {
		super(null, player, pos);
		width = 12;
		height = 12;
	}

	@Override
	protected void draw(SpriteBatch batch) {
		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.setColor(Color.RED);
		shapeRenderer.rect(pos.getX(), pos.getY(), width, height);
		shapeRenderer.end();

	}

	@Override
	protected void step() {
		if (this.getStore().hasRoom(Resource.CRYSTAL)) {
			if(target != null)
				if(!(target instanceof ResourceNode))
					target = null;
			if (target == null)
				target = GameObject.find(Crystal.class);
			if (!this.hasMet(target))
				this.move(target);
			else {
				if (!alarm[0].isActive()) {
					alarm[0].setAction(() -> {
						this.getStore().add(Resource.CRYSTAL, 10);
						System.out.println(this.getStore().get(Resource.CRYSTAL));
					}, HARVEST_TIME);
				}
			}
		} else {
			if(target != null)
				if(!(target instanceof TownHall))
					target = null;
			if(target == null)
				target = GameObject.find(TownHall.class);
			
			if(!this.hasMet(target))
				this.move(target);
			else {
				this.getStore().transfer(Resource.CRYSTAL, ((Unit) target).getPlayer().getResources());
			}
					
		}
	}

}
