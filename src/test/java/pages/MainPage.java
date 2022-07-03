package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{

    public MainPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@name='ss']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;

    public void searchByKeyword(String keyword){
        searchField.sendKeys(keyword);
        searchButton.click();
    }
}
