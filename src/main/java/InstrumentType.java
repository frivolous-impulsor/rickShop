package main.java;

public enum InstrumentType {
	GUITAR, BANJO, BASS;
	
	
	public String toString() {
		switch(this) {
			case GUITAR: return "Guitar";
			case BANJO: return "Banjo";
			case BASS: return "Bass";
			default: return "Unspecified Instrument";
		}
	}
	
}
