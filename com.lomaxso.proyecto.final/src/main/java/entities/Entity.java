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

	public Entity fight(Enemy rival) {
		Short rivalLife = rival.getLife();
		rival.setLife(rivalLife);
		while (this.life > 0 && rivalLife > 0) {
			Short defensa = rival.defend();
			Short ataque = this.attack();
			Entity.espera((short) 750);
			rivalLife = rival.receiveDamage((short) (ataque - defensa), rivalLife);
			Entity.espera((short) 750);
			if (rivalLife > 0) {
				ataque = rival.attack();
				defensa = this.defend();
				Entity.espera((short) 750);
				this.receiveDamage((short) (ataque - defensa), this.life);
			} // if
		} // while
		return (this.life > 0 ? this : rival);
	} // fight

	public void battle(ArrayList<Enemy> enemies) {
		for (byte i = 0; i < enemies.size(); i++) {
			Entity ganador = this.fight(enemies.get(i));
			System.out.println("Ha ganado: " + ganador);
		} // for
	} // battle

	public Short attack() {
		Short ataqueHecho = this.getDamage();
		System.out.println(this.getName() + " ataca y hace " + ataqueHecho + " de daño.");
		return ataqueHecho;
	} // attack

	public Short receiveDamage(Short receivedDamage, Short receivedLife) {
		Short entityLife = receivedLife;
		
		if (receivedDamage >= 0) {
			if (this.getClass().equals(Player.class)) {
				this.life = (short) (this.life - receivedDamage);
				if (this.life < 0) {
					this.life = 0;
				} // if
		} else {
			entityLife = (short) (entityLife - receivedDamage);
			if (entityLife < 0) {
				entityLife = 0;
			} // if
		} // if / else
			
			System.out.println(this.getName() + " recibe " + receivedDamage + " puntos de daño, y le quedan " + entityLife
					+ " puntos de vida.");
		} // if (damage > 0)
		return entityLife;
	} // receiveDamage

	public Short defend() {
		Short dañoBloqueado = this.getDefense();
		System.out.println(this.getName() + " defiende con " + dañoBloqueado + " puntos de defensa.");
		return dañoBloqueado;
	} // defend

	private static void espera(short ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

} // class
