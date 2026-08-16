package com.saucelab.property.in;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configprop {
	Properties prop;
	
	public Configprop() throws IOException {
		FileInputStream fis = new FileInputStream("D:\\JeevitaS\\saucelab\\src\\test\\resource\\com\\saucelab\\property\\in\\config.properties");
	prop = new Properties();
	prop.load(fis);
	}
	
	public String getUrl() {
		return prop.getProperty("url");
	}

}
