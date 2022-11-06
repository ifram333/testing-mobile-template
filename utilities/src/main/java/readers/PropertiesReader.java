package readers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

	private final Properties properties;

	public PropertiesReader ( String propertyFileName ) throws IOException {
		InputStream is = getClass( ).getClassLoader( ).getResourceAsStream( propertyFileName );
		properties = new Properties( );
		properties.load( is );
	}

	public String getProperty ( String propertyName ) {
		return properties.getProperty( propertyName ).trim( );
	}

}
