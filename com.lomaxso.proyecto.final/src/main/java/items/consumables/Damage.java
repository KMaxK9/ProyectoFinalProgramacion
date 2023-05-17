package items.consumables;

import items.Consumable;

public class Damage extends Consumable {

	private Short damage;

	// Getters and Setters.

	public Short getDamage() {
		return damage;
	}

	public void setDamage(Short damage) {
		this.damage = damage;
	}

	// Constructor.

	public Damage(String name, byte lootPercentage, boolean stackable) {
		super(name, lootPercentage, stackable);
		// TODO Auto-generated constructor stub
	}

} // class
