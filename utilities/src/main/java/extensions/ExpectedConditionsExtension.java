package extensions;

import io.appium.java_client.functions.ExpectedCondition;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;

public class ExpectedConditionsExtension {

	public static ExpectedCondition< RemoteWebElement > elementFoundAfterScrolledDownLocated ( By locator ) {
		return webDriver -> {
			assert webDriver != null;
			XCUITestExtension.scroll( XCUITestExtension.DIRECTION.DOWN );
			return ( RemoteWebElement ) webDriver.findElement( locator );
		};
	}

	public static ExpectedCondition< RemoteWebElement > elementFoundAfterScrolledUpLocated ( By locator ) {
		return webDriver -> {
			assert webDriver != null;
			XCUITestExtension.scroll( XCUITestExtension.DIRECTION.UP );
			RemoteWebElement element = ( RemoteWebElement ) webDriver.findElement( locator );
			return element.isDisplayed( ) ? element : null;
		};
	}

	public static ExpectedCondition< Boolean > elementDisappear ( By locator ) {
		return webDriver -> {
			assert webDriver != null;
			return webDriver.findElements( locator ).isEmpty( );
		};
	}

}
