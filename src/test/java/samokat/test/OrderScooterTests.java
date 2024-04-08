package samokat.test;

import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import samokat.DriverRule;
import samokat.pages.*;

@RunWith(Parameterized.class)
public class OrderScooterTests {
    public static By orderButton;
    private final String firstName;
    private final String lastName;
    private final String address;
    private static By selectMetroStation;
    private final String phoneNumber;
    private final String date;
    private static By orderPeriod;
    private final String scooterColor;
    private final String commentForCourier;

    @ClassRule
    public static DriverRule driverRule = new DriverRule();

    public OrderScooterTests(By orderButton, String firstName, String lastName, String address, By selectMetroStation,
                             String phoneNumber, String date, By orderPeriod, String scooterColor,
                             String commentForCourier) {
        this.orderButton = orderButton;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.selectMetroStation = selectMetroStation;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.orderPeriod = orderPeriod;
        this.scooterColor = scooterColor;
        this.commentForCourier = commentForCourier;
    }

    @BeforeClass
    // открыть страницу и принять куки
    public static void openPageAndAcceptCookies() {
        new MainPage(driverRule.getDriver())
                .openPage()
                .acceptCookies();
    }

    @Parameterized.Parameters
    public static Object[][] testData() {
        return new Object[][] {
                {MainPage.orderButtonTop,
                        "Александр",
                        "Смирнов",
                        "ул. Пушкина, д.1, кв.2",
                        OrderFormStep1ClientInfo.selectMetroStationAnnino,
                        "89991112233",
                        "21.12.2024",
                        OrderFormStep2AboutOrder.orderPeriodOneDay,
                        "black",
                        "Тестовый комментарий"},
                {MainPage.orderButtonBottom,
                        "Антонина",
                        "Елисеева",
                        "ул. Десептиконов, д.13",
                        OrderFormStep1ClientInfo.selectMetroStationSokolniki,
                        "89080080808",
                        "31.08.2024",
                        OrderFormStep2AboutOrder.orderPeriodThreeDays,
                        "grey",
                        "Ещё один тестовый комментарий"}
        };
    }


    @Test
    public void OrderScooter() {

        new MainPage(driverRule.getDriver())
                .scrollToOrderButton(orderButton)
                .waitForOrderButton(orderButton)
                .clickOnOrderButton(orderButton);
        new OrderFormStep1ClientInfo(driverRule.getDriver())
                .waitForHeader()
                .fillInputsWithData(firstName, lastName, address, selectMetroStation, phoneNumber)
                .clickNextStepButton();
        new OrderFormStep2AboutOrder(driverRule.getDriver())
                .waitForHeader()
                .fillInputsWithData(date, orderPeriod, scooterColor, commentForCourier)
                .clickOrderButton();
        new OrderFormStep3Popup(driverRule.getDriver())
                .waitForHeader()
                .clickYesButton();
        new OrderFormStep4PopupSuccess(driverRule.getDriver())
                .waitForHeader();
        // нужно, чтобы перейти из поп-апа снова на главную страницу
        // с кнопкой "Заказать" и повторить тест с другими параметрами
        new MainPage(driverRule.getDriver())
                .openPage();
    }
}