package pages;

import helpers.OCRHelper;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class LoginPage extends BasePage {

	private final Logger logger = LogManager.getLogger( );

	@iOSXCUITFindBy( accessibility = "test-Usuario" )
	private RemoteWebElement usernameInput;

	@iOSXCUITFindBy( accessibility = "test-Contraseña" )
	private RemoteWebElement passwordInput;

	@iOSXCUITFindBy( accessibility = "test-LOGIN" )
	private RemoteWebElement loginButton;

	@iOSXCUITFindBy( accessibility = "test-standard_user" )
	private RemoteWebElement standardUserLabel;

	@iOSXCUITFindBy( accessibility = "test-locked_out_user" )
	private RemoteWebElement lockedOutUserLabel;

	@iOSXCUITFindBy( accessibility = "test-problem_user" )
	private RemoteWebElement problemUserLabel;

	@iOSXCUITFindBy( accessibility = "Usuario es requerido" )
	private RemoteWebElement usernameIsRequiredLabel;

	@iOSXCUITFindBy( accessibility = "Contraseña es requerida" )
	private RemoteWebElement passwordIsRequiredLabel;

	@iOSXCUITFindBy( accessibility = "Lo sentimos, este usuario ha sido bloqueado." )
	private RemoteWebElement sorryUserLockedOutLabel;

	public LoginPage ( IOSDriver driver ) {
		super( driver );
	}

	/*
	Fill input functionalities
	 */
	public void fillUsernameInput ( String username ) {
		usernameInput.click( );
		usernameInput.clear( );
		usernameInput.sendKeys( username );
		returnButton.click( );
		logger.info( "Fill the 'USERNAME' input with the value '" + username + "'" );
	}

	public void fillPasswordInput ( String password ) {
		passwordInput.click( );
		passwordInput.clear( );
		passwordInput.sendKeys( password );
		returnButton.click( );
		logger.info( "Fill the 'PASSWORD' input with the value '" + password + "'" );
	}

	/*
	Click functionalities
	 */
	public void clickLoginButton ( ) {
		loginButton.click( );
		logger.info( "Click the 'LOGIN' button" );
	}

	public void clickStandardUserLabel ( ) {
		standardUserLabel.click( );
		logger.info( "Click the 'STANDARD_USER' label" );
	}

	public void clickLockedOutUserLabel ( ) {
		lockedOutUserLabel.click( );
		logger.info( "Click the 'LOCKED_OUT_USER' label" );
	}

	public void clickProblemUserLabel ( ) {
		problemUserLabel.click( );
		logger.info( "Click the 'PROBLEM_USER' label" );
	}

	/*
	Validation functionalities
	 */
	public void validateUsernameInput ( ) {
		assertTrue( usernameInput.isDisplayed( ), "The 'USERNAME' input is not displayed" );
		logger.info( "The 'USERNAME' input is displayed" );
	}

	public void validatePasswordInput ( ) {
		assertTrue( passwordInput.isDisplayed( ), "The 'PASSWORD' input is not displayed" );
		logger.info( "The 'PASSWORD' input is displayed" );
	}

	public void validateLoginButton ( ) {
		assertTrue( loginButton.isDisplayed( ), "The 'LOGIN' button is not displayed" );
		logger.info( "The 'LOGIN' button is displayed" );
	}

	public void validateUsernameInputValue ( String username ) {
		assertTrue( username.equalsIgnoreCase( usernameInput.getText( ) ), "The 'USERNAME' input does not have the value '" + username + "'" );
		logger.info( "The 'USERNAME' input has the value '" + username + "'" );
	}

	public void validateUsernameIsRequiredLabel ( ) {
		assertTrue( usernameIsRequiredLabel.isDisplayed( ), "The 'USERNAME IS REQUIRED' label is not displayed" );
		logger.info( "The 'USERNAME IS REQUIRED' label is displayed" );
	}

	public void validatePasswordIsRequiredLabel ( ) {
		assertTrue( passwordIsRequiredLabel.isDisplayed( ), "The 'PASSWORD IS REQUIRED' label is not displayed" );
		logger.info( "The 'PASSWORD IS REQUIRED' label is displayed" );
	}

	public void validateSorryUserLockedOutLabel ( ) {
		assertTrue( sorryUserLockedOutLabel.isDisplayed( ), "The 'SORRY, THIS USER HAS BEEN LOCKED OUT' label is not displayed" );
		logger.info( "The 'SORRY, THIS USER HAS BEEN LOCKED OUT' label is displayed" );
	}

	public void validateSwagLabsImage ( ) {
		RemoteWebElement element = ( RemoteWebElement ) driver.findElement( By.xpath( "//XCUIElementTypeOther[@name=\"Usuario Contraseña LOGIN\"]/XCUIElementTypeOther[1]/XCUIElementTypeImage" ) );
		String swagLabsTitle = OCRHelper.getStringFromImageElement( element );
		assertNotNull( swagLabsTitle );
		assertTrue( swagLabsTitle.contains( "SWAGLABS" ), "The 'SWAGLABS' title is not displayed" );
		logger.info( "The 'SWAGLABS' title is displayed" );
	}

}
