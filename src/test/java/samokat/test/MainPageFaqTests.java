package samokat.test;

import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import samokat.DriverRule;
import samokat.pages.MainPage;
import samokat.pages.MainPageFaq;

@RunWith(Parameterized.class)
public class MainPageFaqTests {
    private final String itemId;

    @ClassRule
    public static DriverRule driverRule = new DriverRule();

    public MainPageFaqTests(String itemId) {
        this.itemId = itemId;
    }

    @BeforeClass
    // открыть страницу и принять куки
    public static void openPageAndAcceptCookies() {
        new MainPage(driverRule.getDriver())
                .openPage()
                .acceptCookies();
    }

    @Parameterized.Parameters
    // массив для ID вопросов и ответов
    public static Object[][] faqIds() {
        return new Object[][]{
                {"0"},
                {"1"},
                {"2"},
                {"3"},
                {"4"},
                {"5"},
                {"6"},
                {"7"}
        };
    }

    @Test
    public void clickOnFaq() {
        new MainPageFaq(driverRule.getDriver())
                .checkAnswerIsInvisible(itemId)
                .clickOnQuestion(itemId)
                .waitForAnswer(itemId);
    }
}