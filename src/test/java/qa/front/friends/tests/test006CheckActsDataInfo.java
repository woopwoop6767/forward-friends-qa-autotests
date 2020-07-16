package qa.front.friends.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.front.friends.logic.driver.DesktopDriver;
import qa.front.friends.logic.pages.AuthPage;
import qa.front.friends.logic.pages.MainPageNewOrder;
import qa.front.friends.logic.pages.UserActsPage;
import qa.front.friends.logic.pages.UserCabinetPage;

public class test006CheckActsDataInfo implements DesktopDriver {


    private AuthPage authPage;
    private MainPageNewOrder mainPageNewOrder;
    private UserCabinetPage userCabinetPage;
    private UserActsPage userActsPage;

    @BeforeMethod
    void setUp() {
        authPage = new AuthPage();
        mainPageNewOrder = new MainPageNewOrder();
        userCabinetPage = new UserCabinetPage();
        userActsPage = new UserActsPage();
    }

    @Test
    void test() {

        authPage
                .authUser("9683333423", "111111");

        mainPageNewOrder
                .clickCabinetButton();

        userCabinetPage
                .clickMyActsLink();

        userActsPage
                .checkActsTotalNumberMatcherRegex()
                .checkMyActsTableHasRows()
                .clickLoadMoreActsButton()
                .clickLoadAllActsButton()
                .checkLoadMoreActsButtonIsNotVisible()
                .checkMyActsTableValuesMatchRegex();
    }
}
