package qa.front.friends.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.front.friends.logic.driver.DesktopDriver;
import qa.front.friends.logic.pages.AuthPage;
import qa.front.friends.logic.pages.MainPageNewOrder;

public class test001CheckSearchByItem implements DesktopDriver {

    private AuthPage authPage;
    private MainPageNewOrder mainPageNewOrder;

    @BeforeMethod
    void setUp() {
        authPage = new AuthPage();
        mainPageNewOrder = new MainPageNewOrder();
    }

    @Test
    void test() {

        authPage
                .authUser("9683333423", "111111");

        mainPageNewOrder
                .enterItemNameToSearchField("Apple iPhone 11 Pro Max")
                .checkSearchResult("Apple iPhone 11 Pro Max");
    }

}
