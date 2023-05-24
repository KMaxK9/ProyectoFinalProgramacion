package entities;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Random;

import enums.Species;
import exceptions.EntityNotExistsExpection;
import main.ThingsWithName;
import utils.DAO;

public abstract class Entity extends ThingsWithName {

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

	public Entity() {
	}

	public Entity(String name, Species species) {
		super(name);
		this.species = species;
		this.level = 1;
		this.life = 50;
		this.damage = 20;
		this.defense = 5;
	} // contructor

	public Entity(String name) throws SQLException, EntityNotExistsExpection {
		super(name);
		LinkedHashSet<String> fields = new LinkedHashSet<String>();
		LinkedHashMap<String, Object> restricciones = new LinkedHashMap<String, Object>();
		fields.add("name");
		fields.add("species");
		fields.add("levels");
		fields.add("life");
		fields.add("damage");
		fields.add("defense");
		restricciones.put("name", name);
		ArrayList<Object> entity = DAO.consult("entity", fields, restricciones);
		if (entity.size() > 0) {
			this.species = Species.valueOf(entity.get(1) + "");
			this.level = Short.parseShort(entity.get(2) + "");
			this.life = Short.parseShort(entity.get(3) + "");
			this.damage = Short.parseShort(entity.get(4) + "");
			this.defense = Short.parseShort(entity.get(5) + "");
		} else {
			throw new EntityNotExistsExpection("");
		} // if / else
	} // contructorDB

	public void enemysLife() throws SQLException, EntityNotExistsExpection {
		LinkedHashSet<String> fields = new LinkedHashSet<String>();
		LinkedHashMap<String, Object> restricciones = new LinkedHashMap<String, Object>();
		fields.add("name");
		fields.add("life");
		restricciones.put("name", getName());
		ArrayList<Object> entity = DAO.consult("entity", fields, restricciones);
		if (entity.size() > 0) {
			this.life = Short.parseShort(entity.get(1) + "");
		} else {
			throw new EntityNotExistsExpection("");
		} // if / else
	} // enemy

	public Short attack(Entity rival, Short lastDefense) {
		Random r = new Random();
		Short damage = (short) r.nextDouble(this.getDamage() * 0.7, this.getDamage() * 1.3);
		rival.receiveDamage((short) (damage - lastDefense));
		System.out.println("Daño original: " + damage + ", ultima defensa: " + lastDefense);
		return damage;
	} // attack

	public Short blockAttack() {
		Random r = new Random();
		Short defense;
		if (r.nextInt(0, 7) > 0) {
			defense = (short) (this.getDefense() + (r.nextInt(0, this.getDefense() / 2)));
			System.out.println(this.getName() + " se prepara para el ataque con " + defense);
		} else { // chance to doble the defense when blocking.
			defense = (short) (this.getDefense() * 2);
			System.out.println(this.getName() + " se prepara para el ataque con " + defense);
		} // if
		return defense;
	} // blockAttack

	public Short receiveDamage(Short incomingDamage) {

		if (incomingDamage >= 0) {
			this.life = (short) (this.life - incomingDamage);
			if (this.life < 0) {
				this.life = 0;
			} // if
		} // if (damage > 0)
		System.out.println(this.getName() + " recibe " + incomingDamage + " puntos de daño, y le quedan " + this.life
				+ " puntos de vida.");
		return this.life;
	} // receiveDamage

	public Short enemyAction(Entity rival, Short lastDefense) {
		Random r = new Random();

		if (r.nextInt(0, 3) > 0) {
			System.out.println("Enemigo elige pegar");
			this.attack(rival, lastDefense);
			return this.getDefense();
		} else {
			System.out.println("Enemigo elige defender");
			return this.blockAttack();
		} // if / else
	} // enemyAction

	public Short playerAction(boolean option, Enemy rival, Short lastDefense) {
		if (option) { // option (true = attack)
			System.out.println("Jugador elige pegar");
			this.attack(rival, lastDefense);
			return this.getDefense();
		} else { // false (defend).
			System.out.println("Jugador elige defender");
			return this.blockAttack();
		} // if / else
	} // playerAction

} // class
