package items;

public abstract class Artifact extends Item {

	private Short defense;
	private Short damage;
	private Short life;
	
	// Getters and Setters.
	
	public Short getDefense() {
		return defense;
	}
	public void setDefense(Short defense) {
		this.defense = defense;
	}
	public Short getDamage() {
		return damage;
	}
	public void setDamage(Short damage) {
		this.damage = damage;
	}
	public Short getLife() {
		return life;
	}
	public void setLife(Short life) {
		this.life = life;
	}
	
	// Constructor.
	
	public Artifact(String name, byte lootPercentage, boolean stackable, Short defense, Short damage, Short life) {
		super(name, lootPercentage, stackable);
		this.defense = defense;
		this.damage = damage;
		this.life = life;
	}
	
	
	
} // class
