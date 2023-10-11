package drivers;

import io.appium.java_client.android.AndroidDriver;

public class AndroidAppDriver {

	private static final ThreadLocal< AndroidDriver > androidDriverThreadLocal = new ThreadLocal<>( );

	public synchronized static void startDriver ( AndroidDriver driver ) {
		androidDriverThreadLocal.set( driver );
	}

	public synchronized static AndroidDriver getDriver ( ) {
		return androidDriverThreadLocal.get( );
	}

}
