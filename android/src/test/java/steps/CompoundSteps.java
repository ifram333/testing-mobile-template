package steps;

import io.cucumber.java.en.Given;

import java.io.IOException;

/*
This class contains all the steps that are made up of different actions
 */
public class CompoundSteps extends BaseSteps {

	@Given( "The app loads the {string} page" )
	public void the_app_loads_the_page ( String page ) throws IOException, InterruptedException {
		switch ( page.toUpperCase( ) ) {
			case "LOGIN":
				ProcessBuilder pb1 = new ProcessBuilder( "adb", "shell", "am", "start", "-W", "-a", "android.intent.action.VIEW", "-d", "\"mydemoapprn://login\"", "com.saucelabs.mydemoapp.rn" );
				Process pc1 = pb1.start( );
				pc1.waitFor( );
				System.out.println( "Deeplink Login page" );
				break;
			case "STORE":
				ProcessBuilder pb2 = new ProcessBuilder( "adb", "shell", "am", "start", "-W", "-a", "android.intent.action.VIEW", "-d", "\"mydemoapprn://store-overview\"", "com.saucelabs.mydemoapp.rn" );
				Process pc2 = pb2.start( );
				pc2.waitFor( );
				System.out.println( "Deeplink Store page" );
				break;
			default:
				break;
		}
	}

}
