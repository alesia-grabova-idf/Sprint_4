package orderTest;

import browser.BrowserSetup;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webSitePages.MakeOrderPage;
import webSitePages.MainMenu;


import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class OrderScooterTest {
    private WebDriver driver;
    private MainMenu mainMenu;
    private MakeOrderPage makeOrderPage;
    private boolean isTopMenuButton;
    private String name;
    private String surname;
    private String address;
    private String phoneNumber;
    private String metro;
    private String comment;


    public OrderScooterTest(boolean isTopMenuButton, String name, String surname, String address, String phoneNumber, String metro, String comment) {
        this.isTopMenuButton = isTopMenuButton;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.metro = metro;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][]{
                {true, "Алеся", "Тест", "Грушевка 5", "12345678911", "Тульская", "код от домофона 123"},
                {false, "Толик", "Авто", "Михалово 5", "66345678988", "Тульская", "домофон не работает"},
        };
    }

    @Before
    public void startUp() {
        BrowserSetup browserSetup = new BrowserSetup();
        driver = browserSetup.setup();
        mainMenu = new MainMenu(driver);
        makeOrderPage = new MakeOrderPage(driver);
        driver.get("https://qa-scooter.praktikum-services.ru/");
 //       driver.findElement(By.className("App_CookieButton__3cvqF")).click();
    }

    @Test
    public void openMainPage() throws Exception {
        mainMenu.acceptCookie();
        mainMenu.clickMakeOrderButton(isTopMenuButton);
        makeOrderPage.setUserInfo(name, surname, address, phoneNumber);
        makeOrderPage.setMetroStation(metro);
        makeOrderPage.clickContinueButton();
        Thread.sleep(1000);
        makeOrderPage.setDeliveryDateInput();
        makeOrderPage.setRentPeriodFiled();
        makeOrderPage.selectBlackColor();
        makeOrderPage.setCommentFiled(comment);
        makeOrderPage.completeOrder();
        assertEquals("Не получилось оформить заказ", true, makeOrderPage.checkOrderStatus());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
