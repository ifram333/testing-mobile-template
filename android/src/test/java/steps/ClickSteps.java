package steps;

import io.cucumber.java.en.When;
import pages.LogInPage;

/*
This class contains all the steps that are only clicks
 */
public class ClickSteps extends BaseSteps {

	@When( "I click the login button" )
	public void i_click_the_login_button ( ) {
		instanceOf( LogInPage.class ).clickLoginButton( );
	}

	@When( "I click on the Login button" )
	public void i_click_on_the_login_button ( ) {
		instanceOf( LogInPage.class ).clickLoginButton( );
	}

}
