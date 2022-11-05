package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.LoginPage;

/*
This class contains all the steps that are only clicks
 */
public class ClickSteps extends BaseSteps {

	@When( "I click on the LOGIN button without filling the username input" )
	public void i_click_on_the_login_button_without_filling_the_username_input ( ) {
		instanceOf( LoginPage.class ).clickLoginButton( );
	}

	@And( "I click on the LOGIN button" )
	public void i_click_on_the_login_button ( ) {
		instanceOf( LoginPage.class ).clickLoginButton( );
	}

	@When( "I click on the standard user label" )
	public void i_click_on_the_standard_user_label ( ) {
		instanceOf( LoginPage.class ).clickStandardUserLabel( );
	}

	@When( "I click on the locked out user label" )
	public void i_click_on_the_locked_out_user_label ( ) {
		instanceOf( LoginPage.class ).clickLockedOutUserLabel( );
	}

	@When( "I click on the problem user label" )
	public void i_click_on_the_problem_user_label ( ) {
		instanceOf( LoginPage.class ).clickProblemUserLabel( );
	}

}
