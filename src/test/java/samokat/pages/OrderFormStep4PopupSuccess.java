package samokat.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import samokat.EnvConfig;

import java.time.Duration;

public class OrderFormStep4PopupSuccess {
    private final WebDriver driver;

    // заголовок "Заказ оформлен"
    private final By pageHeader = By.xpath(".//div[text()='Заказ оформлен']");

    public OrderFormStep4PopupSuccess(WebDriver driver) {
        this.driver = driver;
    }

    // ожидание появления заголовка "Заказ оформлен"
    public void waitForHeader() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(pageHeader));
    }
}
