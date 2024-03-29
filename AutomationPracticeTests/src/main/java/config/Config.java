package config;

import java.io.InputStream;
import java.util.Properties;

public class Config {
    private final Properties properties;

    private Properties getProperties() {
        Properties prop = new Properties();
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
            prop.load(inputStream);
        } catch (Exception e) {
            throw new RuntimeException("Cannot load properties file: " + e);
        }
        return prop;
    }

    public Config() {
        properties = getProperties();
    }

    public String getApplicationUrl() {
        return properties.getProperty("application.url");
    }

    public String getChromedriverPath() {
        return properties.getProperty("chromedriver.propertyPath");
    }

    public String getChromedriverPropertyName() {
        return properties.getProperty("chromedriver.propertyName");
    }
}
