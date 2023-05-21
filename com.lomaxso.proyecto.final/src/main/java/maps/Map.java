package maps;

import java.util.ArrayList;

import enums.MapZoneType;
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

	public Map() {
		super("map");
		this.zones = createMapZones();
	}
	
	public ArrayList<MapZone> createMapZones() {
		ArrayList<MapZone> zones = new ArrayList<MapZone>();
		MapZone hills = new MapZone(MapZoneType.HILLLAND, new ArrayList<MapLevel>());
		MapZone mountain = new MapZone(MapZoneType.MOUNTAIN, new ArrayList<MapLevel>());
		MapZone icePeaks = new MapZone(MapZoneType.ICEPEAKS, new ArrayList<MapLevel>());
		MapZone lavaWorld = new MapZone(MapZoneType.LAVAWORLD, new ArrayList<MapLevel>());
		zones.add(hills);
		zones.add(mountain);
		zones.add(icePeaks);
		zones.add(lavaWorld);
		return zones;
	} // create
	
} // class
