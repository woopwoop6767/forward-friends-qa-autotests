package qa.front.friends.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.front.friends.logic.GenerateText;
import qa.front.friends.logic.api.SelfieUploader;
import qa.front.friends.logic.driver.DesktopDriver;
import qa.front.friends.logic.pages.*;

import static com.codeborne.selenide.Selenide.*;



public class test003LeasingProcedure implements DesktopDriver, SelfieUploader, GenerateText {

    private String mobilePhone;
    private AuthPage authPage;
    private MainPageNewOrder mainPageNewOrder;
    private ProductCardPage productCardPage;
    private OrderPage orderPage;

    @BeforeMethod
    void setUp() {
        mobilePhone = generateMobilePhone();
        authPage = new AuthPage();
        mainPageNewOrder = new MainPageNewOrder();
        productCardPage = new ProductCardPage();
        orderPage = new OrderPage();

    }

    @Test
    void test() {

        authPage
                .authUser("9683333423", "111111");

        mainPageNewOrder
                .goToProductCardPage("Apple iPhone 11 Pro Max");

        productCardPage
                .clickBuyButton();

        orderPage
                .enterMobilePhone(mobilePhone)
                .enterEmail("123@123.com")
                .clickSendApproveToClient()
                .checkMessageForClient();

        open("https://agent-front-ag-test.forward.lc/order/ru/mobile/new/" + getApplicationID());

        orderPage
                .clickClientAgreementCheckbox()
                .clickClientDataProcessingCheckbox()
                .enterClientSmsCode("1111")
                .clickClientAcceptLeasing()
                .checkMessageLeasingСonfirmation();

        open("https://agent-front-ag-test.forward.lc/order/contract-create/MWHG2RU~A?agentId=" + getAgentId());

        orderPage
                .uploadPassport()
                .uploadSelfie()
                .enterLocationData("г Москва, Планетная улица, д 2")
                .selectLocationDataFromList("г Москва, Планетная улица, д 2")
                .enterRegistrationFlat("1")
                .clickEmploymentTypeSelector()
                .clickValueInEmploymentTypeSelector("Наемный работник")
                .enterMonthlySalary("100000")
                .clickSendAgentData()
                .waitUntilDataCheckIsOver()
                .clickAgentAgreementCheckbox()
                .enterAgentSmsCode("1111")
                .clickSignLeasing()
                .checkMessageOrderIsSigned();

        }
}
