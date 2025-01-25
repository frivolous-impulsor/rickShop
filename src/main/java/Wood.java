package main.java;

public enum Wood {
	DARK, PLAIN;
	
	public String toString() {
		switch(this) {
			case DARK: return "Dark";
			case PLAIN: return "Plain";
			default: return "Unspecified Wood";
		}
	}
}
