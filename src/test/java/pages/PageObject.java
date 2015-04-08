package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class PageObject {
	
	protected final WebDriver driver;
	private final String url;
	
	public PageObject(WebDriver driver, String url) {
		this.driver = driver;
		this.url = url;
	}
	
	public void open() {
		driver.get(url);
	}
	
	public boolean isPageLoaded() {
		return driver.getPageSource().contains(url);
	}
	
	public WebElement findElement(By by) {
		return driver.findElement(by);
	}
	
	public boolean isTextPresent(String text) {
		return driver.getPageSource().contains(text);
	}
	
	public void quit() {
		driver.quit();
	}

}
