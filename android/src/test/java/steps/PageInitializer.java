package steps;

import drivers.AndroidAppDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.time.Duration;

/*
This is a custom class to instantiate a page and initialize its elements using Reflections
 */
public class PageInitializer {

	public static < T > T instanceOf ( Class< T > clazz ) {
		return initElements( AndroidAppDriver.getDriver( ), clazz );
	}

	private static < T > T initElements ( AndroidDriver driver, Class< T > pageClassToProxy ) {
		T page = instantiatePage( driver, pageClassToProxy );
		/*
		Adjusting the maximum wait time to find an element on the test device (30 seconds)
		 */
		PageFactory.initElements( new AppiumFieldDecorator( driver, Duration.ofSeconds( 30 ) ), page );
		return page;
	}

	private static < T > T instantiatePage ( AndroidDriver driver, Class< T > pageClassToProxy ) {
		try {
			try {
				Constructor< T > constructor = pageClassToProxy.getConstructor( AndroidDriver.class );
				return constructor.newInstance( driver );
			} catch ( NoSuchMethodException e ) {
				return pageClassToProxy.getDeclaredConstructor( ).newInstance( );
			}
		} catch ( InstantiationException | IllegalAccessException | InvocationTargetException |
				  NoSuchMethodException e ) {
			throw new RuntimeException( e );
		}
	}

}
