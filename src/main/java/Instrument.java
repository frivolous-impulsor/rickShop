package main.java;

public class Instrument {
	private String serialNumber;
	private double price;
	private InstrumentSpec spec;
	
	public Instrument(String sn, double p, InstrumentSpec s) {
		if(sn.length() == 0) {
			throw new IllegalArgumentException("Serial number cannot be empty");
		}
		
		this.serialNumber = sn;
		if(p < 0) {
			throw new IllegalArgumentException("price cannot be negative");
		}
		this.price = p;
		
		if(s.isEmptySpec()) {
			throw new IllegalArgumentException("spec cannot be null");
		}
		this.spec = s;
	}
	
	public String getSN() {
		return serialNumber;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double p) {
		price = p;
	}
	
	public InstrumentSpec getSpec() {
		return spec;
	}
	
}
