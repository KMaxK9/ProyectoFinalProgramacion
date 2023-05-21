package entities;

import java.sql.SQLException;
import java.util.ArrayList;

import enums.Species;
import exceptions.EntityNotExistsExpection;
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
	
	public Enemy(String name, ArrayList<Item> loot) throws SQLException, EntityNotExistsExpection {
		super(name);
		this.loot = loot;
	}
	
	

	
} // class
