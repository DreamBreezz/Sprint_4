package samokat.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import samokat.EnvConfig;
import java.time.Duration;
import static org.junit.Assert.assertEquals;

public class MainPageFaq {

    private final WebDriver driver;

    // вопрос в FAQ
    private final String questionIdPrefix = "accordion__heading-";

    // ответ в FAQ
    private final String answerIdPrefix = "accordion__panel-";


    // создание драйвера браузера для теста
    public MainPageFaq(WebDriver driver) {
        this.driver = driver;
    }


    // клик по блоку вопроса
    public MainPageFaq clickOnQuestion(String id) {
        driver.findElement(By.id(questionIdPrefix + id)).click();
        return this;
    }

    // получение текста вопроса
    public String getActualQuestionText(String id) {
        return driver.findElement(By.id(questionIdPrefix + id)).getText();
    }

    // сравнение ожидаемого текста вопоса и фактического:
    public MainPageFaq compareQuestionText(String itemId, String questionsExpectedText) {
        assertEquals("Некорректный текст вопроса в элементе с id="+itemId,
                questionsExpectedText, getActualQuestionText(itemId));
        return this;
    }

    // ожидание появления ответа
    public MainPageFaq waitForAnswer(String id) {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(answerIdPrefix + id)));
        return this;
    }

    // проверка, что ответ виден
    public MainPageFaq checkAnswerIsInvisible(String id) {
        assert !driver.findElement(By.id(answerIdPrefix + id)).isDisplayed();
        return this;
    }

    // получение текста ответа
    public String getActualAnswerText(String id) {
        return driver.findElement(By.id(answerIdPrefix + id)).getText();
    }

    // сравнение ожидаемого текста ответа и фактического
    public MainPageFaq compareAnswerText(String itemId, String answersExpectedText) {
        assertEquals("Некорректный текст ответа в элементе с id="+itemId,
                answersExpectedText, getActualAnswerText(itemId));
        return this;
    }
}
