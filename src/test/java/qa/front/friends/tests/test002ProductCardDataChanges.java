package qa.front.friends.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.front.friends.logic.driver.DesktopDriver;
import qa.front.friends.logic.pages.AuthPage;
import qa.front.friends.logic.pages.MainPageNewOrder;
import qa.front.friends.logic.pages.ProductCardPage;


public class test002ProductCardDataChanges implements DesktopDriver {

    private AuthPage authPage;
    private MainPageNewOrder mainPageNewOrder;
    private ProductCardPage productCardPage;

    @BeforeMethod
    void setUp() {
        authPage = new AuthPage();
        mainPageNewOrder = new MainPageNewOrder();
        productCardPage = new ProductCardPage();
    }


    @Test
    void test() {
        authPage
                .authUser("9683333423", "111111");

        mainPageNewOrder
                .goToProductCardPage("Apple iPhone 11 Pro Max");

        productCardPage

                .clickVolumeRadioButton("256 ГБ")
                .clickCoverColorRadioButton("олотой")
                .checkCartBlockItemName("Apple iPhone 11 Pro Max")
                .checkCartBlockItemVolume("256 ГБ")
                .checkCartBlockColor("олотой")
                .checkCartBlockTotalCost("106 990 ₽")
                .checkCartBlockLeasingSum("117 980 ₽")
                .checkCartBlockResidualSum("42 347 ₽")
                .checkCartBlockMonthTerm("12")
                .checkCartBlockMonthPay("6 303 ₽")
                .clickVolumeRadioButton("512 ГБ")
                .clickCoverColorRadioButton("еребристый")
                .checkCartBlockItemName("Apple iPhone 11 Pro Max")
                .checkCartBlockItemVolume("512 ГБ")
                .checkCartBlockColor("еребристый")
                .checkCartBlockTotalCost("126 990 ₽")
                .checkCartBlockLeasingSum("137 980 ₽")
                .checkCartBlockResidualSum("50 263 ₽")
                .checkCartBlockMonthPay("7 310 ₽")
                .clickBackToCatalogButton()
                .checkUrlContains("https://agent-front-ag-test.forward.lc/main/new-order");
    }
}
