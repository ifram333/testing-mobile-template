package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.CheckoutAddressPage;
import pages.CheckoutPaymentPage;
import pages.LogInPage;

/*
This class contains all the steps that are only validations
 */
public class ValidationSteps extends BaseSteps {

	@Given( "The Login screen is displayed" )
	public void the_login_screen_is_displayed ( ) {
		instanceOf( LogInPage.class ).validatePage( );
	}

	@Then( "The user message {string} is displayed" )
	public void the_user_message_is_displayed ( String message ) {
		instanceOf( LogInPage.class ).validateErrorMessage( message );
	}

	@Then( "The username is required message is displayed" )
	public void the_username_is_required_message_is_displayed ( ) {
		instanceOf( LogInPage.class ).validateUsernameErrorMessage( );
	}

	@Then( "The password is required message is displayed" )
	public void the_password_is_required_message_is_displayed ( ) {
		instanceOf( LogInPage.class ).validatePasswordErrorMessage( );
	}

	@Then( "The Checkout Shipping Address screen is displayed" )
	public void the_checkout_shipping_address_screen_is_displayed ( ) {
		instanceOf( CheckoutAddressPage.class ).validatePage( );
	}

	@Then( "The checkout shipping address error messages are displayed" )
	public void the_checkout_shipping_address_error_messages_are_displayed ( ) {
		instanceOf( CheckoutAddressPage.class ).validateFullNameErrorMessage( );
		instanceOf( CheckoutAddressPage.class ).validateAddressLine1ErrorMessage( );
		instanceOf( CheckoutAddressPage.class ).validateCityErrorMessage( );
		instanceOf( CheckoutAddressPage.class ).validateZipCodeErrorMessage( );
		instanceOf( CheckoutAddressPage.class ).validateCountryErrorMessage( );
	}

	@Then( "The Checkout Payment screen is displayed" )
	public void the_checkout_payment_screen_is_displayed ( ) {
		instanceOf( CheckoutPaymentPage.class ).validatePage( );
	}

	@Then( "The checkout payment error messages are displayed" )
	public void the_checkout_payment_error_messages_are_displayed ( ) {
		instanceOf( CheckoutPaymentPage.class ).validateFullNameErrorMessage( );
		instanceOf( CheckoutPaymentPage.class ).validateCardNumberErrorMessage( );
		instanceOf( CheckoutPaymentPage.class ).validateExpirationDateErrorMessage( );
		instanceOf( CheckoutPaymentPage.class ).validateSecurityCodeErrorMessage( );
	}

}
