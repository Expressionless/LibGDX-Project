package main.game.entities;

public class ResourceStore {

	private int crystal = 0;
	private int wood = 0;
	private int stone = 0;
	private int gold = 0;
	
	public int getCrystal() {
		return crystal;
	}
	public void setCrystal(int crystal) {
		this.crystal = crystal;
	}
	
	public void addCrystal(int crystal) {
		this.crystal += crystal;
	}
	
	public int getWood() {
		return wood;
	}
	public void setWood(int wood) {
		this.wood = wood;
	}
	
	public void addWood(int wood) {
		this.wood += wood;
	}
	
	public int getStone() {
		return stone;
	}
	public void setStone(int stone) {
		this.stone = stone;
	}
	public void addStone(int stone) {
		this.stone += stone;
	}
	
	public int getGold() {
		return gold;
	}
	
	public void setGold(int gold) {
		this.gold = gold;
	}
	
	public void addGold(int gold) {
		this.gold += gold;
	}
	
}
