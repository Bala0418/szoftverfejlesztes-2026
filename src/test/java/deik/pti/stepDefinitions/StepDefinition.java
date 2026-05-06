package deik.pti.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import deik.pti.factory.WebDriverFactory;
import deik.pti.pageObjects.HomePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

public class StepDefinition {
    @Autowired
    private WebDriverFactory factory;

    @Autowired
    private HomePage homePage;

    @Given("the Home page is opened")
    public void theHomePageIsOpened() {
        factory.getWebDriver().get(homePage.getHomePageUrl());
    }

    @Then("a {string} gomb látható")
    public void gombLathatosag(final String text) {
        Assert.assertTrue("Expected URL to contain: " + text, homePage.currentUrlContains(text));
    }

    @When("the Communities button is clicked")
    public void theCommunitiesButtonIsClicked() {
        WebDriver driver = factory.getWebDriver();
        // Communities link in the navigation menu
        WebElement communitiesLink = driver.findElement(By.xpath("//a[@href='/communities']"));
        communitiesLink.click();
    }

    @Then("the {string} title is visible")
    public void theTitleIsVisible(final String titleText) {
        WebDriver driver = factory.getWebDriver();
        // Look for h1 with the Communities title
        WebElement titleElement = driver.findElement(By.xpath("//h1[contains(text(), '" + titleText + "')]"));
        Assert.assertTrue("Title '" + titleText + "' is not visible", titleElement.isDisplayed());
    }

    @Then("the events are visible")
    public void theEventsAreVisible() {
        WebDriver driver = factory.getWebDriver();
        // Look for the "All communities" section header which indicates events are loaded
        WebElement eventsSection = driver.findElement(By.xpath("//h3[contains(text(), 'All communities')]"));
        Assert.assertTrue("Events section is not visible", eventsSection.isDisplayed());
    }

    @Then("the title of the first event is {string}")
    public void theTitleOfTheFirstEventIs(final String expectedTitle) {
        WebDriver driver = factory.getWebDriver();
        // Find the first community card title
        WebElement firstEventTitle = driver.findElement(By.xpath("//div[@class='evnt-community-card']//h2//span[1]"));
        String actualTitle = firstEventTitle.getText();
        Assert.assertEquals("First event title does not match", expectedTitle, actualTitle);
    }

    @Then("the search input is visible")
    public void theSearchInputIsVisible() {
        WebDriver driver = factory.getWebDriver();
        // Find the search input by placeholder text
        WebElement searchInput = driver.findElement(By.xpath("//input[@placeholder='Search by Title or Tags']"));
        Assert.assertTrue("Search input is not visible", searchInput.isDisplayed());
    }

    @When("I enter {string} into the search input")
    public void iEnterIntoTheSearchInput(final String searchText) {
        WebDriver driver = factory.getWebDriver();
        // Find and interact with the search input
        WebElement searchInput = driver.findElement(By.xpath("//input[@placeholder='Search by Title or Tags']"));
        searchInput.clear();
        searchInput.sendKeys(searchText);
        // Simulate pressing Enter or waiting for results
        try {
            Thread.sleep(2000); // Wait for search results to load
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Then("I should see {string} in the search results")
    public void iShouldSeeInTheSearchResults(final String searchResultText) {
        WebDriver driver = factory.getWebDriver();
        // Look for the search result text in community cards
        WebElement resultElement = driver.findElement(By.xpath("//h2//span[contains(text(), '" + searchResultText + "')]"));
        Assert.assertTrue("Search result '" + searchResultText + "' is not visible", resultElement.isDisplayed());
    }

    @Then("the number of search results should be {int}")
    public void theNumberOfSearchResultsShouldBe(final int expectedCount) {
        WebDriver driver = factory.getWebDriver();
        // Find all community cards visible in the results
        java.util.List<WebElement> communityCards = driver.findElements(By.xpath("//div[@class='evnt-community-card' and not(contains(@class, 'banner'))]"));
        Assert.assertEquals("Number of search results does not match", expectedCount, communityCards.size());
    }

}
