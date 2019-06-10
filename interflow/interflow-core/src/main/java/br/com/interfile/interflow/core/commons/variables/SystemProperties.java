package br.com.interfile.interflow.core.commons.variables;

import java.util.Properties;

public class SystemProperties {

	private Properties properties = new Properties();
	
    public Object getField(String field) {
        return properties.get(field);
    }
	
    public void addField(String field, Object object) {
        properties.put(field, object);
    }
	
	
}
