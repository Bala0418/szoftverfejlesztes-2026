package deik.pti.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import deik.pti.factory.WebDriverFactory;
import deik.pti.pageObjects.HomePage;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;
import static org.springframework.util.ClassUtils.isVisible;

public class stepDefinition {
    @Autowired
    private WebDriverFactory factory;

    @Autowired
    private HomePage homePage;

    @Given("the Home page is opened")
    public void theHomePageIsOpened() {
        factory.getWebDriver().get("https://wearecommunity.io/");
    }

    @Then("a {string} gomb látható")
    public void gombLathatosag(WebElement gomb) {
        isVisible(gomb);
    }
}