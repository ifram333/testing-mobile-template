package pages;

import extensions.UiAutomator2Extension;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.remote.RemoteWebElement;

public class CheckoutAddressPage extends BasePage {

	@AndroidFindBy( xpath = "//android.view.ViewGroup[@content-desc=\"container header\"]/android.widget.TextView" )
	private RemoteWebElement lblCheckout;

	@AndroidFindBy( xpath = "//android.widget.ScrollView[@content-desc=\"checkout address screen\"]/android.view.ViewGroup/android.widget.TextView[1]" )
	private RemoteWebElement lblEnterAShippingAddress;

	@AndroidFindBy( xpath = "//android.widget.ScrollView[@content-desc=\"checkout address screen\"]/android.view.ViewGroup/android.widget.TextView[2]" )
	private RemoteWebElement lblFullName;

	@AndroidFindBy( uiAutomator = noScrollDescription + "Full Name* input field" + noScrollWrapper )
	private RemoteWebElement txtFullName;

	@AndroidFindBy( xpath = "//android.view.ViewGroup[@content-desc=\"Full Name*-error-message\"]/android.widget.TextView" )
	private RemoteWebElement lblFullNameErrorMessage;

	@AndroidFindBy( xpath = "//android.widget.ScrollView[@content-desc=\"checkout address screen\"]/android.view.ViewGroup/android.widget.TextView[3]" )
	private RemoteWebElement lblAddressLine1;

	@AndroidFindBy( uiAutomator = noScrollDescription + "Address Line 1* input field" + noScrollWrapper )
	private RemoteWebElement txtAddressLine1;

	@AndroidFindBy( xpath = "//android.view.ViewGroup[@content-desc=\"Address Line 1*-error-message\"]/android.widget.TextView" )
	private RemoteWebElement lblAddressLine1ErrorMessage;

	@AndroidFindBy( xpath = "//android.widget.ScrollView[@content-desc=\"checkout address screen\"]/android.view.ViewGroup/android.widget.TextView[4]" )
	private RemoteWebElement lblAddressLine2;

	@AndroidFindBy( uiAutomator = noScrollDescription + "Address Line 2 input field" + noScrollWrapper )
	private RemoteWebElement txtAddressLine2;

	@AndroidFindBy( xpath = "//android.view.ViewGroup[@content-desc=\"Address Line 2-error-message\"]/android.widget.TextView" )
	private RemoteWebElement lblAddressLine2ErrorMessage;

	@AndroidFindBy( xpath = "//android.widget.ScrollView[@content-desc=\"checkout address screen\"]/android.view.ViewGroup/android.widget.TextView[5]" )
	private RemoteWebElement lblCity;

	@AndroidFindBy( uiAutomator = noScrollDescription + "City* input field" + noScrollWrapper )
	private RemoteWebElement txtCity;

	@AndroidFindBy( xpath = "//android.view.ViewGroup[@content-desc=\"City*-error-message\"]/android.widget.TextView" )
	private RemoteWebElement lblCityErrorMessage;

	@AndroidFindBy( xpath = "//android.widget.ScrollView[@content-desc=\"checkout address screen\"]/android.view.ViewGroup/android.widget.TextView[6]" )
	private RemoteWebElement lblStateRegion;

	@AndroidFindBy( uiAutomator = noScrollDescription + "State/Region input field" + noScrollWrapper )
	private RemoteWebElement txtStateRegion;

	@AndroidFindBy( xpath = "//android.view.ViewGroup[@content-desc=\"State/Region-error-message\"]/android.widget.TextView" )
	private RemoteWebElement lblStateRegionErrorMessage;

	@AndroidFindBy( xpath = "//android.widget.ScrollView[@content-desc=\"checkout address screen\"]/android.view.ViewGroup/android.widget.TextView[7]" )
	private RemoteWebElement lblZipCode;

	@AndroidFindBy( uiAutomator = noScrollDescription + "Zip Code* input field" + noScrollWrapper )
	private RemoteWebElement txtZipCode;

	@AndroidFindBy( xpath = "//android.view.ViewGroup[@content-desc=\"Zip Code*-error-message\"]/android.widget.TextView" )
	private RemoteWebElement lblZipCodeErrorMessage;

	@AndroidFindBy( xpath = "//android.widget.ScrollView[@content-desc=\"checkout address screen\"]/android.view.ViewGroup/android.widget.TextView[8]" )
	private RemoteWebElement lblCountry;

	@AndroidFindBy( uiAutomator = noScrollDescription + "Country* input field" + noScrollWrapper )
	private RemoteWebElement txtCountry;

	@AndroidFindBy( xpath = "//android.view.ViewGroup[@content-desc=\"Country*-error-message\"]/android.widget.TextView" )
	private RemoteWebElement lblCountryErrorMessage;

	@AndroidFindBy( uiAutomator = noScrollDescription + "To Payment button" + noScrollWrapper )
	private RemoteWebElement btnToPayment;

	public CheckoutAddressPage ( AndroidDriver driver ) {
		super( driver );
	}

	public void clickToPaymentButton ( ) {
		btnToPayment.click( );
		logger.info( "Click 'TO PAYMENT' button" );
	}

	public void sendKeysFullNameInput ( String fullName ) {
		txtFullName.clear( );
		txtFullName.sendKeys( fullName );
		logger.info( "Fill 'FULL NAME' with value " + fullName );
	}

	public void sendKeysAddressLine1Input ( String addressLine1 ) {
		txtAddressLine1.clear( );
		txtAddressLine1.sendKeys( addressLine1 );
		logger.info( "Fill 'ADDRESS LINE 1' with value " + addressLine1 );
	}

	public void sendKeysAddressLine2Input ( String addressLine2 ) {
		txtAddressLine2.clear( );
		txtAddressLine2.sendKeys( addressLine2 );
		logger.info( "Fill 'ADDRESS LINE 2' with value " + addressLine2 );
	}

	public void sendKeysCityInput ( String city ) {
		txtCity.clear( );
		txtCity.sendKeys( city );
		logger.info( "Fill 'CITY' with value " + city );
	}

	public void sendKeysStateRegionInput ( String stateRegion ) {
		txtStateRegion.clear( );
		txtStateRegion.sendKeys( stateRegion );
		logger.info( "Fill 'STATE/REGION' with value " + stateRegion );
	}

	public void sendKeysZipCodeInput ( String zipCode ) {
		txtZipCode.clear( );
		txtZipCode.sendKeys( zipCode );
		logger.info( "Fill 'ZIP CODE' with value " + zipCode );
	}

	public void sendKeysCountryInput ( String country ) {
		txtCountry.clear( );
		txtCountry.sendKeys( country );
		logger.info( "Fill 'COUNTRY' with value " + country );
	}

	public void validatePage ( ) {
		UiAutomator2Extension.WaitForElementVisibility( AppiumBy.xpath( "//android.view.ViewGroup[@content-desc=\"container header\"]/android.widget.TextView" ) );
		softly.assertThat( lblCheckout.isDisplayed( ) ).isTrue( );
		softly.assertThat( lblCheckout.getText( ) ).isEqualTo( "Checkout" );
		softly.assertThat( lblEnterAShippingAddress.isDisplayed( ) ).isTrue( );
		softly.assertThat( lblEnterAShippingAddress.getText( ) ).isEqualTo( "Enter a shipping address" );
		softly.assertThat( lblFullName.isDisplayed( ) ).isTrue( );
		softly.assertThat( lblFullName.getText( ) ).isEqualTo( "Full Name*" );
		softly.assertThat( txtFullName.isDisplayed( ) ).isTrue( );
		softly.assertThat( lblAddressLine1.isDisplayed( ) ).isTrue( );
		softly.assertThat( lblAddressLine1.getText( ) ).isEqualTo( "Address Line 1*" );
		softly.assertThat( txtAddressLine1.isDisplayed( ) ).isTrue( );
		softly.assertThat( lblAddressLine2.isDisplayed( ) ).isTrue( );
		softly.assertThat( lblAddressLine2.getText( ) ).isEqualTo( "Address Line 2" );
		softly.assertThat( txtAddressLine2.isDisplayed( ) ).isTrue( );
		softly.assertThat( lblCity.isDisplayed( ) ).isTrue( );
		softly.assertThat( lblCity.getText( ) ).isEqualTo( "City*" );
		softly.assertThat( txtCity.isDisplayed( ) ).isTrue( );
		softly.assertThat( lblStateRegion.isDisplayed( ) ).isTrue( );
		softly.assertThat( lblStateRegion.getText( ) ).isEqualTo( "State/Region" );
		softly.assertThat( txtStateRegion.isDisplayed( ) ).isTrue( );
		softly.assertThat( lblZipCode.isDisplayed( ) ).isTrue( );
		softly.assertThat( lblZipCode.getText( ) ).isEqualTo( "Zip Code*" );
		softly.assertThat( txtZipCode.isDisplayed( ) ).isTrue( );
		softly.assertThat( lblCountry.isDisplayed( ) ).isTrue( );
		softly.assertThat( lblCountry.getText( ) ).isEqualTo( "Country*" );
		softly.assertThat( txtCountry.isDisplayed( ) ).isTrue( );
		softly.assertThat( btnToPayment.isDisplayed( ) ).isTrue( );
		softly.assertThat( btnToPayment.isEnabled( ) ).isTrue( );
		softly.assertAll( );
		logger.info( "The Checkout page is loaded correctly" );
	}

	public void validateFullNameErrorMessage ( ) {
		softly.assertThat( lblFullNameErrorMessage.isDisplayed( ) ).isTrue( );
		softly.assertThat( lblFullNameErrorMessage.getText( ) ).isEqualTo( "Please provide your full name." );
		softly.assertAll( );
		logger.info( "The correct full name error message (Please provide your full name.) is displayed" );
	}

	public void validateAddressLine1ErrorMessage ( ) {
		softly.assertThat( lblAddressLine1ErrorMessage.isDisplayed( ) ).isTrue( );
		softly.assertThat( lblAddressLine1ErrorMessage.getText( ) ).isEqualTo( "Please provide your address." );
		softly.assertAll( );
		logger.info( "The correct address line 1 error message (Please provide your address.) is displayed" );
	}

	public void validateAddressLine2ErrorMessage ( ) {
		softly.assertThat( lblAddressLine2ErrorMessage.isDisplayed( ) ).isTrue( );
		softly.assertThat( lblAddressLine2ErrorMessage.getText( ) ).isEqualTo( "Please provide your address." );
		softly.assertAll( );
		logger.info( "The correct address line 2 error message (Please provide your address.) is displayed" );
	}

	public void validateCityErrorMessage ( ) {
		softly.assertThat( lblCityErrorMessage.isDisplayed( ) ).isTrue( );
		softly.assertThat( lblCityErrorMessage.getText( ) ).isEqualTo( "Please provide your city." );
		softly.assertAll( );
		logger.info( "The correct city error message (Please provide your city.) is displayed" );
	}

	public void validateStateRegionErrorMessage ( ) {
		softly.assertThat( lblStateRegionErrorMessage.isDisplayed( ) ).isTrue( );
		softly.assertThat( lblStateRegionErrorMessage.getText( ) ).isEqualTo( "Please provide your state/region." );
		softly.assertAll( );
		logger.info( "The correct state/region error message (Please provide your state/region.) is displayed" );
	}

	public void validateZipCodeErrorMessage ( ) {
		softly.assertThat( lblZipCodeErrorMessage.isDisplayed( ) ).isTrue( );
		softly.assertThat( lblZipCodeErrorMessage.getText( ) ).isEqualTo( "Please provide your zip code." );
		softly.assertAll( );
		logger.info( "The correct zip code error message (Please provide your zip code.) is displayed" );
	}

	public void validateCountryErrorMessage ( ) {
		softly.assertThat( lblCountryErrorMessage.isDisplayed( ) ).isTrue( );
		softly.assertThat( lblCountryErrorMessage.getText( ) ).isEqualTo( "Please provide your country." );
		softly.assertAll( );
		logger.info( "The correct country error message (Please provide your country.) is displayed" );
	}

}
