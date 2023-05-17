package items;

public abstract class Wear extends Item {

	private Short defense;

	// Getters and Setters.
	
	public Short getDefense() {
		return defense;
	}

	public void setDefense(Short defense) {
		this.defense = defense;
	}
	
	// Constructor.

	public Wear(String name, byte lootPercentage, boolean stackable, Short defense) {
		super(name, lootPercentage, stackable);
		this.defense = defense;
	}
	
	
	
} // class
