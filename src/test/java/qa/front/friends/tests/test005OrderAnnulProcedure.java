package qa.front.friends.tests;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.front.friends.logic.GenerateText;
import qa.front.friends.logic.api.SelfieUploader;
import qa.front.friends.logic.driver.DesktopDriver;
import qa.front.friends.logic.pages.AuthPage;
import qa.front.friends.logic.pages.MainPageNewOrder;
import qa.front.friends.logic.pages.OrderPage;
import qa.front.friends.logic.pages.ProductCardPage;

import static com.codeborne.selenide.Selenide.open;

public class test005OrderAnnulProcedure implements DesktopDriver, GenerateText, SelfieUploader {


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
                .clickAnnulOrderLink();

        Selenide.confirm();

        orderPage
                .checkMessageIsAnnulIsVisible()
                .clickIssueNewOrderButton()
                .checkSendApproveToClientButtonIsVisible();

    }

}
