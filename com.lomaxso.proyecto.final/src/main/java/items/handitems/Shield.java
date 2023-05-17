package items.handitems;

import items.HandItem;

public class Shield extends HandItem {

	private Short defense;

	// Getters and Setters.

	public Short getDefense() {
		return defense;
	}

	public void setDefense(Short defense) {
		this.defense = defense;
	}

	// Constructor.

	public Shield(String name, byte lootPercentage, boolean stackable) {
		super(name, lootPercentage, stackable);
		// TODO Auto-generated constructor stub
	}
} // class
