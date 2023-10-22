package steps;

import io.cucumber.java.en.When;
import pages.CheckoutAddressPage;
import pages.LogInPage;

/*
This class contains all the steps that are only send keys
 */
public class SendKeysSteps extends BaseSteps {

	@When( "I fill the username {string}" )
	public void i_fill_the_username ( String username ) {
		instanceOf( LogInPage.class ).sendKeysUsernameInput( username );
	}

	@When( "I fill the password {string}" )
	public void i_fill_the_username_and_password ( String password ) {
		instanceOf( LogInPage.class ).sendKeysPasswordInput( password );
	}

	@When( "I fill the shipping address information {string}, {string}, {string}, {string}, {string}, {string} and {string}" )
	public void i_fill_the_shipping_address_information ( String fullName, String addressLine1, String addressLine2, String city, String stateRegion, String zipCode, String country ) {
		instanceOf( CheckoutAddressPage.class ).sendKeysFullNameInput( fullName );
		instanceOf( CheckoutAddressPage.class ).sendKeysAddressLine1Input( addressLine1 );
		instanceOf( CheckoutAddressPage.class ).sendKeysAddressLine2Input( addressLine2 );
		instanceOf( CheckoutAddressPage.class ).sendKeysCityInput( city );
		instanceOf( CheckoutAddressPage.class ).sendKeysStateRegionInput( stateRegion );
		instanceOf( CheckoutAddressPage.class ).sendKeysZipCodeInput( zipCode );
		instanceOf( CheckoutAddressPage.class ).sendKeysCountryInput( country );
	}

}
