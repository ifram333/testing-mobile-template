package hooks;

import appium.AppiumServer;
import drivers.AndroidAppDriver;
import extensions.UiAutomator2Extension;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.SkipException;

import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.UUID;

public class AndroidHooks {

	@After( "@Android" )
	public void takeScreenshotIfFailure ( Scenario scenario ) {
		if ( scenario.isFailed( ) ) {
			Allure.addAttachment( "Page screenshot", new ByteArrayInputStream( ( ( TakesScreenshot ) AndroidAppDriver.getDriver( ) ).getScreenshotAs( OutputType.BYTES ) ) );
			Allure.addAttachment( "Step", scenario.getName( ) + " : failed and screenshot taken" );
		}
	}

	@Before( value = "@Skip", order = 0 )
	public void ignore ( ) throws SkipException {
		throw new SkipException( "" );
	}

}
