
package com.saucelab.property.in;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configprop {

    Properties prop;

    public Configprop() throws IOException {
        prop = new Properties();

        try (InputStream fis = getClass().getClassLoader()
                .getResourceAsStream("saucelab/property/in/config.properties")) {

            if (fis == null) {
                throw new IOException("config.properties file not found in classpath");
            }

            prop.load(fis);
        }
    }

    public String getUrl() {
        return prop.getProperty("url");
    }
}
