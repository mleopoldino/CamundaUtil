package br.com.interfile.interflow.core.commons.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InterflowPropertiesUtil {

	final private String configFile = "interflow.properties";

    final private Properties prop = new Properties();
    
	final private Logger LOGGER = LogManager.getLogger(InterflowPropertiesUtil.class);
    
	//===============================================================================
	
    public InterflowPropertiesUtil() {
	
        InputStream input = null;
        try {
        	String props = InterflowUtil.getConfigPath() + configFile;
//        	System.out.println("PROPS: " + props);
        	
            input = new FileInputStream(props);
            
            // load a properties file
            prop.load(input);

        } catch (Exception ex) {
            LOGGER.error(ex);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (Exception e) {
                    LOGGER.error(e);
                }
            }
        }
    }

    public String getProperty(String key) {
        return prop.getProperty(key);
    }

	//===============================================================================

    public String getHost() {
        return getProperty("mail_host");
    }

    public String getMailSubject() {
        return getProperty("mail_subject");
    }
}
