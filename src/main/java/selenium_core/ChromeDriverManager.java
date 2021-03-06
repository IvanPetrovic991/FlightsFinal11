package selenium_core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager{
    @Override
    public void createWebDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver99");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        this.driver = new ChromeDriver(options);
    }
}
