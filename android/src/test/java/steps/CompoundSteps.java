package steps;

import io.cucumber.java.en.When;
import pages.LoginPage;

/*
This class contains all the steps that are made up of different actions
 */
public class CompoundSteps extends BaseSteps {

	@When( "I log in the app with the user {string} and password {string}" )
	public void i_log_in_the_app_with_the_user_and_password ( String username, String password ) {
		instanceOf( LoginPage.class ).fillUsernameInput( username );
		instanceOf( LoginPage.class ).fillPasswordInput( password );
		instanceOf( LoginPage.class ).clickLoginButton( );
	}

	@When( "I try to log in the app with the user {string} and password {string}" )
	public void i_try_to_log_in_the_app_with_the_user_and_password ( String username, String password ) {
		instanceOf( LoginPage.class ).fillUsernameInput( username );
		instanceOf( LoginPage.class ).fillPasswordInput( password );
		instanceOf( LoginPage.class ).clickLoginButton( );
	}

}
