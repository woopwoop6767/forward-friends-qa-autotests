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

                .clickOptionsRadioBtn("256 ГБ")
                .clickOptionsRadioBtn("олотой")
                .clickOptionsRadioBtn("амовывоз")
                .checkCartBlockItemValue("Apple iPhone 11 Pro Max 256 ГБ")
                .checkProductColorInfo("олотой")
                .checkProductDeliveryTypeInfo("амовывоз")
                .checkProductPriceInfo("106 990 ₽")
                .checkProductTotalAmountInfo("117 980 ₽")
                .checkProductResidualSumInfo("42 347 ₽")
                .checkProductMonthTermInfo("12")
                .checkProductAmountPayInfo("6 302 ₽")
                .clickOptionsRadioBtn("512 ГБ")
                .clickOptionsRadioBtn("еребристый")
                .clickOptionsRadioBtn("оставка")
                .checkCartBlockItemValue("Apple iPhone 11 Pro Max 512 ГБ")
                .checkProductColorInfo("еребристый")
                .checkProductDeliveryTypeInfo("оставка")
                .checkProductPriceInfo("126 990 ₽")
                .checkProductTotalAmountInfo("137 980 ₽")
                .checkProductResidualSumInfo("50 263 ₽")
                .checkProductAmountPayInfo("7 309 ₽")
                .clickBackToCatalogButton()
                .checkUrlContains("https://agent-front-ag-test.forward.lc/main/new-order");
    }
}
