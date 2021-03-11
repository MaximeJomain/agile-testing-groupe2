package test.acceptance;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;


import java.lang.*;

import org.junit.Test;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.*;

import static org.hamcrest.Matchers.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class HomepageSteps {

	public static WebDriver driver;

	@Before
	public void beforeScenario() {
		System.setProperty("webdriver.chrome.driver","/Library/Java/JUNIT/chromedriver");
		driver = new ChromeDriver();
		// Seems no more working in last Chrome versions
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Given("^je suis sur la homepage$")
	public void je_suis_sur_la_homepage() throws Throwable {
		driver.get("https://www.tesla.com/fr_FR/");
	}

	@Then("^le titre doit être \"([^\"]*)\"$")
	public void le_titre_doit_être(String arg1) throws Throwable {
		assertEquals(driver.getTitle(), arg1);
	}

	@Then("^la description contient \"([^\"]*)\"$")
	public void la_description_doit_être(String arg1) throws Throwable {
		// By CSS Selector
		assertTrue(driver.findElement(By.cssSelector("meta[name='description']")).getAttribute("content").contains(arg1));
		// By XPATH, si vous préférez...
	    // assertEquals(driver.findElement(By.xpath("//meta[@name='description']")).getAttribute("content"), arg1);
	}

	@Then("^La punchline (\\d+) est \"([^\"]*)\"$")
	public void la_punchline_est(int arg1, String arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		List<WebElement> h1list = driver.findElements(By.cssSelector("h1"));
		assertEquals(h1list.get(arg1+1).getAttribute("innerHTML"), arg2);
	}

	@Then("^Le lien (\\d+) à pour titre \"([^\"]*)\" et pour lien \"([^\"]*)\"$")
	public void le_lien_à_pour_titre_et_pour_lien(int arg1, String arg2, String arg3) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		List<WebElement> elementList = driver.findElements(By.cssSelector("#block-mainheadernavigation .tds-menu-header-nav--list .tds-menu-header-nav--list_item a"));
		assertEquals(elementList.get(arg1-1).getAttribute("innerHTML"), arg2);
		assertEquals(elementList.get(arg1-1).getAttribute("href"), arg3);
	}



	@After
	public void afterScenario() {
		driver.quit();
	}

}
