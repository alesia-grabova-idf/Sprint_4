package mainPage;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertEquals;
import browser.BrowserSetup;
import webSitePages.MainPageScooter;
import webSitePages.MainMenu;

@RunWith(Parameterized.class) // добавили раннер Parameterized
public class MainPageScooterAccordionTest {
    private WebDriver driver;
    private final String headerText;
    private final String accordionText;
    private MainPageScooter mainPageScooter;
    private MainMenu mainMenu;

    public MainPageScooterAccordionTest(String headerText, String accordionText) {
        this.headerText = headerText;
        this.accordionText = accordionText;
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][]{
                {"Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {"Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {"Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {"Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {"Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {"Я жизу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
                {"Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."}
        };
    }

    @Before
    public void startUp() {
        BrowserSetup browserSetup = new BrowserSetup();
        driver = browserSetup.setup();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        mainPageScooter = new MainPageScooter(driver);
        mainMenu = new MainMenu(driver);

    }

    @Test
    public void openMainPage() throws Exception {
        mainMenu.acceptCookie();
        mainPageScooter.clickOnHeaderByText(headerText);
        Thread.sleep(1000);
        boolean result = mainPageScooter.checkAccordionIsDisplayedByText(accordionText);
        assertEquals(String.format("Открылся неверный ответ на вопрос '%s'", headerText), true, result);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
