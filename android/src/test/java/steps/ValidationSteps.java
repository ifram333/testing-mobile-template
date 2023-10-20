package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.LogInPage;
import pages.ProductsPage;

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

	@Then( "The Products screen is displayed" )
	public void the_products_screen_is_displayed ( ) {
		instanceOf( ProductsPage.class ).validatePage( );
	}

}
