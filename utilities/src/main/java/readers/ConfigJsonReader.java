package readers;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Objects;
import java.util.stream.Collectors;

/*
This class allows reading the config.json file to be able to access the configuration values, servers, apps and capabilities
 */
public class ConfigJsonReader {

	private static final Object lock = new Object( );
	private static volatile ConfigJsonReader instance;
	private static HashMap< String, Object > configs = new HashMap<>( );
	private static HashMap< String, Object > capabilities = new HashMap<>( );

	public static void getInstance ( ) {
		if ( instance == null ) {
			synchronized ( lock ) {
				if ( instance == null ) {
					instance = new ConfigJsonReader( );
					instance.loadConfigJson( );
				}
			}
		}
	}

	@SuppressWarnings( "unchecked" )
	public static String getAndroidSDKPath ( String configName ) {
		HashMap< String, String > config = ( HashMap< String, String > ) configs.get( configName );
		return config.get( "android" );
	}

	@SuppressWarnings( "unchecked" )
	public static String getJavaHomePath ( String configName ) {
		HashMap< String, String > config = ( HashMap< String, String > ) configs.get( configName );
		return config.get( "java" );
	}

	@SuppressWarnings( "unchecked" )
	public static String getNodePath ( String configName ) {
		HashMap< String, String > config = ( HashMap< String, String > ) configs.get( configName );
		return config.get( "node" );
	}

	@SuppressWarnings( "unchecked" )
	public static String getExecutablePath ( String configName ) {
		HashMap< String, String > config = ( HashMap< String, String > ) configs.get( configName );
		return config.get( "executable" );
	}

	@SuppressWarnings( "unchecked" )
	public static String getIOSDeploy ( String configName ) {
		HashMap< String, String > config = ( HashMap< String, String > ) configs.get( configName );
		return config.get( "ios-deploy" );
	}

	@SuppressWarnings( "unchecked" )
	public static String getLogPath ( String configName ) {
		HashMap< String, String > config = ( HashMap< String, String > ) configs.get( configName );
		return config.get( "log" );
	}

	@SuppressWarnings( "unchecked" )
	public static HashMap< String, String > getCapabilities ( String device ) {
		return ( HashMap< String, String > ) capabilities.get( device );
	}

	/*
	Function to load the config.json file
	 */
	private void loadConfigJson ( ) {
		/*
		Read the config.json file as an InputStreamReader which returns a string, and then convert it to a JSON type object
		 */
		String jsonString = new BufferedReader( new InputStreamReader( Objects.requireNonNull( this.getClass( ).getClassLoader( ).getResourceAsStream( "config.json" ) ), StandardCharsets.UTF_8 ) ).lines( ).collect( Collectors.joining( "\n" ) );
		JSONObject appiumJson = new JSONObject( jsonString );

		/*
		Get the list of configs
		 */
		configs = ( HashMap< String, Object > ) appiumJson.getJSONObject( "configs" ).toMap( );

		/*
		Get the list of capabilities
		 */
		capabilities = ( HashMap< String, Object > ) appiumJson.getJSONObject( "capabilities" ).toMap( );
	}

}
