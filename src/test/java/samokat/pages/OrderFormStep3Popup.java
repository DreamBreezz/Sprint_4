package samokat.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import samokat.EnvConfig;

import java.time.Duration;

public class OrderFormStep3Popup {
    private final WebDriver driver;

    // заголовок "Хотите оформить заказ?"
    private final By pageHeader = By.xpath(".//div[text()='Хотите оформить заказ?']");

    // кнопка "Да"
    private final By yesButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");

    public OrderFormStep3Popup(WebDriver driver) {
        this.driver = driver;
    }

    // ожидание появления поп-апа
    public OrderFormStep3Popup waitForHeader() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(pageHeader));
        return this;
    }

    // клик по кнопке "Да"
    public OrderFormStep3Popup clickYesButton() {
        driver.findElement(yesButton).click();
        return this;
    }
}
