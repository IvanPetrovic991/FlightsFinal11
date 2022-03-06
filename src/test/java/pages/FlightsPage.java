package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import selenium_core.DriverManager;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class FlightsPage extends BasePage {
    WebDriver driver;
    @FindBy(xpath = "//a[@data-decider-header='flights']")
    WebElement flights;
    @FindBy(xpath = "/html/body/div[6]/div/div[2]/div[1]/div[1]/div/div/div[1]/div[1]/div/div[2]/div[1]")
    WebElement departInput;
    @FindBy(xpath = "/html/body/div[6]/div/div[2]/div[1]/div[1]/div/div/div[1]/div[3]/div[1]/div/div[2]/div[1]")
    WebElement returnInput;
    @FindBy(xpath = "//div[contains(text(), 'adult')]")
    WebElement clickAddAdult;
    @FindBy(xpath = "/html/body/div[35]/div[2]/div/div/div[1]/div/div[2]/div/div/div[3]/button/span")
    WebElement addAdult;
    @FindBy(xpath = "/html/body/div[1]/div[1]/main/div[1]/div[1]/div/div[1]/div/div[2]/section[1]/div/h1")
    WebElement background;
    @FindBy(xpath = "/html/body/div[1]/div[1]/main/div[1]/div[1]/div/div[1]/div/div[2]/section[2]/div/div/div[2]/form[1]/div[1]/div/div[1]/div/div[3]/div/div/div")
    WebElement clickToAddDestination;
    @FindBy(xpath = "/html/body/div[5]/div/div[2]/div[1]/div[1]/input")
    WebElement clickToTypeCity;
    @FindBy(xpath = "//div[contains(text(), 'Vienna, Austria')][2]")
    WebElement selectDestination;
    @FindBy(xpath = "//div[contains(text(), 'Depart')][1]")
    WebElement departButton;
    @FindBy(xpath = "//div[contains(text(), 'Return')][1]")
    WebElement flightType;
    @FindBy(xpath = "//li[contains(text(), 'One-way')]")
    WebElement selectOneWay;
    @FindBy(xpath = "/html/body/div[1]/div[1]/main/div[1]/div[1]/div/div[1]/div/div[2]/section[2]/div/div/div[2]/form[1]/div[1]/div/div[2]/button")
    WebElement clickSearchButton;
    @FindBy (xpath = "/html/body/div[1]/div[1]/main/div/div[2]/div[2]/div/div[2]/div[1]/div[2]/div[4]/div[3]/div[1]/div/div[1]/div/div/div/div/div[1]/div/div[2]/div/div[2]/div[1]/div/div[2]/div[2]/div/div/div")
    WebElement seeFlightButton;
    @FindBy (xpath = "/html/body/div[1]/div[1]/main/div/div[2]/div[1]/div/div[1]/div/form/div[1]/div[2]/div")
    WebElement searchButton;

    public FlightsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openFlightsPage() throws InterruptedException {
        clickElement(flights);
    }

    public void addAdults() throws InterruptedException {
        clickElement(clickAddAdult);
        clickElement(addAdult);
        clickElement(background);
    }

    public void addDestination(String city) throws InterruptedException {
        clickElement(clickToAddDestination);
        inputElement(clickToTypeCity, city);
        clickElement(selectDestination);
    }

    public void selectDepartAndReturnDate(String departDate, String returnDate) throws InterruptedException {
        clickElement(departButton);

        inputDate(departInput,departDate);
        Thread.sleep(2000);

        inputDate(returnInput,returnDate);
        Thread.sleep(2000);
    }

    public void selectOneWay() throws InterruptedException{
        clickElement(flightType);
        Thread.sleep(1000);
        clickElement(selectOneWay);
        Thread.sleep(1000);
        clickElement(searchButton);

    }


    public void clickSearch() throws InterruptedException {
        clickElement(clickSearchButton);
        Thread.sleep(3000);
    }


    public void selectFlight() throws InterruptedException {
        Thread.sleep(10000);
        clickElement(seeFlightButton);
    }






}

