package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private static ConfigFileReader conf = null;
    public Properties prop;
    public FileInputStream file;

    public ConfigFileReader() throws IOException {
        prop = new Properties();
        file = new FileInputStream("src/main/resources/Configs/Config.properties");
        prop.load(file);
        file.close();
    }

    public static ConfigFileReader ConfigReturn() throws IOException {
        return new ConfigFileReader();
    }

    public String get(String key) {
        return prop.getProperty(key);
    }
}
