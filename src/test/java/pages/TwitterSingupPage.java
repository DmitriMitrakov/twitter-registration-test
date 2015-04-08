package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TwitterSingupPage extends PageObject {
	
	static final String URL = "https://twitter.com/signup";
	public static final String WRONG_EMAIL_HINT = "Вы ввели неверный адрес электронной почты.";

	public TwitterSingupPage(WebDriver driver) {
		super(driver, URL);
	}
	
	public String getUserName() {
		return findElement(By.id("full-name")).getAttribute("value");
	}
	
	public String getUserEmail() {
		return findElement(By.id("email")).getAttribute("value");
	}
	
	public String getUserLogin() {
		return findElement(By.id("username")).getAttribute("value");
	}
	
	public void enterUserEmail(String email) {
		findElement(By.id("email")).clear();
		findElement(By.id("email")).sendKeys(email);
	}
	
	public String getFirstRecommendedLogin() {
		return findElement(By.cssSelector("button.btn-link")).getText();
	}
	
	public void setFirstRecommendedLogin() {
		findElement(By.cssSelector("button.btn-link")).click();
	}
	
	public TwitterRedirectionPage submitSignupForm() {
		findElement(By.id("submit_button")).click();
		return new TwitterRedirectionPage(driver);
	}
}
