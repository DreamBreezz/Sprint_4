package samokat.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import samokat.EnvConfig;

import java.time.Duration;

public class MainPage {
    private final WebDriver driver;

    // кнопка принятия куки
    private final By cookieButton = By.id("rcc-confirm-button");

    // кнопка "Заказать" верхняя и нижняя
    public static final By orderButtonTop = By.
            xpath(".//div[starts-with(@class,'Header_Nav')]//button[text()='Заказать']");
    public static final By orderButtonBottom = By.
            xpath(".//div[contains(@class,'FinishButton')]//button[text()='Заказать']");


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // открытие страницы
    public MainPage openPage() {
        driver.get(EnvConfig.SAMOKAT_URL);
        return this;
    }

    // закрытие плашки куки
    public MainPage acceptCookies() {
        waitForCookiesFloater();
        driver.findElement(cookieButton).click();
        waitForCookiesFloaterToDisappear();
        return this;
    }

    // ожидание появления плашки куки
    private void waitForCookiesFloater() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(cookieButton));
    }

    // ожидание исчезания плашки куки
    private void waitForCookiesFloaterToDisappear() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.invisibilityOfElementLocated(cookieButton));
    }

    // прокрутка к кнопке "Заказать"
    public MainPage scrollToOrderButton(By orderButtonVar) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",
                driver.findElement(orderButtonVar));
        return this;
    }
    // ожидание появления кнопки заказать
    public MainPage waitForOrderButton(By orderButton) {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(orderButton));
        return this;
    }

    // нажатие на кнопку "Заказать"
    public MainPage clickOnOrderButton(By orderButton) {
        driver.findElement(orderButton).click();
        return this;
    }

}
