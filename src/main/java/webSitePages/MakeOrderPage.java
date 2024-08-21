package webSitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MakeOrderPage {
    private WebDriver driver;
    private By nameField = By.xpath("//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Имя']");
    private By surnameField = By.xpath("//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Фамилия']");
    private By addressField = By.xpath("//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Адрес: куда привезти заказ']");
    private By metroStationSelector = By.className("select-search__input");
    private By metroStationOption = By.xpath("//li[@role='menuitem']/button");
    private By phoneField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By continueButton = By.xpath(".//button[text()='Далее']");
    private By deliveryDateInput = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private By calendarDate = By.xpath(".//div[contains(@class, 'react-datepicker__day--today')]");
    private By rentPeriodFiled = By.xpath(".//div[@class='Dropdown-placeholder']");
    private By rentOptionDays = By.xpath(".//div[@class='Dropdown-option'][1]");
    private By blackColorCheckBox = By.xpath(".//label[@class='Checkbox_Label__3wxSf'][1]");
    private By commentFiled = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
    private By confirmOrderButton = By.xpath(".//button[contains(@class, 'Button_Middle__1CSJM') and text()='Да']");
    private By orderResult = By.xpath("//div[text()='Заказ оформлен']");
    private By orderStatusButton = By.xpath("//button[text()='Посмотреть статус']");

    public MakeOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //метод к-ый заполняет поля ИМЯ, ФАМИЛИЯ, АДРЕС, ТЕЛЕФОН
    public void setUserInfo(String userName, String userSurname, String userAddress, String phoneNumber) {
        driver.findElement(nameField).sendKeys(userName);
        driver.findElement(surnameField).sendKeys(userSurname);
        driver.findElement(addressField).sendKeys(userAddress);
        driver.findElement(phoneField).sendKeys(phoneNumber);
    }

    //метод к-ый заполняет поле СТАНЦИЯ МЕТРО
    public void setMetroStation(String userMetroStation) {
        driver.findElement(metroStationSelector).click();
        driver.findElement(metroStationSelector).sendKeys(userMetroStation);
        driver.findElement(metroStationOption).click();
    }
    //клик кнопка ДАЛЕЕ
    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }


    //метод для заполнения поля КОГДА ПРИВЕЗТИ САМОКАТ
    public void setDeliveryDateInput() {
        driver.findElement(deliveryDateInput).click();
        driver.findElement(calendarDate).click();
    }

    //метод для заполнения поля СРОК АРЕНДЫ
    public void setRentPeriodFiled() {
        driver.findElement(rentPeriodFiled).click();
        driver.findElement(rentOptionDays).click();
    }

    //проставить чекбокс ЦВЕТ САМОКАТА(черный)
    public void selectBlackColor() {
        driver.findElement(blackColorCheckBox).click();
    }

    //метод для заполнения поля КОММЕНТАРИЙ ДЛЯ КУРЬЕРА
    public void setCommentFiled(String comment) {
        driver.findElement(commentFiled).sendKeys(comment);
    }

    //метод для оформления заказа
    public void completeOrder() {
        driver.findElement(orderButton).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(confirmOrderButton));
        driver.findElement(confirmOrderButton).click();
    }
    public boolean checkOrderStatus(){
      return driver.findElement(orderResult).isDisplayed();
    }

}
