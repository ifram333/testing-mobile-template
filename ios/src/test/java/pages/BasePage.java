package pages;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSXCUITBy;
import io.appium.java_client.pagefactory.iOSXCUITFindAll;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;
import java.util.Collections;

/*
This is the base class that all pages extend from.
 */
public class BasePage {

	protected final IOSDriver driver;
	protected final Logger logger = LogManager.getLogger( this.getClass( ) );
	protected final SoftAssertions softly = new SoftAssertions( );

	@iOSXCUITFindAll( { @iOSXCUITBy( accessibility = "Next:" ),
			@iOSXCUITBy( accessibility = "ui.accesoryToolbar.done" ),
			@iOSXCUITBy( accessibility = "Done" ),
			@iOSXCUITBy( accessibility = "Return" ) } )
	protected RemoteWebElement returnButton;

	@iOSXCUITFindBy( className = "XCUIElementTypeNavigationBar" )
	private RemoteWebElement navigationBar;

	public BasePage ( IOSDriver driver ) {
		this.driver = driver;
	}

	protected void manageNotifications ( Boolean show ) {
		Dimension screenSize = driver.manage( ).window( ).getSize( );
		PointerInput FINGER = new PointerInput( PointerInput.Kind.TOUCH, "finger" );

		Point top = new Point( screenSize.width / 2, 5 );
		Point bottom = new Point( screenSize.width / 2, screenSize.height - 5 );
		Sequence action;

		if ( show ) {
			action = new Sequence( FINGER, 1 )
					.addAction( FINGER.createPointerMove( Duration.ofMillis( 0 ), PointerInput.Origin.viewport( ), top.getX( ), top.getY( ) ) )
					.addAction( FINGER.createPointerDown( PointerInput.MouseButton.LEFT.asArg( ) ) )
					.addAction( FINGER.createPointerMove( Duration.ofMillis( 1000 ), PointerInput.Origin.viewport( ), bottom.getX( ), bottom.getY( ) ) )
					.addAction( FINGER.createPointerUp( PointerInput.MouseButton.LEFT.asArg( ) ) );
		} else {
			action = new Sequence( FINGER, 1 )
					.addAction( FINGER.createPointerMove( Duration.ofMillis( 0 ), PointerInput.Origin.viewport( ), bottom.getX( ), bottom.getY( ) ) )
					.addAction( FINGER.createPointerDown( PointerInput.MouseButton.LEFT.asArg( ) ) )
					.addAction( FINGER.createPointerMove( Duration.ofMillis( 1000 ), PointerInput.Origin.viewport( ), top.getX( ), top.getY( ) ) )
					.addAction( FINGER.createPointerUp( PointerInput.MouseButton.LEFT.asArg( ) ) );
		}

		driver.perform( Collections.singletonList( action ) );
	}

	protected void hideKeyboard ( ) {
		PointerInput FINGER = new PointerInput( PointerInput.Kind.TOUCH, "finger" );

		Point navigationBarPoint = navigationBar.getLocation( );
		Sequence action;

		action = new Sequence( FINGER, 1 )
				.addAction( FINGER.createPointerMove( Duration.ofMillis( 0 ), PointerInput.Origin.viewport( ), navigationBarPoint.getX( ), navigationBarPoint.getY( ) + navigationBar.getRect( ).getHeight( ) + 1 ) )
				.addAction( FINGER.createPointerDown( PointerInput.MouseButton.LEFT.asArg( ) ) )
				.addAction( FINGER.createPointerUp( PointerInput.MouseButton.LEFT.asArg( ) ) );

		driver.perform( Collections.singletonList( action ) );
	}

	protected void clickElement ( RemoteWebElement element, double x, double y ) {
		Rectangle rectangle = element.getRect( );
		PointerInput FINGER = new PointerInput( PointerInput.Kind.TOUCH, "finger" );

		Sequence action;

		int posX = ( int ) ( rectangle.getX( ) + ( rectangle.getWidth( ) * x ) );
		int posY = ( int ) ( rectangle.getY( ) + ( rectangle.getHeight( ) * y ) );

		action = new Sequence( FINGER, 1 )
				.addAction( FINGER.createPointerMove( Duration.ofMillis( 0 ), PointerInput.Origin.viewport( ), posX, posY ) )
				.addAction( FINGER.createPointerDown( PointerInput.MouseButton.LEFT.asArg( ) ) )
				.addAction( FINGER.createPointerUp( PointerInput.MouseButton.LEFT.asArg( ) ) );

		driver.perform( Collections.singletonList( action ) );
	}

}
