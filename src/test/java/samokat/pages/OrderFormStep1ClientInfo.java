package samokat.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import samokat.EnvConfig;

import java.time.Duration;

public class OrderFormStep1ClientInfo {
    private final WebDriver driver;

    // Заголовок "Для кого самокат"
    private final By pageHeader = By.xpath(".//div[text()='Для кого самокат']");

    // поле ввода имени
    private final By inputFirstName = By.xpath(".//input[@placeholder='* Имя']");

    // поле ввода фамилии
    private final By inputLastName = By.xpath(".//input[@placeholder='* Фамилия']");

    // поле ввода адреса
    private final By inputAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    // поле выбора станции метро (выпадающий список)
    private final By selectorMetroStation = By.xpath(".//input[@placeholder='* Станция метро']");

    // станция метро в выпадающем списке
    public static final By selectMetroStationSokolniki = By.xpath(".//div[text()='Сокольники']");
    public static final By selectMetroStationAnnino = By.xpath(".//div[text()='Аннино']");

    // поле ввода номера телефона
    private final By inputPhoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    // кнопка "Далее"
    private final By nextStepButton = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button[text()='Далее']");


    public OrderFormStep1ClientInfo(WebDriver driver) {
        this.driver = driver;
    }

    // ожидание загрузки страницы
    public OrderFormStep1ClientInfo waitForHeader() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(pageHeader));
        return this;
    }

    // заполнение страницы данными
    public OrderFormStep1ClientInfo fillInputsWithData(String firstName, String lastName, String address, By selectMetroStation, String phoneNumber) {
        clickFirstNameInput();
        inputFirstName(firstName);
        clickLastNameInput();
        inputLastName(lastName);
        clickAddressInput();
        inputAddress(address);
        clickMetroStationSelector();
        clickMetroStation(selectMetroStation);
        clickPhoneNumberInput();
        inputPhoneNumber(phoneNumber);
        return this;
    }

    // клик по полю ввода имени
    private OrderFormStep1ClientInfo clickFirstNameInput() {
        driver.findElement(inputFirstName).click();
        return this;
    }

    // ввод имени
    private OrderFormStep1ClientInfo inputFirstName(String firstName) {
        driver.findElement(inputFirstName).sendKeys(firstName);
        return this;
    }

    // клик по полю ввода фамилии
    private OrderFormStep1ClientInfo clickLastNameInput() {
        driver.findElement(inputLastName).click();
        return this;
    }

    // ввод фамилии
    private OrderFormStep1ClientInfo inputLastName(String lastName) {
        driver.findElement(inputLastName).sendKeys(lastName);
        return this;
    }

    // клик по полю ввода адреса
    private OrderFormStep1ClientInfo clickAddressInput() {
        driver.findElement(inputAddress).click();
        return this;
    }

    // ввод адреса
    private OrderFormStep1ClientInfo inputAddress(String address) {
        driver.findElement(inputAddress).sendKeys(address);
        return this;
    }

    // клик по полю выбора станции метро
    private OrderFormStep1ClientInfo clickMetroStationSelector() {
        driver.findElement(selectorMetroStation).click();
        return this;
    }

    // выбор станции метро
    private OrderFormStep1ClientInfo clickMetroStation(By selectMetroStation) {
        driver.findElement(selectMetroStation).click();
        return this;
    }

    // клик по полю ввода номера телефона
    private OrderFormStep1ClientInfo clickPhoneNumberInput() {
        driver.findElement(inputPhoneNumber).click();
        return this;
    }

    // ввод номера телефона
    private OrderFormStep1ClientInfo inputPhoneNumber(String phoneNumber) {
        driver.findElement(inputPhoneNumber).sendKeys(phoneNumber);
        return this;
    }

    // клик по кнопке "Далее"
    public OrderFormStep1ClientInfo clickNextStepButton() {
        driver.findElement(nextStepButton).click();
        return this;
    }
}
