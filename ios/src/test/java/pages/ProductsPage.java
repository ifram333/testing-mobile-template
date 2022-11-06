package pages;

import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebElement;

import static org.testng.Assert.assertTrue;

public class ProductsPage extends BasePage {

	private final Logger logger = LogManager.getLogger( );

	@iOSXCUITFindBy( xpath = "//XCUIElementTypeStaticText[@name=\"PRODUCTOS\"]" )
	private RemoteWebElement productsLabel;

	public void validateProductsLabel ( ) {
		assertTrue( productsLabel.isDisplayed( ), "The 'PRODUCTS' label is not displayed" );
		logger.info( "The 'PRODUCTS' label is displayed" );
	}

}
