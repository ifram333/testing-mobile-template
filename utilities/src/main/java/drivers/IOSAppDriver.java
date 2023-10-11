package drivers;

import io.appium.java_client.ios.IOSDriver;

public class IOSAppDriver {

	private static final ThreadLocal< IOSDriver > iosDriverThreadLocal = new ThreadLocal<>( );

	public synchronized static void startDriver ( IOSDriver driver ) {
		iosDriverThreadLocal.set( driver );
	}

	public synchronized static IOSDriver getDriver ( ) {
		return iosDriverThreadLocal.get( );
	}

}
