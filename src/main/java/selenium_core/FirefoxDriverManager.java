package selenium_core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager extends DriverManager{

    @Override
    public void createWebDriver() {
        WebDriverManager.firefoxdriver().setup();
        //System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("start-maximized");
        this.driver = new FirefoxDriver(options);
    }

}