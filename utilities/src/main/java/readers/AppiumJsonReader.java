package readers;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/*
This class allows reading the appium.json file to be able to access the configuration values, servers, apps and capabilities
 */
public class AppiumJsonReader {

	private static final Object lock = new Object( );
	private static final List< HashMap< String, Object > > servers = new ArrayList<>( );
	private static volatile AppiumJsonReader instance;
	private static HashMap< String, Object > configs = new HashMap<>( );
	private static HashMap< String, Object > apps = new HashMap<>( );
	private static HashMap< String, Object > capabilities = new HashMap<>( );

	public static void getInstance ( ) {
		if ( instance == null ) {
			synchronized ( lock ) {
				if ( instance == null ) {
					instance = new AppiumJsonReader( );
					instance.loadAppiumJson( );
				}
			}
		}
	}

	@SuppressWarnings( "unchecked" )
	public static String getAndroidSDKPath ( int index ) {
		HashMap< String, String > config = ( HashMap< String, String > ) configs.get( getConfig( index ) );
		return config.get( "android" );
	}

	@SuppressWarnings( "unchecked" )
	public static String getJavaHomePath ( int index ) {
		HashMap< String, String > config = ( HashMap< String, String > ) configs.get( getConfig( index ) );
		return config.get( "java" );
	}

	@SuppressWarnings( "unchecked" )
	public static String getNodePath ( int index ) {
		HashMap< String, String > config = ( HashMap< String, String > ) configs.get( getConfig( index ) );
		return config.get( "node" );
	}

	@SuppressWarnings( "unchecked" )
	public static String getExecutablePath ( int index ) {
		HashMap< String, String > config = ( HashMap< String, String > ) configs.get( getConfig( index ) );
		return config.get( "executable" );
	}

	@SuppressWarnings( "unchecked" )
	public static String getLogPath ( int index ) {
		HashMap< String, String > config = ( HashMap< String, String > ) configs.get( getConfig( index ) );
		return config.get( "log" );
	}

	public static String getConfig ( int index ) {
		return servers.get( index ).get( "config" ).toString( );
	}

	public static String getIP ( int index ) {
		return servers.get( index ).get( "ip" ).toString( );
	}

	public static int getPort ( int index ) {
		return ( ( int ) servers.get( index ).get( "port" ) );
	}

	public static String getDevice ( int index ) {
		return servers.get( index ).get( "device" ).toString( );
	}

	public static String getApp ( int index ) {
		return servers.get( index ).get( "app" ).toString( );
	}

	public static String getAppName ( int index ) {
		return apps.get( getApp( index ) ).toString( );
	}

	@SuppressWarnings( "unchecked" )
	public static HashMap< String, String > capabilities ( int index ) {
		return ( HashMap< String, String > ) capabilities.get( getDevice( index ) );
	}

	/*
	Function to load the appium.json file
	 */
	private void loadAppiumJson ( ) {
		/*
		Read the appium.json file as an InputStreamReader which returns a string, and then convert it to a JSON type object
		 */
		String jsonString = new BufferedReader( new InputStreamReader( Objects.requireNonNull( this.getClass( ).getClassLoader( ).getResourceAsStream( "appium.json" ) ), StandardCharsets.UTF_8 ) ).lines( ).collect( Collectors.joining( "\n" ) );
		JSONObject appiumJson = new JSONObject( jsonString );

		/*
		Get the config depending on the -Dconfig value
		 */
		configs = ( HashMap< String, Object > ) appiumJson.getJSONObject( "configs" ).toMap( );

		/*
		Get the list of apps
		 */
		apps = ( HashMap< String, Object > ) appiumJson.getJSONObject( "apps" ).toMap( );

		/*
		Get the list of servers
		 */
		JSONArray serversArray = appiumJson.getJSONArray( "servers" );
		for ( int i = 0; i < serversArray.length( ); i++ ) {
			servers.add( ( HashMap< String, Object > ) serversArray.getJSONObject( i ).toMap( ) );
		}

		/*
		Get the list of capabilities
		 */
		capabilities = ( HashMap< String, Object > ) appiumJson.getJSONObject( "capabilities" ).toMap( );
	}

}
