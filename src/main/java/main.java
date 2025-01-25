package main.java;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class main {
	public static void main(String[] args) {
		Map properties = new HashMap();
		properties.put(Property.BUILDER, Builder.GLORE);
		properties.put(Property.WOOD, Wood.DARK);
		InstrumentSpec clientSpec = new InstrumentSpec(properties);
		//String w = clientSpec.getProperty(Property.INSTYPE).toString();
		
		Map prop = new HashMap();
		prop.put(Property.BUILDER, Builder.GLORE);
		prop.put(Property.WOOD, Wood.PLAIN);
		prop.put(Property.INSTYPE, InstrumentType.GUITAR);
		
		InstrumentSpec invSpec = new InstrumentSpec(prop);
		invSpec.matches(clientSpec);
		
		
		//System.out.println(w);
		
	}
}
