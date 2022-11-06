import appium.AppiumServer;
import com.google.common.collect.ImmutableMap;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import readers.AppiumJsonReader;
import readers.PropertiesReader;

import java.io.IOException;

import static helpers.AllureHelper.allureEnvironmentWriter;

/*
This is the Runner class for failed scenarios, its configuration is similar to the IOS Runner class, the only
difference is that the scenarios are loaded from a rerun.txt file that contains all the scenarios that have failed
in previous runs.
 */
@CucumberOptions(
		features = "@target/rerun.txt",
		glue = { "hooks", "steps" },
		plugin = {
				"pretty",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
				"rerun:target/rerun.txt"
		} )
public class FailedScenariosRunnerTest extends AbstractTestNGCucumberTests {

	@BeforeSuite
	public void setAllureEnvironmentVariables ( ) throws IOException {
		/*
		Get the server index sent in the maven run command.
		 */
		int serverIndex = Integer.parseInt( System.getProperty( "server" ) );

		/*
		Load appium information from appium.json file.
		 */
		AppiumJsonReader.getInstance( );

		/*
		Get the allure results directory
		 */
		String allureResultsDirectory = new PropertiesReader( "pom.properties" ).getProperty( "allure.results.directory" );

		/*
		Create the environment file for the allure report
		 */
		allureEnvironmentWriter(
				ImmutableMap.< String, String >builder( )
						.put( "Device", AppiumJsonReader.getDeviceName( serverIndex ) )
						.put( "OS", AppiumJsonReader.getDeviceOS( serverIndex ) )
						.put( "OS.Version", AppiumJsonReader.getDeviceOSVersion( serverIndex ) )
						.put( "App", AppiumJsonReader.getAppName( serverIndex ) )
						.build( ), allureResultsDirectory );
	}

	@BeforeTest
	public void setUpAppium ( ) {
		/*
		Get the server index sent in the maven run command.
		 */
		int serverIndex = Integer.parseInt( System.getProperty( "server" ) );
		/*
		Start APPIUM Server.
		 */
		AppiumServer.start( serverIndex );
	}

	@AfterTest
	public void tearDownAppium ( ) {
		/*
		Stop APPIUM Server
		 */
		if ( AppiumServer.isRunning( ) ) AppiumServer.stop( );
	}
}
