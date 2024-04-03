package samokat.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import samokat.EnvConfig;

import java.time.Duration;

public class OrderFormStep2AboutOrder {
    private final WebDriver driver;

    // заголовок "Про аренду"
    private final By pageHeader = By.xpath(".//div[text()='Про аренду']");

    // поле ввода даты, вызова календаря
    private final By inputDeliveryTime = By.xpath(".//input[@placeholder='* Когда привезти самокат']");

    // поле выбора срока аренды (выпадающий список)
    private final By selectorOrderPeriod = By.xpath(".//div[text()='* Срок аренды']");

    // выбор срока аренды из выпадающего списка
    public static final By orderPeriodOneDay = By.xpath(".//div[text()='сутки']");
    public static final By orderPeriodThreeDays = By.xpath(".//div[text()='трое суток']");

    // ввод комментария для курьера
    private final By inputCommentForCourier = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    // кнопка "Заказать"
    private final By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");


    public OrderFormStep2AboutOrder(WebDriver driver) {
        this.driver = driver;
    }

    // ожидание загрузки страницы
    public OrderFormStep2AboutOrder waitForHeader() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(pageHeader));
        return this;
    }

    // заполнение полей страницы данными
    public OrderFormStep2AboutOrder fillInputsWithData(String date, By orderPeriod,
                                                       String scooterColor, String commentForCourier) {
        clickDeliveryTimeInput();
        inputDeliveryTime(date);
        clickHeader();
        clickOrderPeriodSelector();
        clickOrderPeriod(orderPeriod);
        clickScooterColorCheckbox(scooterColor);
        clickCommentForCourierInput();
        inputCommentForCourier(commentForCourier);
        return this;
    }

    // клик по полю ввода даты
    private OrderFormStep2AboutOrder clickDeliveryTimeInput() {
        driver.findElement(inputDeliveryTime).click();
        return this;
    }

    // ввод даты
    private OrderFormStep2AboutOrder inputDeliveryTime(String date) {
        driver.findElement(inputDeliveryTime).sendKeys(date);
        return this;
    }

    // клик по заголовку (чтобы спрятался выпадающий календарь)
    private OrderFormStep2AboutOrder clickHeader() {
        driver.findElement(pageHeader).click();
        return this;
    }

    // клик по полю выбора срока аренды
    private OrderFormStep2AboutOrder clickOrderPeriodSelector() {
        driver.findElement(selectorOrderPeriod).click();
        return this;
    }

    // выбор срока аренды
    private OrderFormStep2AboutOrder clickOrderPeriod(By orderPeriod) {
        driver.findElement(orderPeriod).click();
        return this;
    }

    // клик по цвету самоката
    private OrderFormStep2AboutOrder clickScooterColorCheckbox(String scooterColor) {
        driver.findElement(By.id(scooterColor)).click();
        return this;
    }

    // клик по полю комментария для курьера
    private OrderFormStep2AboutOrder clickCommentForCourierInput() {
        driver.findElement(inputCommentForCourier).click();
        return this;
    }

    // ввод комментария для курьера
    private OrderFormStep2AboutOrder inputCommentForCourier(String commentForCourier) {
        driver.findElement(inputCommentForCourier).sendKeys(commentForCourier);
        return this;
    }

    // клик по кнопке "Заказать"
    public OrderFormStep2AboutOrder clickOrderButton() {
        driver.findElement(orderButton).click();
        return this;
    }
}
