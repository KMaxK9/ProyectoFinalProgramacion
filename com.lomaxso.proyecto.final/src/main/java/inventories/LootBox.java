package inventories;

import java.util.ArrayList;

import items.Item;
import main.ThingsWithName;

public class LootBox extends ThingsWithName {

	private ArrayList<Item> items;
	private byte price;
	
	// Getters and Setters.
	
	public ArrayList<Item> getItems() {
		return items;
	}
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	public byte getPrice() {
		return price;
	}
	public void setPrice(byte price) {
		this.price = price;
	}
	
	// Constructor.
	
	public LootBox(String name, ArrayList<Item> items, byte price) {
		super(name);
		this.items = items;
		this.price = price;
	}	
	
	
	
} // class
