package main.java;
import java.util.NoSuchElementException;
import java.util.Iterator;
import java.util.LinkedList;

public class Inventory {
	LinkedList<Instrument> instruments;
	
	public Inventory() {
		this.instruments = new LinkedList<Instrument>();
	}
	
	public void addInstrument(Instrument newInst) {
		instruments.add(newInst);
	}
	
	public Instrument get(String sn) throws NoSuchElementException {
		for(Iterator i = instruments.iterator(); i.hasNext();) {
			Instrument ins = (Instrument)i.next();
			if (ins.getSN().equals(sn)){
				return ins;
			}
		}
		throw new NoSuchElementException("No instrument with serial number " + sn + " found in inventory");
	}
	
	public LinkedList<Instrument> search(InstrumentSpec searchSpec) throws NoSuchElementException{
		LinkedList<Instrument> result = new LinkedList<Instrument>();
		for(Iterator i = instruments.iterator(); i.hasNext();) {
			Instrument ins = (Instrument)i.next();
			if (ins.getSpec().matchesToClient(searchSpec)) {
				result.add(ins);
			}
		}
		if(result.isEmpty()) {
			throw new NoSuchElementException("no instrument in the shop matches client's specifications");
		}
		return result;
		
	}

}
