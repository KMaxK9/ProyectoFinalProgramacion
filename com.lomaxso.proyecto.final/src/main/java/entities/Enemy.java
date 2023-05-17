package entities;

import java.util.ArrayList;

import enums.Species;
import items.Item;

public class Enemy extends Entity {

	private ArrayList<Item> loot;
	
	// Getters and Setters.

	public ArrayList<Item> getLoot() {
		return loot;
	}

	public void setLoot(ArrayList<Item> loot) {
		this.loot = loot;
	}

	// Constructor.
	
	public Enemy(String name, Species species, ArrayList<Item> loot) {
		super(name, species);
		this.loot = loot;
	}
	

	
} // class
