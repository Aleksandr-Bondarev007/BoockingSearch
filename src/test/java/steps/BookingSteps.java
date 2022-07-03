package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.ResultPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsIterableContaining.hasItem;

public class BookingSteps {

    private static final String BOOKING_URL = "https://www.booking.com/searchresults.en-gb.html";
    private MainPage mainPage;
    private WebDriver driver;
    private ResultPage resultPage;
    private String searchItem;

    @Before
    public void init() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Given("User on the search page")
    public void userOnTheSearchPage(){
        driver.get(BOOKING_URL);
    }

    @When("User search {string}")
    public void userSearch(String keyword) {
        mainPage = new MainPage(driver);
        searchItem = keyword;
        resultPage = new ResultPage(driver);
        mainPage.searchByKeyword(searchItem);
    }

    @Then("{string} on the search page")
    public void onTheSearchPage(String result) {
        assertThat(String.format("Penzion Horajda \\n Opens in new window", result),
                resultPage.getResultLinks(),
                hasItem(result));
    }

    @Then("Rating is {string} on this hotel")
    public void ratingIsOnThisHotel(String scored) {
        assertThat(String.format("8.9", scored),
                resultPage.getScored(),
                hasItem(scored));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
