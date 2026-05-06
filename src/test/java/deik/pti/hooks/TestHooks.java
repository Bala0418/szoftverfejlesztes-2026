package deik.pti.hooks;

import deik.pti.factory.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class TestHooks {
    @Autowired
    private WebDriverFactory factory;

    @After(order = 1)
    public void attachScreenshotOnFailure(final Scenario scenario) {
        if (!scenario.isFailed()) {
            return;
        }

        final WebDriver driver = factory.getExistingWebDriver();
        if (driver instanceof TakesScreenshot screenshotDriver) {
            final byte[] screenshot = screenshotDriver.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "failure-screenshot");
        }
    }

    @After(order = 0)
    public void tearDown() {
        factory.closeWebDriver();
    }
}

