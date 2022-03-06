package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import steps.BookingSteps;

public class ContractDetails extends BasePage {

    WebDriver driver;
    @FindBy(xpath = "//*[@id='1-38']")
    WebElement emailInput;
    @FindBy(xpath = "//*[@id='1-41']")
    WebElement phoneInput;
    @FindBy(css = "div[data-testid='checkout_extras_inner_next']")
    WebElement nextBtn;
    @FindBy(xpath = "//*[@id='1-43']")
    WebElement nameInput;
    @FindBy(xpath = "//*[@id='1-44']")
    WebElement lastNameInput;
    @FindBy(xpath = "//*[@id='react-view']/div[2]/div[1]/div/div/main/form/div[3]/div/div[1]/div/div[2]/div/form/fieldset/div[2]/div[1]/div/div[1]/label/div/select")
    WebElement nationalitySelector;
    @FindBy(xpath = "//*[@id='react-view']/div[2]/div[1]/div/div/main/form/div[3]/div/div[1]/div/div[2]/div/form/fieldset/div[2]/div[1]/div/div[2]/label/div/select")
    WebElement genderSelector;
    @FindBy(xpath = "//*[@id='react-view']/div[2]/div[1]/div/div/main/form/div[3]/div/div[1]/div/div[2]/div/form/fieldset/div[2]/div[2]/div/div/div/div/div[2]/label/div/select")
    WebElement monthSelector;
    @FindBy(xpath = "//*[@id='1-47']")
    WebElement bornDate;
    @FindBy(xpath = "//*[@id='1-48']")
    WebElement bornYear;
    @FindBy(xpath = "//*[@id='react-view']/div[2]/div[1]/div/div/main/form/div[3]/div/div[1]/div/div[2]/div/form/div[1]/div[1]/div[3]/div[1]/div/div[1]/p")
    WebElement baggageSelect;
    @FindBy(xpath = "//*[@id='react-view']/div[2]/div[1]/div/div/main/form/div[3]/div/div[2]/div/div[2]/div/div[2]/div/button/div/div")
    WebElement removeTraveler;
    @FindBy(xpath = "//*[@id='react-view']/div[2]/div[1]/div/div/main/form/div[3]/div/div[1]/div/div[2]/div/form/div[3]/div[5]/div[1]/div/div[3]/div/label/div[1]")
    WebElement noInsurance;
    @FindBy(xpath = "//*[@id='react-view']/div[2]/div[1]/div/div/main/form/div[4]/div/button[2]/div/div[1]")
    WebElement continueButton;
    String nationality = "United Kingdom";
    String gender = "Male";
    String month = "March";
    String firstName = randomName(4);
    String lastName = randomName(6);
    String email = randomEmail(10);
    String phoneNumber = randomPhoneNumber(9);
    public ContractDetails(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterEmail() {
        inputElement(emailInput, email);
    }

    public void enterPhone(){
        inputElement(phoneInput,phoneNumber);
    }

    public void enterName(){
        inputElement(nameInput,firstName);
    }

    public void enterLastName(){
        inputElement(lastNameInput,lastName);
    }

    public void selectNoBaggage() throws InterruptedException {
        clickElement(baggageSelect);
    }


    public void selectNationality() throws InterruptedException {
        selectByValue(nationalitySelector,nationality);
        selectByValue(genderSelector,gender);
        inputElement(bornDate,"30");
        inputElement(bornYear,"1991");
        selectByValue(monthSelector,month);
    }

    public void removeTraveler() throws InterruptedException {
        clickElement(removeTraveler);

    }


    public void clickContinue() throws InterruptedException {
        clickElement(continueButton);
    }



    public void noInsurance() throws InterruptedException {
        clickElement(noInsurance);
    }
}

