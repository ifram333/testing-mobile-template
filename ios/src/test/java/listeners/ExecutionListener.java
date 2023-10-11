package listeners;

import appium.AppiumServer;
import org.testng.IExecutionListener;

public class ExecutionListener implements IExecutionListener {

	@Override
	public void onExecutionStart ( ) {
		String ip = System.getProperty( "appium.ip" );
		int port = Integer.parseInt( System.getProperty( "appium.port" ) );
		String config = System.getProperty( "local.config" );

		AppiumServer.start( ip, port, config );
	}

	@Override
	public void onExecutionFinish ( ) {
		if ( AppiumServer.isRunning( ) ) AppiumServer.stop( );
	}

}
