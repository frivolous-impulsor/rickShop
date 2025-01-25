package main.java;

public enum Property {
	BUILDER, WOOD, INSTYPE;
	
	public String toString() {
		switch(this) {
		case BUILDER: return "Builder";
		case WOOD: return "Wood";
		case INSTYPE: return "Instrument type";
		default: return "unspecified property";
		}
	}
}
