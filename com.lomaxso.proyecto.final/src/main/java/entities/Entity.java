package entities;

import enums.Species;
import main.ThingsWithName;

public class Entity extends ThingsWithName {

	private Species species;
	private Short level;
	private Short life;
	private Short damage;
	private Short defense;
	
	// Getters and Setters.
	
	public Species getSpecies() {
		return species;
	}
	public void setSpecies(Species species) {
		this.species = species;
	}
	public Short getLevel() {
		return level;
	}
	public void setLevel(Short level) {
		this.level = level;
	}
	public Short getLife() {
		return life;
	}
	public void setLife(Short life) {
		this.life = life;
	}
	public Short getDamage() {
		return damage;
	}
	public void setDamage(Short damage) {
		this.damage = damage;
	}
	public Short getDefense() {
		return defense;
	}
	public void setDefense(Short defense) {
		this.defense = defense;
	}
	
	// Constructors.
	
	public Entity(String name, Species species) {
		super(name);
		this.species = species;
		this.level = 1;
		this.life = 100;
		this.damage = 100;
		this.defense = 100;
	}
	
	
	
	
} // class
