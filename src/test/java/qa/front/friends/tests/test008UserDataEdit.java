package qa.front.friends.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.front.friends.logic.driver.DesktopDriver;
import qa.front.friends.logic.pages.AuthPage;
import qa.front.friends.logic.pages.MainPageNewOrder;
import qa.front.friends.logic.pages.UserCabinetPage;

public class test008UserDataEdit implements DesktopDriver {

    private AuthPage authPage;
    private MainPageNewOrder mainPageNewOrder;
    private UserCabinetPage userCabinetPage;

    @BeforeMethod
    void setUp() {

        authPage = new AuthPage();
        mainPageNewOrder = new MainPageNewOrder();
        userCabinetPage = new UserCabinetPage();

    }

    @Test
    void test() {

        authPage
                .authUser("9683333423", "111111");

        mainPageNewOrder
                .clickCabinetButton();

        userCabinetPage
                .clickEditUserDataButton()
                .checkDataFieldsContainTextAndDisabled()
                .clickCalcelUserDataButton()
                .clickEditUserDataButton()
                .enterBik("04452559")
                .checkSaveUserDataButtonIsDisabled()
                .clickBikBankInSelector("АО \"АЛЬФА-БАНК\"")
                .enterPayAccNumber("40817810006130000784")
                .checkSaveUserDataButtonIsDisabled()
                .enterPayAccNumber("40817810006130000712")
                .clickSaveUserDataButton()
                .checkSuccessAlertIsVisible()
                .clickEditUserDataButton()
                .enterPayAccNumber("40817810006130000783")
                .clickSaveUserDataButton();
    }
}
