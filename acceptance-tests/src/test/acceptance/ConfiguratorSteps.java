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

public class ConfiguratorSteps {

    public static WebDriver driver;

    @Before
    public void beforeScenario() {
        System.setProperty("webdriver.chrome.driver","/Library/Java/JUNIT/chromedriver");
        driver = new ChromeDriver();
        // Seems no more working in last Chrome versions
        // driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Given("^je suis sur le configurateur$")
    public void je_suis_sur_le_configurateur() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://www.tesla.com/fr_fr/models");
    }

    @Then("^le lien du bouton commander doit être \"([^\"]*)\"$")
    public void le_lien_du_bouton_commander_doit_être(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(driver.findElement(By.cssSelector("#tesla-hero-showcase-6920 .hero-regions--wrapper .hero-regions .hero-region--center .hero-region--center-bottom .hero-callouts .callout a")).getAttribute("href"), arg1);

    }

    @Given("^je suis dans la partie design du configurateur$")
    public void je_suis_dans_la_partie_design_du_configurateur() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://www.tesla.com/fr_fr/models/design");
    }

    @Then("^le prix affiché par défaut est \"([^\"]*)\" et \"([^\"]*)\"$")
    public void le_prix_affiché_par_défaut_est_et(String arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(driver.findElement(By.cssSelector("#footer .tds-flex .tds-flex .footer-action-block .modal-trigger .tds-flex-item .tds-flex-item .tds-flex")).getText().contains(arg1));
        assertTrue(driver.findElement(By.cssSelector("#footer .tds-flex .tds-flex .footer-action-block .modal-trigger .tds-flex-item .tds-flex-item .tds-flex")).getText().contains(arg2));
    }






    @After
    public void afterScenario() {
        driver.quit();
    }
}
