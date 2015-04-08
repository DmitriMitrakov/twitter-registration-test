package pages;

import org.openqa.selenium.WebDriver;

public class TwitterRedirectionPage extends PageObject {
	
	private static final String GREETING = "Рады вас видеть";
	private static final String PHONE_CHECK = "Проверка номера телефона";

	public TwitterRedirectionPage(WebDriver driver) {
		super(driver, null);
	}
	
	public boolean redirectOk() {
		return isTextPresent(GREETING) || isTextPresent(PHONE_CHECK);
	}
}
