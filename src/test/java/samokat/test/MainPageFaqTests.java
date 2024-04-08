package samokat.test;

import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import samokat.DriverRule;
import samokat.pages.MainPage;
import samokat.pages.MainPageFaq;

import static samokat.constants.MainPageFaqConstants.*;

@RunWith(Parameterized.class)
public class MainPageFaqTests {
    private final String itemId;
    private final String questionExpectedText;
    private final String answerExpectedText;

    @ClassRule
    public static DriverRule driverRule = new DriverRule();


    public MainPageFaqTests(String itemId, String questionExpectedText, String answerExpectedText) {
        this.itemId = itemId;
        this.questionExpectedText = questionExpectedText;
        this.answerExpectedText = answerExpectedText;
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
    public static Object[][] faqIdsQuestionsAnswers() {
        return new Object[][]{
                {ID_0, QUESTION_0_TXT, ANSWER_0_TXT},
                {ID_1, QUESTION_1_TXT, ANSWER_1_TXT},
                {ID_2, QUESTION_2_TXT, ANSWER_2_TXT},
                {ID_3, QUESTION_3_TXT, ANSWER_3_TXT},
                {ID_4, QUESTION_4_TXT, ANSWER_4_TXT},
                {ID_5, QUESTION_5_TXT, ANSWER_5_TXT},
                {ID_6, QUESTION_6_TXT, ANSWER_6_TXT},
                {ID_7, QUESTION_7_TXT, ANSWER_7_TXT}
        };
    }

    @Test
    public void clickOnFaq() {
        new MainPageFaq(driverRule.getDriver())
                .checkAnswerIsInvisible(itemId)
                .compareQuestionText(itemId, questionExpectedText)
                .clickOnQuestion(itemId)
                .waitForAnswer(itemId)
                .compareAnswerText(itemId, answerExpectedText);
    }
}