package deik.pti.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {
    private static WebDriver webDriver;

    public WebDriver getWebDriver() {
        if (webDriver == null) {
            webDriver = setupWebDriver();
        }
        return webDriver;
    }

    public WebDriver getExistingWebDriver() {
        return webDriver;
    }

    private WebDriver setupWebDriver() {
        WebDriverManager.chromedriver().setup();
        var options = new ChromeOptions()
                .addArguments("--no-sandbox")
                .addArguments("--disable-dev-shm-usage")
                .addArguments("--start-maximized");

        if (Boolean.parseBoolean(System.getProperty("headless", "false"))) {
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
        }

        return new ChromeDriver(options);
    }

    public void closeWebDriver() {
        if (webDriver != null) {
            webDriver.close();
            webDriver.quit();
            webDriver = null;
        }
    }
}

