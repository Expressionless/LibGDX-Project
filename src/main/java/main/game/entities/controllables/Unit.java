package main.game.entities.controllables;

import com.badlogic.gdx.graphics.g2d.Sprite;

import main.game.Entity;
import main.game.GameObject;
import main.game.Player;
import main.game.entities.Controllable;
import main.game.entities.controllables.unit.UnitState;
import main.game.entities.resources.ResourceStore;
import main.utils.Point;

public abstract class Unit extends Entity implements Controllable {

	private Action action = null;
	
	private UnitState lastState, state;
	
	private ResourceStore storage;
	private Player player;

	public Unit(Sprite sprite, Player player, Point pos) {
		//TODO: Remove null
		super(null, pos);
		
		storage = new ResourceStore();
		state = UnitState.IDLE;
		
		this.player = player;
	}
	
	@Override
	public void move(Point coords) {
		super.move(coords);
		this.setState(UnitState.MOVING);
	}
	
	@Override
	public void move(GameObject target) {
		this.move(target.getPos());
	}
	
	public UnitState getState() {
		return state;
	}
	
	public void setState(UnitState state) {
		this.state = state;
	}
	
	public UnitState getLastState() {
		return lastState;
	}
	
	/**
	 * Set the unit state to the last state
	 */
	public void setLastState() {
		UnitState last = this.state;
		
		this.state = this.lastState;
		this.lastState = last;
	}
	
	public ResourceStore getStore() {
		return storage;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public void setAction(GameObject target, ActionEvent event) {
		this.action = new Action(target, event);
	}
	
	public Action getAction() {
		return action;
	}
	
	private class Action {
		public final ActionEvent event;
		public final GameObject target;
		
		public Action(GameObject target, ActionEvent event) {
			this.event = event;
			this.target = target;
		}
	}
}
