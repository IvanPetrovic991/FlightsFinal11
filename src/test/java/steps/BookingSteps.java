package steps;

import excell_core.ExcelUtilities;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Reporter;
import pages.FlightsPage;
import pages.ContractDetails;
import pages.VerifyFlight;
import tests.BaseTest;

import java.io.IOException;
import java.util.Map;

public class BookingSteps extends BaseTest {

    String BROWSER = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("BROWSER");
    String WAIT = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("WAIT");
    String ENV = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("ENV");

    Map<String, String> data;
    String testDataPath = "src/test/test_data/";

    @Before
    public void setUp() throws Exception {
        setUPTest(BROWSER, Integer.parseInt(WAIT));
    }

    @After
    public void tearDown() throws IOException, InterruptedException {
        reportScreenshot("end", "screenshot on end or fail");
   //     quit();
    }

    @Given("I load test data from {string} {string} {string}")
    public void iLoadTestDataFrom(String fileName, String sheetName, String rowNum) throws IOException {
        ExcelUtilities excelUtilities = new ExcelUtilities();
        data = excelUtilities.getRowData(testDataPath + fileName + ".xlsx", sheetName, rowNum);
        System.out.println(data.get("Location"));
    }

    @Given("I navigate to Booking")
    public void iNavigateToBooking() throws Exception {
        startApplication(ENV);
    }

    @Then("I navigate to flights page")
    public void iNavigateToFlightsPage() throws InterruptedException {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.openFlightsPage();
    }


    @And("I select number of passengers")
    public void selectNumberOfPassengers() throws InterruptedException {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.addAdults();

    }

    @And("I add destination {string}")
    public void iAddDestination(String city) throws InterruptedException {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.addDestination(city);
    }

    @And("I add depart and return date {string} {string}")
    public void iAddDepartAndReturnDate(String departDate, String returnDate) throws InterruptedException {
       FlightsPage flightsPage = new FlightsPage(driver);
      flightsPage.selectDepartAndReturnDate(departDate,returnDate);
    }

    @And("I click search")
    public void iClickSearch() throws InterruptedException {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.clickSearch();
    }

    @And("I Select one-way flight")
    public void iSelectOneWayFlight() throws InterruptedException {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.selectOneWay();
    }


    @And("I select flight")
    public void iSelectFlight() throws InterruptedException {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.selectFlight();
    }


    @Then("I accept cookies")
    public void acceptCookies() throws InterruptedException {
       VerifyFlight verifyFlight = new VerifyFlight(driver);
       verifyFlight.clickAcceptCookies();


    }


    @Then("I enter contact details {string}")
    public void enterContactDetails(String nationality) throws InterruptedException {
        ContractDetails contractDetails = new ContractDetails(driver);
        contractDetails.enterEmail();
        contractDetails.enterPhone();
        contractDetails.enterName();
        contractDetails.enterLastName();
        contractDetails.selectNationality();
    }

    @Then("I select baggage")
    public void iSelectBaggage() throws InterruptedException {
        ContractDetails contractDetails = new ContractDetails(driver);
        contractDetails.selectNoBaggage();

    }

    @Then("I remove second traveler")
    public void iRemoveSecondTraveler() throws InterruptedException {
        ContractDetails contractDetails = new ContractDetails(driver);
        contractDetails.removeTraveler();
        contractDetails.noInsurance();
    }

    @Then("I click on Continue and finished test")
    public void iClickOnContinueAndFinishedTest() throws InterruptedException {
        ContractDetails contractDetails = new ContractDetails(driver);
        contractDetails.clickContinue();
    }




}












