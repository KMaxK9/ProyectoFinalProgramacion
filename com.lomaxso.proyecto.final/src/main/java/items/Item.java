package items;

import main.ThingsWithName;

public abstract class Item extends ThingsWithName {

	private byte lootPercentage;
	private boolean stackable;
	
	// Getters and Setters.
	
	public byte getLootPercentage() {
		return lootPercentage;
	}
	public void setLootPercentage(byte lootPercentage) {
		this.lootPercentage = lootPercentage;
	}
	public boolean isStackable() {
		return stackable;
	}
	public void setStackable(boolean stackable) {
		this.stackable = stackable;
	}
	
	// Constructor.
	
	public Item(String name, byte lootPercentage, boolean stackable) {
		super(name);
		this.lootPercentage = lootPercentage;
		this.stackable = stackable;
	}
	
	
	
} // class
