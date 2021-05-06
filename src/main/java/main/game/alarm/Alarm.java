package main.game.alarm;

public class Alarm {
	public static final int ALARM_COUNT = 10;

	private Event action;
	private int timer = -1;
	
	public Alarm() {
		this.action = null;
		this.timer = -1;
	}
	
	public Alarm(Event action, int timer) {
		this.action = action;
		this.timer = timer;
	}
	
	public void setAction(Event action, int timer) {
		this.action = action;
		this.timer = timer;
	}
	
	public void setTimer(int timer) {
		this.timer = timer;
	}
	
	public int getTimer() {
		return timer;
	}
	
	public void update() {
		if(timer > 0) {
			timer--;
		} else if (timer == 0) {
			action.event();
			timer = -1;
		}
	}
	
}
