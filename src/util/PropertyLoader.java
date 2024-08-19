package util;

import exceptions.FileException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

    public class PropertyLoader
    {

        private Properties properties;

        public PropertyLoader(String fileName) throws FileException
        {
            properties = new Properties();
            try (FileInputStream input = new FileInputStream(fileName))
            {
                properties.load(input);
            } catch (IOException e)
            {
                throw new FileException("Error loading properties file: " + fileName, e);
            }
        }

        public double getDoubleProperty(String key) throws FileException
        {
            String value = properties.getProperty(key);
            try {
                if (value == null) {
                    throw new FileException("Property key '" + key + "' not found.");
                }
            } catch(FileException e)
            {
                System.err.println(e.getMessage());
                return -1;
            }
            try
            {
                return Double.parseDouble(value);
            } catch (NumberFormatException e)
            {
                throw new FileException("Property value for key '" + key + "' is not a valid double.", e);
            }
        }
    }

