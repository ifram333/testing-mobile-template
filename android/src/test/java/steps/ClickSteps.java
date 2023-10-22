package steps;

import io.cucumber.java.en.When;
import pages.CheckoutAddressPage;
import pages.CheckoutPaymentPage;
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

	@When( "I click the to payment button" )
	public void i_click_the_to_payment_button ( ) {
		instanceOf( CheckoutAddressPage.class ).clickToPaymentButton( );
	}

	@When( "I click the review order button" )
	public void i_click_the_review_order_button ( ) {
		instanceOf( CheckoutPaymentPage.class ).clickReviewOrderButton( );
	}

}
