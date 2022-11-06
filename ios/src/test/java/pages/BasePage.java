package pages;

import drivers.IOSAppDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebElement;

/*
This is the base class that all pages extend from.
 */
public class BasePage extends Page {

	/*
	Get an instance of the Android driver
	 */
	protected final IOSDriver driver = IOSAppDriver.iosDriver;

	/*
	Get an instance of the logger
	 */
	private final Logger logger = LogManager.getLogger( );

	/*
	Element to close keyboard
	 */
	@iOSXCUITFindBy( accessibility = "Return" )
	protected RemoteWebElement returnButton;

}
