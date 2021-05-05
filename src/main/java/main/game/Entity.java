package main.game;

import main.utils.Point;

public abstract class Entity extends GameObject {
	
	protected float width, height;
	protected UnitStats stats;

	public Entity(String sprite, Point pos) {
		super(sprite, pos);
		stats = new UnitStats();
	}
	
	public void move(Point coord) {
		float max = stats.getStat("maxSpeed");
		Point unitVec = pos.getUnitVector(coord);
		
		pos.setX(pos.getX() + unitVec.getX() * max);
		pos.setY(pos.getY() + unitVec.getY() * max);
	}
	
	public void move(Entity other) {
		this.move(other.pos);
	}
	
	protected class UnitStats {
		
		private float speed = 0, maxSpeed = 1.5f;
		private float acc = 0;
		private float defence;
		private float attack;
		private float inches;
		
		public void setStat(String stat, float val) {
			try {
				UnitStats.class.getDeclaredField(stat).set(this, val);
			} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
				e.printStackTrace();
			}
		}
		
		public float getStat(String stat) {
			try {
				return UnitStats.class.getDeclaredField(stat).getFloat(this);
			} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
				e.printStackTrace();
			}
			
			return -1;
		}
	}
	
}
