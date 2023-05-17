package items.consumables;

import items.Consumable;

public class Cure extends Consumable {

	private Short health;

	// Getters and Setters.
	
	public Short getHealth() {
		return health;
	}

	public void setHealth(Short health) {
		this.health = health;
	}
	
	// Constructor.

	public Cure(String name, byte lootPercentage, boolean stackable, Short health) {
		super(name, lootPercentage, stackable);
		this.health = health;
	}
	


} // class
