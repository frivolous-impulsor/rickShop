package test.java;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import main.java.Builder;
import main.java.InstrumentSpec;
import main.java.InstrumentType;
import main.java.Property;
import main.java.Wood;

class InstrumentSpecTest {
	
	@BeforeAll
	static void setUpEach() {
		
	}
	
	@Test
	void testMatchEmptyClient() {
		Map properties = new HashMap();
		InstrumentSpec clientSpec = new InstrumentSpec(properties);
		//String w = clientSpec.getProperty(Property.INSTYPE).toString();
		
		Map prop = new HashMap();
		prop.put(Property.BUILDER, Builder.GLORE);
		prop.put(Property.WOOD, Wood.DARK);
		prop.put(Property.INSTYPE, InstrumentType.GUITAR);
		
		InstrumentSpec invSpec = new InstrumentSpec(prop);
		boolean result = invSpec.matchesToClient(clientSpec);
		assertTrue(result);
	}
	
	@Test
	void testNoMatchEmptyInst() {
		Map properties = new HashMap();
		properties.put(Property.BUILDER, Builder.GLORE);
		properties.put(Property.WOOD, Wood.DARK);
		InstrumentSpec clientSpec = new InstrumentSpec(properties);
		//String w = clientSpec.getProperty(Property.INSTYPE).toString();
		
		Map prop = new HashMap();		
		InstrumentSpec invSpec = new InstrumentSpec(prop);
		
		boolean result = invSpec.matchesToClient(clientSpec);
		assertFalse(result);
	}

	@Test
	void testMatchClientSubsetInst() {
		Map properties = new HashMap();
		properties.put(Property.BUILDER, Builder.GLORE);
		properties.put(Property.WOOD, Wood.DARK);
		InstrumentSpec clientSpec = new InstrumentSpec(properties);
		//String w = clientSpec.getProperty(Property.INSTYPE).toString();
		
		Map prop = new HashMap();
		prop.put(Property.BUILDER, Builder.GLORE);
		prop.put(Property.WOOD, Wood.DARK);
		prop.put(Property.INSTYPE, InstrumentType.GUITAR);
		
		InstrumentSpec invSpec = new InstrumentSpec(prop);
		boolean result = invSpec.matchesToClient(clientSpec);
		assertTrue(result);
	}
	
	@Test
	void testMatchClientEquivInst() {
		Map properties = new HashMap();
		properties.put(Property.BUILDER, Builder.GLORE);
		properties.put(Property.WOOD, Wood.DARK);
		properties.put(Property.INSTYPE, InstrumentType.GUITAR);
		InstrumentSpec clientSpec = new InstrumentSpec(properties);
		//String w = clientSpec.getProperty(Property.INSTYPE).toString();
		
		Map prop = new HashMap();
		prop.put(Property.BUILDER, Builder.GLORE);
		prop.put(Property.WOOD, Wood.DARK);
		prop.put(Property.INSTYPE, InstrumentType.GUITAR);
		
		InstrumentSpec invSpec = new InstrumentSpec(prop);
		boolean result = invSpec.matchesToClient(clientSpec);
		assertTrue(result);
	}
	
	@Test
	void testNoMatchClientSupsetInst() {
		Map properties = new HashMap();
		properties.put(Property.BUILDER, Builder.GLORE);
		properties.put(Property.WOOD, Wood.DARK);
		properties.put(Property.INSTYPE, InstrumentType.GUITAR);
		InstrumentSpec clientSpec = new InstrumentSpec(properties);
		//String w = clientSpec.getProperty(Property.INSTYPE).toString();
		
		Map prop = new HashMap();
		prop.put(Property.WOOD, Wood.DARK);
		prop.put(Property.INSTYPE, InstrumentType.GUITAR);
		InstrumentSpec invSpec = new InstrumentSpec(prop);
		
		boolean result = invSpec.matchesToClient(clientSpec);
		assertFalse(result);
	}

}
