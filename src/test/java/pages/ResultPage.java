package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class ResultPage extends BasePage{
    @FindBy(xpath = "//div[@data-testid='title']")
    private List<WebElement> resultsLinks;

    @FindBy(xpath = "//div[@class='b5cd09854e d10a6220b4']")
    private List<WebElement> scoredHotel;


    public ResultPage(WebDriver driver) {
        super(driver);
    }
    public List<String> getResultLinks() {
        return resultsLinks.stream().map(result->result.getAttribute("innerText"))
                .filter(result-> !result.isEmpty()).collect(Collectors.toList());
    }
    public List<String> getScored() {
        return scoredHotel.stream().map(result->result.getAttribute("innerText"))
                .filter(result-> !result.isEmpty()).collect(Collectors.toList());
    }

}
