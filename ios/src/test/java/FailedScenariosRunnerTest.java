import appium.AppiumServer;
import com.google.common.collect.ImmutableMap;
import drivers.IOSAppDriver;
import extensions.XCUITestExtension;
import helpers.DataPoolLoader;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.*;
import readers.ConfigJsonReader;
import readers.PropertiesReader;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;

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

	private String path = "";

	@BeforeTest
	@Parameters( { "allure-folder", "data-pool" } )
	public void setUpAppium ( String allureFolder, String dataPool ) throws IOException {
		/*
		Get the allure results directory
		 */
		path = new PropertiesReader( "pom.properties" ).getProperty( "allure.results.directory" );
		String allureResultsDirectory = path + "/" + allureFolder;

		/*
		Set the allure results directory depending on the device
		 */
		System.setProperty( "allure.results.directory", allureResultsDirectory );

		/*
		Initializing the data pool loader with the properties file set in the xml parameters
		 */
		DataPoolLoader.loadData( dataPool );
	}

	@AfterTest
	@Parameters( { "allure-folder", "device-name", "device-os", "device-os-version", "app-name" } )
	public void tearDownAppium ( String allureFolder, String deviceName, String deviceOS, String deviceOSVersion, String appName ) {
		/*
		Move all files to its corresponding results folder
		 */
		File dir = new File( path + "/" + allureFolder );
		File resultDir = new File( path + "/" + deviceOS + "_" + deviceOSVersion );

		try {
			for ( File file :
					Objects.requireNonNull( dir.listFiles( ) ) ) {
				FileUtils.moveFileToDirectory( file, resultDir, true );
			}

			FileUtils.deleteDirectory( dir );
		} catch ( IOException e ) {
			System.out.println( "It was impossible to create results folder..." );
			e.printStackTrace( );
		}

		/*
		Create the environment file for the allure report
		 */
		allureEnvironmentWriter(
				ImmutableMap.< String, String >builder( )
						.put( "Device", deviceName )
						.put( "OS", deviceOS )
						.put( "OS.Version", deviceOSVersion )
						.put( "App", appName )
						.build( ), resultDir.getAbsolutePath( ) );
	}

	@BeforeMethod
	@Parameters( { "device", "app-name" } )
	public void setUpDriver ( String device, String appName ) throws MalformedURLException, URISyntaxException {
		/*
		Load the path to the .app file.
		 */
		File app = new File( Objects.requireNonNull( this.getClass( ).getResource( "apps/" + appName ) ).toURI( ) );

		/*
		Validate the app is in the resources/apps folder.
		 */
		if ( !app.exists( ) ) {
			System.out.println( app.getName( ) + " not found in the 'resource/apps' folder..." );
			return;
		}

		/*
		Load the capabilities required to run the execution.
		 */
		XCUITestOptions xcuiTestOptions = new XCUITestOptions( ConfigJsonReader.getCapabilities( device ) );
		xcuiTestOptions.setApp( app.getAbsolutePath( ) );

		/*
		Start iOS Driver.
		 */
		IOSAppDriver.startDriver( new IOSDriver( new URL( AppiumServer.getURL( ) ), xcuiTestOptions ) );

		/*
		Set Up Extensions.
		 */
		XCUITestExtension.setDriver( IOSAppDriver.getDriver( ) );
	}

	@AfterMethod
	public synchronized void tearDownDriver ( ) {
		/*
		Stop iOS Driver.
		 */
		IOSAppDriver.getDriver( ).quit( );
	}

}
