package pages;

import extensions.UiAutomator2Extension;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.remote.RemoteWebElement;

public class CheckoutPaymentPage extends BasePage {

	@AndroidFindBy( xpath = "//android.view.ViewGroup[@content-desc=\"container header\"]/android.widget.TextView" )
	private RemoteWebElement lblCheckout;

	@AndroidFindBy( xpath = "//android.widget.ScrollView[@content-desc=\"checkout payment screen\"]/android.view.ViewGroup/android.widget.TextView[1]" )
	private RemoteWebElement lblEnterAPaymentMethod;

	@AndroidFindBy( xpath = "//android.widget.ScrollView[@content-desc=\"checkout payment screen\"]/android.view.ViewGroup/android.widget.TextView[2]" )
	private RemoteWebElement lblDisclaimer;

	@AndroidFindBy( xpath = "//android.widget.ScrollView[@content-desc=\"checkout payment screen\"]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView" )
	private RemoteWebElement lblCard;

	@AndroidFindBy( xpath = "//android.widget.ScrollView[@content-desc=\"checkout payment screen\"]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ImageView" )
	private RemoteWebElement imgCard;

	@AndroidFindBy( xpath = "//android.widget.ScrollView[@content-desc=\"checkout payment screen\"]/android.view.ViewGroup/android.widget.TextView[3]" )
	private RemoteWebElement lblFullName;

	@AndroidFindBy( uiAutomator = noScrollDescription + "Full Name* input field" + noScrollWrapper )
	private RemoteWebElement txtFullName;

	@AndroidFindBy( xpath = "//android.view.ViewGroup[@content-desc=\"Full Name*-error-message\"]/android.widget.TextView" )
	private RemoteWebElement lblFullNameErrorMessage;

	@AndroidFindBy( xpath = "//android.widget.ScrollView[@content-desc=\"checkout payment screen\"]/android.view.ViewGroup/android.widget.TextView[4]" )
	private RemoteWebElement lblCardNumber;

	@AndroidFindBy( uiAutomator = noScrollDescription + "Card Number* input field" + noScrollWrapper )
	private RemoteWebElement txtCardNumber;

	@AndroidFindBy( xpath = "//android.view.ViewGroup[@content-desc=\"Card Number*-error-message\"]/android.widget.TextView" )
	private RemoteWebElement lblCardNumberErrorMessage;

	@AndroidFindBy( xpath = "//android.widget.ScrollView[@content-desc=\"checkout payment screen\"]/android.view.ViewGroup/android.widget.TextView[5]" )
	private RemoteWebElement lblExpirationDate;

	@AndroidFindBy( uiAutomator = noScrollDescription + "Expiration Date* input field" + noScrollWrapper )
	private RemoteWebElement txtExpirationDate;

	@AndroidFindBy( xpath = "//android.view.ViewGroup[@content-desc=\"Expiration Date*-error-message\"]/android.widget.TextView" )
	private RemoteWebElement lblExpirationDateErrorMessage;

	@AndroidFindBy( xpath = "//android.widget.ScrollView[@content-desc=\"checkout payment screen\"]/android.view.ViewGroup/android.widget.TextView[6]" )
	private RemoteWebElement lblSecurityCode;

	@AndroidFindBy( uiAutomator = noScrollDescription + "Security Code* input field" + noScrollWrapper )
	private RemoteWebElement txtSecurityCode;

	@AndroidFindBy( xpath = "//android.view.ViewGroup[@content-desc=\"Security Code*-error-message\"]/android.widget.TextView" )
	private RemoteWebElement lblSecurityCodeErrorMessage;

	@AndroidFindBy( uiAutomator = noScrollDescription + "checkbox for My billing address is the same as my shipping address." + noScrollWrapper )
	private RemoteWebElement chkBillingAddress;

	@AndroidFindBy( xpath = "//android.widget.ScrollView[@content-desc=\"checkout payment screen\"]/android.view.ViewGroup/android.widget.TextView[7]" )
	private RemoteWebElement lblBillingAddress;

	@AndroidFindBy( uiAutomator = noScrollDescription + "Review Order button" + noScrollWrapper )
	private RemoteWebElement btnReviewOrder;

	public CheckoutPaymentPage ( AndroidDriver driver ) {
		super( driver );
	}

	public void clickReviewOrderButton ( ) {
		btnReviewOrder.click( );
		logger.info( "Click 'REVIEW ORDER' button" );
	}

	public void sendKeysFullNameInput ( String fullName ) {
		txtFullName.clear( );
		txtFullName.sendKeys( fullName );
		logger.info( "Fill 'FULL NAME' with value " + fullName );
	}

	public void sendKeysCardNumberInput ( String cardNumber ) {
		txtCardNumber.clear( );
		txtCardNumber.sendKeys( cardNumber );
		logger.info( "Fill 'CARD NUMBER' with value " + cardNumber );
	}

	public void sendKeysExpirationDateInput ( String expirationDate ) {
		txtExpirationDate.clear( );
		txtExpirationDate.sendKeys( expirationDate );
		logger.info( "Fill 'EXPIRATION DATE' with value " + expirationDate );
	}

	public void sendKeysSecurityCodeInput ( String securityCode ) {
		txtSecurityCode.clear( );
		txtSecurityCode.sendKeys( securityCode );
		logger.info( "Fill 'SECURITY CODE' with value " + securityCode );
	}

	public void validatePage ( ) {
		UiAutomator2Extension.WaitForElementVisibility( AppiumBy.xpath( "//android.view.ViewGroup[@content-desc=\"container header\"]/android.widget.TextView" ) );
		softly.assertThat( lblCheckout.isDisplayed( ) ).isTrue( );
		softly.assertThat( lblCheckout.getText( ) ).isEqualTo( "Checkout" );
		softly.assertThat( lblEnterAPaymentMethod.isDisplayed( ) ).isTrue( );
		softly.assertThat( lblEnterAPaymentMethod.getText( ) ).isEqualTo( "Enter a payment method" );
		softly.assertThat( lblDisclaimer.isDisplayed( ) ).isTrue( );
		softly.assertThat( lblDisclaimer.getText( ) ).isEqualTo( "You will not be charged until you review your purchase on the next screen." );
		softly.assertThat( lblCard.isDisplayed( ) ).isTrue( );
		softly.assertThat( lblCard.getText( ) ).isEqualTo( "Card" );
		softly.assertThat( imgCard.isDisplayed( ) ).isTrue( );
		softly.assertThat( lblFullName.isDisplayed( ) ).isTrue( );
		softly.assertThat( lblFullName.getText( ) ).isEqualTo( "Full Name*" );
		softly.assertThat( txtFullName.isDisplayed( ) ).isTrue( );
		softly.assertThat( lblCardNumber.isDisplayed( ) ).isTrue( );
		softly.assertThat( lblCardNumber.getText( ) ).isEqualTo( "Card Number*" );
		softly.assertThat( txtCardNumber.isDisplayed( ) ).isTrue( );
		softly.assertThat( lblExpirationDate.isDisplayed( ) ).isTrue( );
		softly.assertThat( lblExpirationDate.getText( ) ).isEqualTo( "Expiration Date*" );
		softly.assertThat( txtExpirationDate.isDisplayed( ) ).isTrue( );
		softly.assertThat( lblSecurityCode.isDisplayed( ) ).isTrue( );
		softly.assertThat( lblSecurityCode.getText( ) ).isEqualTo( "Security Code*" );
		softly.assertThat( txtSecurityCode.isDisplayed( ) ).isTrue( );
		softly.assertThat( lblBillingAddress.isDisplayed( ) ).isTrue( );
		softly.assertThat( lblBillingAddress.getText( ) ).isEqualTo( "My billing address is the same as my shipping address." );
		softly.assertThat( chkBillingAddress.isDisplayed( ) ).isTrue( );
		softly.assertThat( btnReviewOrder.isDisplayed( ) ).isTrue( );
		softly.assertThat( btnReviewOrder.isEnabled( ) ).isTrue( );
		softly.assertAll( );
		logger.info( "The Payment page is loaded correctly" );
	}

	public void validateFullNameErrorMessage ( ) {
		softly.assertThat( lblFullNameErrorMessage.isDisplayed( ) ).isTrue( );
		softly.assertThat( lblFullNameErrorMessage.getText( ) ).isEqualTo( "Value looks invalid." );
		softly.assertAll( );
		logger.info( "The correct full name error message (Value looks invalid.) is displayed" );
	}

	public void validateCardNumberErrorMessage ( ) {
		softly.assertThat( lblCardNumberErrorMessage.isDisplayed( ) ).isTrue( );
		softly.assertThat( lblCardNumberErrorMessage.getText( ) ).isEqualTo( "Value looks invalid." );
		softly.assertAll( );
		logger.info( "The correct card number error message (Value looks invalid.) is displayed" );
	}

	public void validateExpirationDateErrorMessage ( ) {
		softly.assertThat( lblExpirationDateErrorMessage.isDisplayed( ) ).isTrue( );
		softly.assertThat( lblExpirationDateErrorMessage.getText( ) ).isEqualTo( "Value looks invalid." );
		softly.assertAll( );
		logger.info( "The correct expiration date error message (Value looks invalid.) is displayed" );
	}

	public void validateSecurityCodeErrorMessage ( ) {
		softly.assertThat( lblSecurityCodeErrorMessage.isDisplayed( ) ).isTrue( );
		softly.assertThat( lblSecurityCodeErrorMessage.getText( ) ).isEqualTo( "Value looks invalid." );
		softly.assertAll( );
		logger.info( "The correct city error message (Value looks invalid.) is displayed" );
	}

}
