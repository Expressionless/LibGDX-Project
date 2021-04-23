package main.input;

import main.utils.Point;

public class Mouse {

	private Point pos;
	
	public Mouse(Point pos) {
		this.pos = pos;
	}
	
	public Mouse(float x, float y) {
		this(new Point(x, y));
	}
	
	public Point getPos() {
		return pos;
	}
	
}
