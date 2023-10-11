package pages;

import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;
import java.util.Collections;
import java.util.Objects;

/*
This is the base class that all pages extend from.
 */
public class BasePage {

	protected final AndroidDriver driver;

	/*
	UiSelectors locators scrollable
	 */
	protected final String scrollId = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().resourceId(\"";
	protected final String scrollIdMatches = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().resourceIdMatches(\"(?i).*";

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
	protected final String noScrollIdMatches = "new UiSelector().resourceIdMatches(\"(?i).*";

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

	protected final Logger logger = LogManager.getLogger( this.getClass( ) );
	protected final SoftAssertions softly = new SoftAssertions( );

	public BasePage ( AndroidDriver driver ) {
		this.driver = driver;
	}

	protected void clickValueAutoCompleteTextView ( RemoteWebElement autoCompleteTextView, String value ) {
		autoCompleteTextView.click( );
		autoCompleteTextView.clear( );
		autoCompleteTextView.sendKeys( value );

		Rectangle autoCompleteTextViewRectangle = autoCompleteTextView.getRect( );
		PointerInput FINGER = new PointerInput( PointerInput.Kind.TOUCH, "finger" );

		Sequence action;

		action = new Sequence( FINGER, 1 )
				.addAction( FINGER.createPointerMove( Duration.ofMillis( 0 ), PointerInput.Origin.viewport( ), autoCompleteTextViewRectangle.getX( ) + 10, autoCompleteTextViewRectangle.getY( ) + autoCompleteTextViewRectangle.getHeight( ) + 10 ) )
				.addAction( FINGER.createPointerDown( PointerInput.MouseButton.LEFT.asArg( ) ) )
				.addAction( FINGER.createPointerUp( PointerInput.MouseButton.LEFT.asArg( ) ) );

		driver.perform( Collections.singletonList( action ) );
	}

	protected void clickElement ( RemoteWebElement element, int x, int y ) {
		Point point = Objects.nonNull( element ) ? element.getLocation( ) : new Point( 0, 0 );
		Point finalPoint = point.moveBy( x, y );
		PointerInput FINGER = new PointerInput( PointerInput.Kind.TOUCH, "finger" );

		Sequence action;

		action = new Sequence( FINGER, 1 )
				.addAction( FINGER.createPointerMove( Duration.ofMillis( 0 ), PointerInput.Origin.viewport( ), finalPoint.getX( ), finalPoint.getY( ) ) )
				.addAction( FINGER.createPointerDown( PointerInput.MouseButton.LEFT.asArg( ) ) )
				.addAction( FINGER.createPointerUp( PointerInput.MouseButton.LEFT.asArg( ) ) );

		driver.perform( Collections.singletonList( action ) );
	}

	protected void clickElement ( RemoteWebElement element ) {
		clickElement( element, 0, 0 );
	}

	protected void clickElement ( int x, int y ) {
		clickElement( null, x, y );
	}

}
