package main;

public abstract class ThingsWithName {

	private String name;

	// Getters and Setters.

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// Constructors.
	public ThingsWithName(String name) {
		super();
		this.name = name;
	}

	public ThingsWithName() {
	}

} // class
