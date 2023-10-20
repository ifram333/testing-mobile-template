package pages;

import extensions.UiAutomator2Extension;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.remote.RemoteWebElement;

public class ProductsPage extends BasePage {

	@AndroidFindBy( xpath = "//android.view.ViewGroup[@content-desc=\"container header\"]/android.widget.TextView" )
	private RemoteWebElement lblProducts;

	public ProductsPage ( AndroidDriver driver ) {
		super( driver );
	}

	public void validatePage ( ) {
		UiAutomator2Extension.WaitForElementVisibility( AppiumBy.xpath( "//android.view.ViewGroup[@content-desc=\"container header\"]/android.widget.TextView" ) );
		softly.assertThat( lblProducts.isDisplayed( ) ).isTrue( );
		softly.assertThat( lblProducts.getText( ) ).isEqualTo( "Products" );
		softly.assertAll( );
		logger.info( "The Products page is loaded correctly" );
	}

}
