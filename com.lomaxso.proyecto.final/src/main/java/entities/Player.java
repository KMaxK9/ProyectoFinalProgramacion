package entities;

import java.sql.SQLException;
import java.util.LinkedHashMap;

import enums.Species;
import exceptions.EntityNotExistsExpection;
import inventories.Inventory;
import items.HandItem;
import items.artifacts.Bracelet;
import items.artifacts.Charm;
import items.artifacts.Hand;
import items.artifacts.Head;
import items.artifacts.Neck;
import items.wears.Boots;
import items.wears.Chestplate;
import items.wears.Helmet;
import items.wears.Pants;
import utils.DAO;

public class Player extends Entity {

	private boolean gender;
	private Inventory inventory;
	private Short coins;
	private Helmet equippedHelmet;
	private Chestplate equippedChestplate;
	private Pants equippedPants;
	private Boots equippedBoots;
	private Head equippedHead;
	private Neck equippedNeck;
	private Bracelet equippedBracelet;
	private Hand equippedHand;
	private Charm equippedCharm;
	private HandItem equippedHand1;
	private HandItem equippedHand2;
	
	// Getters and Setters.
	
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public Inventory getInventory() {
		return inventory;
	}
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	public Short getCoins() {
		return coins;
	}
	public void setCoins(Short coins) {
		this.coins = coins;
	}
	public Helmet getEquippedHelmet() {
		return equippedHelmet;
	}
	public void setEquippedHelmet(Helmet equippedHelmet) {
		this.equippedHelmet = equippedHelmet;
	}
	public Chestplate getEquippedChestplate() {
		return equippedChestplate;
	}
	public void setEquippedChestplate(Chestplate equippedChestplate) {
		this.equippedChestplate = equippedChestplate;
	}
	public Pants getEquippedPants() {
		return equippedPants;
	}
	public void setEquippedPants(Pants equippedPants) {
		this.equippedPants = equippedPants;
	}
	public Boots getEquippedBoots() {
		return equippedBoots;
	}
	public void setEquippedBoots(Boots equippedBoots) {
		this.equippedBoots = equippedBoots;
	}
	public Head getEquippedHead() {
		return equippedHead;
	}
	public void setEquippedHead(Head equippedHead) {
		this.equippedHead = equippedHead;
	}
	public Neck getEquippedNeck() {
		return equippedNeck;
	}
	public void setEquippedNeck(Neck equippedNeck) {
		this.equippedNeck = equippedNeck;
	}
	public Bracelet getEquippedBracelet() {
		return equippedBracelet;
	}
	public void setEquippedBracelet(Bracelet equippedBracelet) {
		this.equippedBracelet = equippedBracelet;
	}
	public Hand getEquippedHand() {
		return equippedHand;
	}
	public void setEquippedHand(Hand equippedHand) {
		this.equippedHand = equippedHand;
	}
	public Charm getEquippedCharm() {
		return equippedCharm;
	}
	public void setEquippedCharm(Charm equippedCharm) {
		this.equippedCharm = equippedCharm;
	}
	public HandItem getEquippedHand1() {
		return equippedHand1;
	}
	public void setEquippedHand1(HandItem equippedHand1) {
		this.equippedHand1 = equippedHand1;
	}
	public HandItem getEquippedHand2() {
		return equippedHand2;
	}
	public void setEquippedHand2(HandItem equippedHand2) {
		this.equippedHand2 = equippedHand2;
	}
	
	// Constructors.
	
	public Player(String name, boolean gender, Inventory inventory) throws SQLException, EntityNotExistsExpection {
		super(name);
		this.gender = gender;
		this.inventory = inventory;
		this.coins = 0;
	} // constructor
	
	public Player(String name, Species species, boolean gender) throws SQLException, EntityNotExistsExpection {
		super(name, species);
		this.gender = gender;
		
		LinkedHashMap<String, Object> campos = new LinkedHashMap<String, Object>();
		campos.put("name", name);
		campos.put("species", species.toString());
		campos.put("levels", 1);
		campos.put("life", 50);
		campos.put("damage", 5);
		campos.put("defense", 5);
		DAO.insert("entity", campos);

	} // constructorDB Insert
	
	public Player sendPlayer() {
		return null;
	}

	
	
	
	
	
	
} // class
