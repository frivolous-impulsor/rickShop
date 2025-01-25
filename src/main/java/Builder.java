package main.java;

public enum Builder {
	LUTHER, MARTIN, GLORE;
	
	public String toString() {
		switch(this) {
			case LUTHER: return "Luther";
			case MARTIN: return "Martin";
			case GLORE: return "Glore";
			default: return "Unspecified Builder";
		}
	}
}
