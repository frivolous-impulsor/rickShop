package main.java;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class InstrumentSpec {
	private Map properties;
	
	public InstrumentSpec(Map props) {
		if (props.isEmpty()) {
			//System.out.println("empty hashmap added to instrumentSpec");
			this.properties = new HashMap();
		}else {
			//System.out.println("non-empty hashmap added to instrumentSpec");
			this.properties = new HashMap(props);
		}
	}
	
	public boolean isEmptySpec() {
		return properties.isEmpty();
	}
	
	//getting the value of property from the name of the property
	//since value can be instances of various kinds of enums, we use Object here
	public Object getProperty(Property p) {
		return properties.get(p);
	}
	
	public Map getProperties() {
		return properties;
	}
	
	public boolean matches(InstrumentSpec otherSpec) {
		for (Iterator i = otherSpec.getProperties().keySet().iterator(); i.hasNext();) {
			Property p = (Property) i.next();
			if(otherSpec.getProperty(p) != this.getProperty(p)) {
				System.out.println("property " + p + " not fit");
				return false;
			}else {
				System.out.println("property " + p + " fit");
			}
			
		}
		return true;
	}
}
