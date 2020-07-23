package qa.front.friends.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.front.friends.logic.driver.DesktopDriver;
import qa.front.friends.logic.pages.*;

public class test007WithdrawAnnul implements DesktopDriver {


    private AuthPage authPage;
    private MainPageNewOrder mainPageNewOrder;
    private MainPageContracts mainPageContracts;
    private UserCabinetPage userCabinetPage;
    private UserActsPage userActsPage;

    @BeforeMethod
    void setUp() {

        authPage = new AuthPage();
        mainPageNewOrder = new MainPageNewOrder();
        mainPageContracts = new MainPageContracts();
        userCabinetPage = new UserCabinetPage();
        userActsPage = new UserActsPage();

    }

    @Test
    void test() {

        authPage
                .authUser("9683333423", "111111");

        mainPageContracts
                .clickMyContractsButton()
                .checkActiveBalanceIsNotEqualZero()
                .clickWithdrawButton();

        userActsPage
                .clickConfirmWithDrawButton()
                .enterSmsCode("1111")
                .checkSignWithdrawButtonIsDisabled()
                .clickAgreeTermsCheckbox()
                .checkSignWithdrawButtonIsEnable();

        mainPageContracts
                .clickAppsLink()
                .clickMyContractsButton()
                .checkActiveBalanceEqualsZero();

        mainPageNewOrder
                .clickCabinetButton();

        userCabinetPage
                .clickMyActsLink();

        userActsPage
                .clickLoadAllActsButton()
                .clickAnnulFirstActInTableLink();

        mainPageContracts
                .clickAppsLink()
                .clickMyContractsButton()
                .checkActiveBalanceIsNotEqualZero();


    }

}
