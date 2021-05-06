package main.game.entities.controllables.unit.production;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import main.game.Entity;
import main.game.GameObject;
import main.game.Player;
import main.game.entities.controllables.Unit;
import main.game.entities.controllables.building.TownHall;
import main.game.entities.resources.Crystal;
import main.utils.Point;

public class Worker extends Unit {
	
	private GameObject target = null;
	
	public Worker(Player player, Point pos) {
		super(null, player, pos);
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
		if(target == null) {
			if(storage.getCrystal() < 100) {
				target = GameObject.find(Crystal.class);
			} else target = GameObject.find(TownHall.class);
		} else {
			if(target instanceof Crystal) {
				if(this.pos.getDistTo(target.getPos()) > 32)
					this.move((Entity) target);
				else if(storage.getCrystal() < 100) {
					if(alarm[0].getTimer() == -1)
						storage.addCrystal(10);
				} else target = null;
			} else if(target instanceof TownHall) {
				if(this.pos.getDistTo(target.getPos()) > 32)
					this.move((Entity) target);
				else if(storage.getCrystal() > 0) {
					player.getResources().addCrystal(storage.getCrystal());
					storage.setCrystal(0);
				} else target = null;
			}
		}
	}

}
