package webSitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainMenu {
    private WebDriver driver;
    private By makeOrderButtonTop = By.xpath("//button[text()='Заказать']");
    private By makeOrderButtonMiddle = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private By cookieButton = By.className("App_CookieButton__3cvqF");

    public MainMenu(WebDriver driver) {
        this.driver = driver;
    }

//метод выбора входной точки в сценарий Заказать
    public void clickMakeOrderButton(boolean isTopMenuButton) {
        if (isTopMenuButton) {
            driver.findElement(makeOrderButtonTop).click();
        } else {
            driver.findElement(makeOrderButtonMiddle).click();
        }
    }
//метод принять куки
    public void acceptCookie() {
        driver.findElement(cookieButton).click();
    }


}
