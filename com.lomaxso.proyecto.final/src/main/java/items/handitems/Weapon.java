package items.handitems;

import items.HandItem;

public class Weapon extends HandItem {

	private Short damage;

	// Getters and Setters.

	public Short getDamage() {
		return damage;
	}

	public void setDamage(Short damage) {
		this.damage = damage;
	}

	// Constructor.

	public Weapon(String name, byte lootPercentage, boolean stackable) {
		super(name, lootPercentage, stackable);
		// TODO Auto-generated constructor stub
	}

} // class
