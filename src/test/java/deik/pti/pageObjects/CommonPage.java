package deik.pti.pageObjects;

import deik.pti.factory.WebDriverFactory;
import org.openqa.selenium.support.PageFactory;

public class CommonPage {
    protected final WebDriverFactory factory;

    public CommonPage(final WebDriverFactory factory) {
        this.factory = factory;
        PageFactory.initElements(factory.getWebDriver(), this);
    }
}

