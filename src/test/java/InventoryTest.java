package test.java;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.java.*;

class InventoryTest {
	static String sn;
	static double price;
	static Map props;
	static InstrumentSpec spec;
	static Instrument inst;
	static Inventory inv;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		inv = new Inventory();
		
		
		props = new HashMap();
		props.put(Property.INSTYPE, InstrumentType.GUITAR);
		props.put(Property.BUILDER, Builder.LUTHER);
		sn = "SKFN03JE";
		price = 50.99;
		spec = new InstrumentSpec(props);
		inst = new Instrument(sn, price, spec);
		inv.addInstrument(inst);
		
		
		props = new HashMap();
		props.put(Property.INSTYPE, InstrumentType.GUITAR);
		props.put(Property.BUILDER, Builder.MARTIN);
		props.put(Property.WOOD, Wood.DARK);
		sn = "SOFN03LE";
		price = 65.99;
		spec = new InstrumentSpec(props);
		inst = new Instrument(sn, price, spec);
		inv.addInstrument(inst);
		
		props = new HashMap();
		props.put(Property.INSTYPE, InstrumentType.BANJO);
		props.put(Property.BUILDER, Builder.GLORE);
		props.put(Property.WOOD, Wood.DARK);
		sn = "BOFN03PE";
		price = 82.59;
		spec = new InstrumentSpec(props);
		inst = new Instrument(sn, price, spec);
		inv.addInstrument(inst);
	}

	@Test
	void getInstBySerialNumberTest() {
		String searchSN = "SKFN03JE";
		try {
			Instrument foundInst = inv.get(searchSN);
		}catch (NoSuchElementException e){
			fail("should return a valid insturment with set serial number");
		}

		
	}
	
	@Test
	void getNoInstBySerialNumberTest() {
		String searchSN = "FAKESN";
		try {
			Instrument foundInst = inv.get(searchSN);
			fail("should NOT return a valid insturment with set serial number");
		}catch (NoSuchElementException e){
			
		}

		
	}
	
	@Test
	void searchSomeResultTest() {
		LinkedList<Instrument> result = new LinkedList<Instrument>();
		Map searchProp = new HashMap();
		searchProp.put(Property.INSTYPE, InstrumentType.GUITAR);
		InstrumentSpec searchSpec = new InstrumentSpec(searchProp);
		result = inv.search(searchSpec);
		assertFalse(result.isEmpty());
	}
	
	@Test
	void searchNoResultTest() {
		LinkedList<Instrument> result = new LinkedList<Instrument>();
		Map searchProp = new HashMap();
		searchProp.put(Property.WOOD, Wood.PLAIN);
		InstrumentSpec searchSpec = new InstrumentSpec(searchProp);
		try {
			result = inv.search(searchSpec);
			fail("fail to throw exception when search result is empty");
		}catch (NoSuchElementException e) {
			
		}
		
	}

}
