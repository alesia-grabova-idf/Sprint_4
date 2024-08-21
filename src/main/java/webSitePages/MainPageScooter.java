package webSitePages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPageScooter {
    private WebDriver driver;
    public MainPageScooter (WebDriver driver) {
        this.driver = driver;
    }

    private By getXpathLocatorByText (String headerText) {
        return By.xpath(String.format("//*[text()='%s']", headerText));
    }
//метод клика на текст
    public void clickOnHeaderByText(String text) {
        driver.findElement(getXpathLocatorByText(text)).click();
    }
//метод провеки что текст соответсвует
    public Boolean checkAccordionIsDisplayedByText(String text) {
        return driver.findElement(getXpathLocatorByText(text)).isDisplayed();
    }
}
