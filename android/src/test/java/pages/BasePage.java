package pages;

import drivers.AndroidAppDriver;
import extensions.UiAutomator2Extension;
import io.appium.java_client.android.AndroidDriver;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebElement;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.testng.Assert.fail;

/*
This is the base class that all pages extend from.
 */
public class BasePage extends Page {

	/*
	Get an instance of the Android driver
	 */
	protected final AndroidDriver driver = AndroidAppDriver.androidDriver;

	/*
	UiSelectors locators scrollable
	 */
	protected final String scrollId = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().resourceId(\"";
	protected final String scrollIdMatches = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().resourceIdMatches(\"(?i)";

	protected final String scrollText = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"";
	protected final String scrollTextContains = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"";
	protected final String scrollTextMatches = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textMatches(\"(?i)";
	protected final String scrollTextStartsWith = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textStartsWith(\"";

	protected final String scrollDescription = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().description(\"";
	protected final String scrollDescriptionContains = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().descriptionContains(\"";
	protected final String scrollDescriptionMatches = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().descriptionMatches(\"(?i)";
	protected final String scrollDescriptionStartsWith = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().descriptionStartsWith(\"";

	protected final String scrollClass = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().className(\"";
	protected final String scrollClassMatches = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().classNameMatches(\"(?i)";

	protected final String scrollWrapper = "\"))";

	/*
	UiSelectors locators non scrollable
	 */
	protected final String noScrollId = "new UiSelector().resourceId(\"";
	protected final String noScrollIdMatches = "new UiSelector().resourceIdMatches(\"(?i)";

	protected final String noScrollText = "new UiSelector().text(\"";
	protected final String noScrollTextContains = "new UiSelector().textContains(\"";
	protected final String noScrollTextMatches = "new UiSelector().textMatches(\"(?i)";
	protected final String noScrollTextStartsWith = "new UiSelector().textStartsWith(\"";

	protected final String noScrollDescription = "new UiSelector().description(\"";
	protected final String noScrollDescriptionContains = "new UiSelector().descriptionContains(\"";
	protected final String noScrollDescriptionMatches = "new UiSelector().descriptionMatches(\"(?i)";
	protected final String noScrollDescriptionStartsWith = "new UiSelector().descriptionStartsWith(\"";

	protected final String noScrollClass = "new UiSelector().className(\"";
	protected final String noScrollClassMatches = "new UiSelector().classNameMatches(\"(?i)";

	protected final String noScrollWrapper = "\")";

	/*
	Get an instance of the logger
	 */
	private final Logger logger = LogManager.getLogger( );

	/*
	Functions to get element
	 */
	protected RemoteWebElement scrollTo ( By locator ) {
		return UiAutomator2Extension.scrollTo( locator );
	}

	/*
	Function to get string from image
	 */
	protected String getStringFromImageView ( RemoteWebElement element ) {
		try {
			Tesseract tesseract = new Tesseract( );

			String ocrImagesFolder = Files.createDirectories( Paths.get( "target/ocrImages" ) ).toFile( ).getAbsolutePath( );
			File documentImage = element.getScreenshotAs( OutputType.FILE );
			File targetImage = new File( ocrImagesFolder + "/image.png" );

			FileUtils.copyFile( documentImage, targetImage );

			tesseract.setDatapath( LoadLibs.extractTessResources( "tessdata" ).getAbsolutePath( ) );
			return tesseract.doOCR( targetImage );
		} catch ( IOException e ) {
			fail( "There was an error taking screenshot of the element" );
		} catch ( TesseractException e ) {
			fail( "There was an error reading the image" );
		}
		return null;
	}

}
