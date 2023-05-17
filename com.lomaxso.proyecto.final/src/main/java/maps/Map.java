package maps;

import java.util.ArrayList;

import main.ThingsWithName;

public class Map extends ThingsWithName {

	private ArrayList<MapZone> zones;

	// Getters and Setters.
	
	public ArrayList<MapZone> getZones() {
		return zones;
	}

	public void setZones(ArrayList<MapZone> zones) {
		this.zones = zones;
	}
	
	// Constructor.

	public Map(String name, ArrayList<MapZone> zones) {
		super(name);
		this.zones = zones;
	}
	
	
	
} // class
