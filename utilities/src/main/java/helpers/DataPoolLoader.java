package helpers;

import org.aeonbits.owner.ConfigFactory;
import readers.DataPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DataPoolLoader {

	private static final ThreadLocal< DataPoolConfig > dataPoolConfigThreadLocal = new ThreadLocal<>( );

	public static void loadData ( String user ) throws IOException {
		Properties userProperties = new Properties( );
		InputStream is = DataPoolLoader.class.getClassLoader( ).getResourceAsStream( "datapool/" + user );
		userProperties.load( is );

		dataPoolConfigThreadLocal.set( ConfigFactory.create( DataPoolConfig.class, userProperties ) );
	}

	public static DataPoolConfig get ( ) {
		return dataPoolConfigThreadLocal.get( );
	}

}
