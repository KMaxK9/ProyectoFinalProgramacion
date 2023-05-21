package maps;

import java.util.ArrayList;
import entities.Enemy;

public class MapLevel {

	private ArrayList<Enemy> enemies;

	// Getters and Setters.
	
	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}

	public void setEnemies(ArrayList<Enemy> enemies) {
		this.enemies = enemies;
	}
	
	// Constructor.
	
	public MapLevel(ArrayList<Enemy> enemies) {
		super();
		this.enemies = enemies;
	}
	
} // class
