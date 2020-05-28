package qa.front.friends.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.front.friends.logic.driver.DesktopDriver;
import qa.front.friends.logic.pages.AuthPage;
import qa.front.friends.logic.pages.MainPageNewOrder;
import qa.front.friends.logic.pojo.GeneralItemTestData;

public class test001CheckSearchByItem implements DesktopDriver {

    private AuthPage authPage;
    private MainPageNewOrder mainPageNewOrder;
    private GeneralItemTestData generalItemTestData;

    @BeforeMethod
    void setUp() {
        authPage = new AuthPage();
        mainPageNewOrder = new MainPageNewOrder();
        generalItemTestData = new GeneralItemTestData("Apple iPhone 11 Pro Max");
    }

    @Test
    void test() {

        authPage
                .authUser("9683333423", "111111");

        mainPageNewOrder
                .enterItemNameToSearchField(generalItemTestData.getItemName())
                .checkSearchResult(generalItemTestData.getItemName());
    }

}
