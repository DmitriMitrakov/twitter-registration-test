package myTest;

import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import data.TestUser;
import pages.TwitterMainPage;
import pages.TwitterRedirectionPage;
import pages.TwitterSingupPage;

public class TwitterRegistrationTest {
		
	static final int TIMEOUT = 10;
	
	private TestUser testUser; 
	private TwitterMainPage mainPage;

	@Before
	public void setUp() throws Exception {		
//		System.setProperty("webdriver.chrome.driver", "path_to_chromedriver.exe");
//		driver = new ChromeDriver();
		
		testUser = new TestUser("John Doe", "passw0rd", "john.doe@email.me");
		
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts()
				.implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
		
		mainPage = new TwitterMainPage(driver);
	}

	@Test
	public void testTwitterRegistration() throws Exception {
		
		mainPage.open();
		
		mainPage.enterName(testUser.getName());
		mainPage.enterEmail(testUser.getEmail());
		mainPage.enterPassword(testUser.getPassword());		
		TwitterSingupPage singupPage = mainPage.submitRegistrationForm();		
		
		assertTrue("Singup page isn't loaded", singupPage.isPageLoaded());
		
		assertEquals(testUser.getName(), singupPage.getUserName());;				
		assertEquals(testUser.getEmail(), singupPage.getUserEmail());
		
		singupPage.enterUserEmail("111111");		
		assertTrue("Expected error hint: " + TwitterSingupPage.WRONG_EMAIL_HINT, 
				singupPage.isTextPresent(TwitterSingupPage.WRONG_EMAIL_HINT));		
		
		singupPage.enterUserEmail(testUser.getEmail());	
		
		final String recommendedLogin = singupPage.getFirstRecommendedLogin();
		singupPage.setFirstRecommendedLogin();
		assertEquals(recommendedLogin, singupPage.getUserLogin());
		
		TwitterRedirectionPage redirectionPage = singupPage.submitSignupForm();
		assertTrue("Redirection failed", redirectionPage.redirectOk());	
	}

	@After
	public void tearDown() throws Exception {
		mainPage.quit();
	}

}