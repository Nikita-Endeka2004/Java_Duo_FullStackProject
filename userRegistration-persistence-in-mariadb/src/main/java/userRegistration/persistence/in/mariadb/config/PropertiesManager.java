package userRegistration.persistence.in.mariadb.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesManager {

    private static final  String PROPERTY_FILE_NAME = "application.properties";
    private Properties properties;

    public Properties getApplicationProperties() {
        if(properties == null) {
            properties = new Properties();
            try (InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(PROPERTY_FILE_NAME)){
                properties.load(stream);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        return properties;
    }

}
