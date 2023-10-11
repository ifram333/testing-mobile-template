package extensions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/*
This class extends the basic functionalities of Appium, allowing to have new actions
 */
public class XCUITestExtension {

	private static IOSDriver driver;
	private static WebDriverWait wait;

	public static void setDriver ( IOSDriver iosDriver ) {
		driver = iosDriver;
		wait = new WebDriverWait( driver, Duration.ofSeconds( 30 ) );
	}

	/*
	Function to swipe an element to any direction. If the element is null, the full screen of the device will be swiped.
	 */
	public static void swipe ( DIRECTION direction, RemoteWebElement element ) {
		Map< String, Object > params = new HashMap<>( );

		switch ( direction ) {
			case UP:
				params.put( "direction", "up" );
				break;
			case DOWN:
				params.put( "direction", "down" );
				break;
			case LEFT:
				params.put( "direction", "left" );
				break;
			case RIGHT:
				params.put( "direction", "right" );
				break;
		}

		params.put( "velocity", "1100" );

		if ( element != null ) {
			params.put( "element", element.getId( ) );
		}

		driver.executeScript( "mobile: swipe", params );
	}

	public static void swipe ( DIRECTION direction ) {
		swipe( direction, null );
	}

	/*
	Function to scroll an element in any direction. In case the element is null, the full screen of the device is scrolled
	 */
	public static void scroll ( DIRECTION direction, RemoteWebElement element ) {
		Map< String, Object > params = new HashMap<>( );

		switch ( direction ) {
			case UP:
				params.put( "direction", "up" );
				break;
			case DOWN:
				params.put( "direction", "down" );
				break;
			case LEFT:
				params.put( "direction", "left" );
				break;
			case RIGHT:
				params.put( "direction", "right" );
				break;
		}

		if ( element != null ) {
			params.put( "element", element.getId( ) );
		}

		driver.executeScript( "mobile: scroll", params );
	}

	public static void scroll ( DIRECTION direction ) {
		scroll( direction, null );
	}

	/*
	Function to scroll to an element.
	*/
	public static RemoteWebElement scrollTo ( By locator, int maxScrolls ) {
		int counter = 0;
		boolean nextScroll = true;
		Map< String, Object > params = new HashMap<>( );
		RemoteWebElement element = ( RemoteWebElement ) wait.until( ExpectedConditions.presenceOfElementLocated( locator ) );

		do {
			if ( element.isDisplayed( ) ) {
				nextScroll = false;
				break;
			} else {
				params.put( "direction", "up" );
				params.put( "velocity", 1000 );
				driver.executeScript( "mobile: swipe", params );
			}
			counter++;
		} while ( counter < maxScrolls );

		if ( nextScroll ) {
			do {
				if ( element.isDisplayed( ) ) {
					break;
				} else {
					params.put( "direction", "down" );
					params.put( "velocity", 1000 );
					driver.executeScript( "mobile: swipe", params );
				}
				counter--;
			} while ( counter > 0 );
		}

		return element;
	}

	public static RemoteWebElement scrollTo ( By locator ) {
		return scrollTo( locator, 5 );
	}

	public static void scrollTo ( RemoteWebElement element, int maxScrolls ) {
		int counter = 0;
		boolean nextScroll = true;
		Map< String, Object > params = new HashMap<>( );

		do {
			if ( element.isDisplayed( ) ) {
				nextScroll = false;
				break;
			} else {
				params.put( "direction", "up" );
				params.put( "velocity", 1000 );
				driver.executeScript( "mobile: swipe", params );
			}
			counter++;
		} while ( counter < maxScrolls );

		if ( nextScroll ) {
			do {
				if ( element.isDisplayed( ) ) {
					break;
				} else {
					params.put( "direction", "down" );
					params.put( "velocity", 1000 );
					driver.executeScript( "mobile: swipe", params );
				}
				counter--;
			} while ( counter > 0 );
		}
	}

	public static void scrollTo ( RemoteWebElement element ) {
		scrollTo( element, 5 );
	}

	public static RemoteWebElement scrollDownUntilPresenceOfElement ( By locator ) {
		return wait.until( ExpectedConditionsExtension.elementFoundAfterScrolledDownLocated( locator ) );
	}

	public static RemoteWebElement scrollUpUntilVisibilityOfElement ( By locator ) {
		return wait.until( ExpectedConditionsExtension.elementFoundAfterScrolledUpLocated( locator ) );
	}

	public static boolean elementIsVisible ( RemoteWebElement element ) {
		return wait.until( ExpectedConditions.visibilityOf( element ) ).isDisplayed( );
	}

	public static RemoteWebElement noScroll ( By locator ) {
		return wait.until( webDriver -> ( RemoteWebElement ) webDriver.findElement( locator ) );
	}

	public static void waitForElementToDisappear ( By locator ) {
		wait.until( ExpectedConditionsExtension.elementDisappear( locator ) );
	}

	public static void waitForElementToBeClickable ( RemoteWebElement element ) {
		wait.until( ExpectedConditions.elementToBeClickable( element ) );
	}

	public enum DIRECTION {
		UP,
		DOWN,
		LEFT,
		RIGHT
	}

}
