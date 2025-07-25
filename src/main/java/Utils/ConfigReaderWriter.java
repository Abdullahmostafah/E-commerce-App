package Utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigReaderWriter {
    private static final Properties properties = new Properties();
    private static final Map<String, String> dynamicValues = new HashMap<>();
    private static final Logger logger = LoggerFactory.getLogger(ConfigReaderWriter.class);

    static {
        try (InputStream input = ConfigReaderWriter.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                logger.error("Unable to find config.properties in src/test/resources");
                throw new IOException("Unable to find config.properties in src/test/resources");
            }
            properties.load(input);
        } catch (IOException e) {
            logger.error("Failed to load config.properties: {}", e.getMessage());
            throw new RuntimeException("Configuration file loading failed", e);
        }
    }

    public static String getPropKey(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            logger.error("Property '{}' not found in config.properties", key);
            throw new RuntimeException("Property '" + key + "' not found in config.properties");
        }
        return value;
    }

    public static void setPropKey(String key, String value) {
        properties.setProperty(key, value);
    }

    public static void setDynamicValue(String key, String value) {
        dynamicValues.put(key, value);
    }

    public static String getDynamicValue(String key) {
        String value = dynamicValues.get(key);
        if (value == null) {
            logger.error("Dynamic value for key '{}' not found", key);
            throw new RuntimeException("Dynamic value for key '" + key + "' not found");
        }
        return value;
    }
}