package helpers;

import com.google.common.collect.ImmutableMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class AllureHelper {

	private static final Logger logger = LogManager.getLogger( );

	/*
	Function to create the environment file
	 */
	public static void allureEnvironmentWriter ( ImmutableMap< String, String > environmentValuesSet, String customResultsPath ) {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance( );
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder( );
			Document doc = docBuilder.newDocument( );
			Element environment = doc.createElement( "environment" );
			doc.appendChild( environment );
			environmentValuesSet.forEach( ( k, v ) -> {
				Element parameter = doc.createElement( "parameter" );
				Element key = doc.createElement( "key" );
				Element value = doc.createElement( "value" );
				key.appendChild( doc.createTextNode( k ) );
				value.appendChild( doc.createTextNode( v ) );
				parameter.appendChild( key );
				parameter.appendChild( value );
				environment.appendChild( parameter );
			} );
			TransformerFactory transformerFactory = TransformerFactory.newInstance( );
			Transformer transformer = transformerFactory.newTransformer( );
			DOMSource source = new DOMSource( doc );

			StreamResult result;

			if ( customResultsPath.isBlank( ) || customResultsPath == null ) {
				File allureResultsDir = new File( System.getProperty( "user.dir" ) + "/target/allure-results" );
				if ( !allureResultsDir.exists( ) ) {
					allureResultsDir.mkdirs( );
				}

				result = new StreamResult( new File( System.getProperty( "user.dir" ) + "/target/allure-results/environment.xml" ) );
			} else {
				File allureResultsDir = new File( customResultsPath );
				if ( !allureResultsDir.exists( ) ) {
					allureResultsDir.mkdirs( );
				}

				result = new StreamResult( new File( customResultsPath + "/environment.xml" ) );
			}

			transformer.transform( source, result );
			logger.info( "Allure environment data saved." );
		} catch ( ParserConfigurationException | TransformerException e ) {
			e.printStackTrace( );
		}
	}

	public static void allureEnvironmentWriter ( ImmutableMap< String, String > environmentValuesSet ) {
		allureEnvironmentWriter( environmentValuesSet, null );
	}
}
