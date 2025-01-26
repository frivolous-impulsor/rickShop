package test.java;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import main.java.Builder;
import main.java.Instrument;
import main.java.InstrumentSpec;
import main.java.InstrumentType;
import main.java.Property;
import main.java.Wood;

@TestInstance(Lifecycle.PER_CLASS)
class InstrumentTest {
	Map prop;
	InstrumentSpec spec;
	
	@BeforeAll
	void setUp() {
		prop = new HashMap();
		prop.put(Property.BUILDER, Builder.GLORE);
		prop.put(Property.WOOD, Wood.DARK);
		prop.put(Property.INSTYPE, InstrumentType.GUITAR);
		spec = new InstrumentSpec(prop);
	}
	
	

	@Test
	void shouldAcceptNoneNegativeNonNullSpec() {
		String sn = "SKFN03JE";
		double price = 50.99;
		Instrument inst = new Instrument(sn, price, spec);
		assertTrue(inst.getSN().equals(sn));
	}
	
	@Test
	void shouldCatchNegativePrice() {
		String sn = "SKFN03JE";
		double price = -50.99;
		try {
			Instrument inst = new Instrument(sn, price, spec);
			fail("failed to catch");
		}catch (IllegalArgumentException e) {
			
		}

	}
	
	@Test
	void shouldCatchEmptySpec() {
		String sn = "SKFN03JE";
		double price = 50.99;
		Map emptyProp = new HashMap();
		InstrumentSpec emptySpec = new InstrumentSpec(emptyProp);
		try {
			Instrument inst = new Instrument(sn, price, emptySpec);
			fail("failed to catch");
		}catch (IllegalArgumentException e) {
			
		}

	}

}
