package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TwitterMainPage extends PageObject {
	
	static final String URL = "https://twitter.com/";

	public TwitterMainPage(WebDriver driver) {
		super(driver, URL);
	}
	
	public void enterName(String name) {
		findElement(By.name("user[name]")).clear();
		findElement(By.name("user[name]")).sendKeys(name);
	}
	
	public void enterEmail(String email) {
		findElement(By.name("user[email]")).clear();
		findElement(By.name("user[email]")).sendKeys(email);
	}
	
	public void enterPassword(String password) {
		findElement(By.name("user[user_password]")).clear();
		findElement(By.name("user[user_password]")).sendKeys(password);
	}
	
	public TwitterSingupPage submitRegistrationForm() {
		driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div[2]/div[3]/form/button")).click();
		return new TwitterSingupPage(driver);
	}

}
