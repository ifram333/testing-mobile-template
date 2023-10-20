package steps;

import io.cucumber.java.en.When;
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

}
