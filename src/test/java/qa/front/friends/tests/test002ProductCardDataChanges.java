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
                .checkCartBlockItemInfo("Apple iPhone 11 Pro Max","256 ГБ")
                .checkCartBlockColor("олотой")
                .checkCartBlockTotalCost("113 990 ₽", "Apple iPhone 11 Pro Max", "256 ГБ")
                .checkCartBlockLeasingSum("124 980 ₽")
                .checkCartBlockResidualSum("45 117 ₽")
                .checkCartBlockMonthTerm("12")
                .checkCartBlockMonthPay("6 655 ₽")
                .clickVolumeRadioButton("512 ГБ")
                .clickCoverColorRadioButton("еребристый")
                .checkCartBlockItemInfo("Apple iPhone 11 Pro Max","512 ГБ")
                .checkCartBlockColor("еребристый")
                .checkCartBlockTotalCost("131 990 ₽", "Apple iPhone 11 Pro Max", "512 ГБ")
                .checkCartBlockLeasingSum("142 980 ₽")
                .checkCartBlockResidualSum("52 242 ₽")
                .checkCartBlockMonthPay("7 562 ₽")
                .clickBackToCatalogButton()
                .checkUrlContains("https://agent-front-ag-test.forward.lc/main/new-order");
    }
}
