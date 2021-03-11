package test.functional;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;


public class FunctionalTest {

	private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","/Library/Java/JUNIT/chromedriver");
		driver = new ChromeDriver();
	    	// Seems no more working in last Chrome versions
		// driver.manage().window().maximize();
  		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
     }

    // Test de la Story #1-homepage (https://trello.com/c/WKTneu9o/1-homepage)
	@Test
    public void testHomepage() throws Exception {
        driver.get("https://www.meetup.com/fr-FR/");
		assertEquals(driver.getTitle(), "Partagez vos passions | Meetup");
		// TODO
		// To Be Completed By Coders From Coding Factory
        assertTrue(driver.findElement(By.cssSelector("meta[name=description]")).getAttribute("content").contains("Partagez vos passions et faites bouger votre ville"));
        assertEquals(driver.findElement(By.cssSelector("h1>span")).getText(), "Le monde vous tend les bras");
        assertEquals(driver.findElement(By.cssSelector(".exploreHome-hero-subTitle span")).getText(), "Rejoignez un groupe local pour rencontrer du monde, tester une nouvelle activité ou partager vos passions.");
        assertEquals(driver.findElement(By.cssSelector("#joinMeetupButton span")).getText(), "Rejoindre Meetup");
        Color colorbutton = Color.fromString(driver.findElement(By.id("joinMeetupButton")).getCssValue("color"));
        assert colorbutton.asHex().equals("#ffffff");
        assertEquals(driver.findElement(By.cssSelector("#joinMeetupButton")).getAttribute("href"), "https://www.meetup.com/fr-FR/register/");
    }

    @Test
    public void testRecherche() throws Exception {
        driver.get("https://www.meetup.com/fr-FR/find/outdoors-adventure/");
        assertTrue(driver.getTitle().contains("Nature et aventure"));
        assertTrue(driver.findElement(By.cssSelector(".text--display1")).getText().contains("Nature et aventure"));
        assertNotNull(driver.findElement(By.cssSelector(".dropdown")));
        assertNotNull(driver.findElement(By.cssSelector(".dropdown")));


    // Test de la Story n ...
    // TODO
    // To Be Completed By Coders From Coding Factory

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}
