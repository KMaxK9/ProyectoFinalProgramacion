package maps;

import java.util.ArrayList;
import enums.MapZoneType;

public class MapZone {

	private MapZoneType zoneType;
	private ArrayList<MapLevel> level;
	
	// Getters and Setters.
	
	public MapZoneType getZoneType() {
		return zoneType;
	}
	public void setZoneType(MapZoneType zoneType) {
		this.zoneType = zoneType;
	}
	public ArrayList<MapLevel> getLevel() {
		return level;
	}
	public void setLevel(ArrayList<MapLevel> level) {
		this.level = level;
	}
	
	// Constructor.
	
	public MapZone(MapZoneType zoneType, ArrayList<MapLevel> level) {
		super();
		this.zoneType = zoneType;
		this.level = level;
	}
	
	
	
} // class
