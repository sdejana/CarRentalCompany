package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

    public class PropertyLoader
    {

        private Properties properties;

        public PropertyLoader(String fileName)
        {
            properties = new Properties();
            try (FileInputStream input = new FileInputStream(fileName))
            {
                properties.load(input);
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        public double getDoubleProperty(String key)
        {
            return Double.parseDouble(properties.getProperty(key));
        }
    }

