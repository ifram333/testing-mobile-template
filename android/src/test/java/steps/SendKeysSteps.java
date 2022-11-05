package steps;

import io.cucumber.java.en.When;
import pages.LoginPage;

/*
This class contains all the steps that are only send keys
 */
public class SendKeysSteps extends BaseSteps {

	@When( "I fill the username input" )
	public void i_fill_the_username_input ( ) {
		instanceOf( LoginPage.class ).fillUsernameInput( "username" );
	}

}
