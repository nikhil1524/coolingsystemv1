package com.yeshtech.coolingsystem.util;

import java.util.Enumeration;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;

public class PropertiesLoader {

	private String propertyFileName;
	private ResourceBundle bundle;
	
	public static PropertiesLoader getPropertiesLoader(String propertyfileName) {
		return new PropertiesLoader(propertyfileName);
	}

	public static PropertiesLoader getPropertiesLoader(String propertyfileName,
			Locale locale) {
		return new PropertiesLoader(propertyfileName, locale);
	}

	public PropertiesLoader(String propertyFileName) {
		this.propertyFileName = propertyFileName;
		loadProperties();
	}

	public PropertiesLoader(String propertyFileName, Locale locale) {
		this.propertyFileName = propertyFileName;
		loadProperties(locale);
	}

	private void loadProperties() throws MissingResourceException {
		this.bundle = ResourceBundle.getBundle(this.propertyFileName);
	}

	private void loadProperties(Locale locale) throws MissingResourceException {
		this.bundle = ResourceBundle.getBundle(this.propertyFileName, locale);
	}

	public String getValue(String propertyName)
			throws MissingResourceException, ClassCastException {
		return this.bundle.getString(propertyName);
	}

	public Enumeration<?> getKeys() {
		return this.bundle.getKeys();
	}

	public Properties getPropertiesObject() {
		Properties prop = new Properties();
		Enumeration<?> en = getKeys();
		while (en.hasMoreElements()) {
			String name = (String) en.nextElement();
			prop.put(name, getValue(name));
		}
		return prop;
	}

}
