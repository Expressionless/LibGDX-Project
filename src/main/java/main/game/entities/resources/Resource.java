package main.game.entities.resources;

public enum Resource {
	CRYSTAL (0),
	WOOD (1),
	STONE(2),
	GOLD (3);
	
	public final int code;
	
	private Resource(int code) {
		this.code = code;
	}
}
