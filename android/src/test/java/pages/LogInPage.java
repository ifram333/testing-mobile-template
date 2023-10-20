package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.remote.RemoteWebElement;

public class LogInPage extends BasePage {

	@AndroidFindBy( xpath = "//android.view.ViewGroup[@content-desc=\"container header\"]/android.widget.TextView" )
	private RemoteWebElement lblLogin;

	@AndroidFindBy( uiAutomator = noScrollText + "Select a username and password from the list below, or click on the usernames to automatically populate the username and password." + noScrollWrapper )
	private RemoteWebElement lblSelectUsernameAndPassword;

	@AndroidFindBy( xpath = "//android.widget.EditText[@content-desc=\"Username input field\"]/preceding-sibling::android.widget.TextView[last()]" )
	private RemoteWebElement lblUsername;

	@AndroidFindBy( uiAutomator = noScrollDescription + "Username input field" + noScrollWrapper )
	private RemoteWebElement txtUsername;

	@AndroidFindBy( xpath = "//android.view.ViewGroup[@content-desc=\"Username-error-message\"]/android.widget.TextView" )
	private RemoteWebElement lblUsernameErrorMessage;

	@AndroidFindBy( xpath = "//android.widget.EditText[@content-desc=\"Password input field\"]/preceding-sibling::android.widget.TextView[last()]" )
	private RemoteWebElement lblPassword;

	@AndroidFindBy( uiAutomator = noScrollDescription + "Password input field" + noScrollWrapper )
	private RemoteWebElement txtPassword;

	@AndroidFindBy( xpath = "//android.view.ViewGroup[@content-desc=\"Password-error-message\"]/android.widget.TextView" )
	private RemoteWebElement lblPasswordErrorMessage;

	@AndroidFindBy( xpath = "//android.view.ViewGroup[@content-desc=\"generic-error-message\"]/android.widget.TextView" )
	private RemoteWebElement lblErrorMessage;

	@AndroidFindBy( uiAutomator = noScrollDescription + "Login button" + noScrollWrapper )
	private RemoteWebElement btnLogin;

	public LogInPage ( AndroidDriver driver ) {
		super( driver );
	}

	public void clickLoginButton ( ) {
		btnLogin.click( );
		logger.info( "Click 'LOGIN' button" );
	}

	public void sendKeysUsernameInput ( String username ) {
		txtUsername.clear( );
		txtUsername.sendKeys( username );
		logger.info( "Fill 'USERNAME' with value " + username );
	}

	public void sendKeysPasswordInput ( String password ) {
		txtPassword.clear( );
		txtPassword.sendKeys( password );
		logger.info( "Fill 'PASSWORD' with value " + password );
	}

	public void validatePage ( ) {
		softly.assertThat( lblLogin.getText( ) ).isEqualTo( "Login" );
		softly.assertThat( lblSelectUsernameAndPassword.isDisplayed( ) ).isTrue( );
		softly.assertThat( lblUsername.getText( ) ).isEqualTo( "Username" );
		softly.assertThat( txtUsername.isDisplayed( ) ).isTrue( );
		softly.assertThat( txtUsername.isEnabled( ) ).isTrue( );
		softly.assertThat( lblPassword.getText( ) ).isEqualTo( "Password" );
		softly.assertThat( txtPassword.isDisplayed( ) ).isTrue( );
		softly.assertThat( txtPassword.isEnabled( ) ).isTrue( );
		softly.assertThat( btnLogin.isDisplayed( ) ).isTrue( );
		softly.assertThat( btnLogin.isEnabled( ) ).isTrue( );
		softly.assertAll( );
		logger.info( "The Login page is loaded correctly" );
	}

	public void validateUsernameErrorMessage ( ) {
		softly.assertThat( lblUsernameErrorMessage.isDisplayed( ) ).isTrue( );
		softly.assertThat( lblUsernameErrorMessage.getText( ) ).isEqualTo( "Username is required" );
		softly.assertAll( );
		logger.info( "The correct username error message (" + lblUsernameErrorMessage.getText( ) + ") is displayed" );
	}

	public void validatePasswordErrorMessage ( ) {
		softly.assertThat( lblPasswordErrorMessage.isDisplayed( ) ).isTrue( );
		softly.assertThat( lblPasswordErrorMessage.getText( ) ).isEqualTo( "Password is required" );
		softly.assertAll( );
		logger.info( "The correct password error message (" + lblPasswordErrorMessage.getText( ) + ") is displayed" );
	}

	public void validateErrorMessage ( String message ) {
		softly.assertThat( lblErrorMessage.isDisplayed( ) ).isTrue( );
		softly.assertThat( lblErrorMessage.getText( ) ).isEqualTo( message );
		softly.assertAll( );
		logger.info( "The correct error message (" + message + ") is displayed" );
	}

}
