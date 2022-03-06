package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyFlight extends BasePage {
    WebDriver driver;
    @FindBy(css = "#cookie_consent > div > div > div > div > button > div > div > svg")
    WebElement acceptCookies;
    @FindBy(css = "#react-view > div.MainViewstyled__StyledMainView-fe632n-0.ihuGoV.MainView > div.Reservation > div > div > main > div:nth-child(3) > div.StepControls__StepControlsWrapper-k1yvv0-0.dJFemE > div > button > div > div.ButtonPrimitiveContentChildren__StyledButtonPrimitiveContentChildren-sc-1m4y8u8-0.hqyuUV")
    WebElement continueButton;


    public VerifyFlight(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickAcceptCookies() throws InterruptedException {
        Thread.sleep(3000);
      //  clickElement(closeModal);
        clickElement(acceptCookies);
        clickElement(continueButton);
    }

}