package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.LoginPage;
import pages.ProductsPage;

/*
This class contains all the steps that are only validations
 */
public class ValidationSteps extends BaseSteps {

	@Given( "The Log In screen is displayed" )
	public void the_log_in_screen_is_displayed ( ) {
		instanceOf( LoginPage.class ).validateSwagLabsImage( );
		instanceOf( LoginPage.class ).validateUsernameInput( );
		instanceOf( LoginPage.class ).validatePasswordInput( );
		instanceOf( LoginPage.class ).validateLoginButton( );
	}

	@Then( "The Products screen is displayed" )
	public void the_products_screen_is_displayed ( ) {
		instanceOf( ProductsPage.class ).validateProductsLabel( );
	}

	@Then( "The locked out user message is displayed" )
	public void the_locked_out_user_message_is_displayed ( ) {
		instanceOf( LoginPage.class ).validateSorryUserLockedOutLabel( );
	}

	@Then( "The username is required message is displayed" )
	public void the_username_is_required_message_is_displayed ( ) {
		instanceOf( LoginPage.class ).validateUsernameIsRequiredLabel( );
	}

	@Then( "The password is required message is displayed" )
	public void the_password_is_required_message_is_displayed ( ) {
		instanceOf( LoginPage.class ).validatePasswordIsRequiredLabel( );
	}

	@Then( "The username input is filled with the value standard_user" )
	public void the_username_input_is_filled_with_the_value_standard_user ( ) {
		instanceOf( LoginPage.class ).validateUsernameInputValue( "standard_user" );
	}

	@Then( "The username input is filled with the value locked_out_user" )
	public void the_username_input_is_filled_with_the_value_locked_out_user ( ) {
		instanceOf( LoginPage.class ).validateUsernameInputValue( "locked_out_user" );
	}

	@Then( "The username input is filled with the value problem_user" )
	public void the_username_input_is_filled_with_the_value_problem_user ( ) {
		instanceOf( LoginPage.class ).validateUsernameInputValue( "problem_user" );
	}

}
