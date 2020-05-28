package qa.front.friends.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.front.friends.logic.driver.DesktopDriver;
import qa.front.friends.logic.pages.AuthPage;
import qa.front.friends.logic.pages.MainPageNewOrder;
import qa.front.friends.logic.pages.ProductCardPage;
import qa.front.friends.logic.pojo.PriceItemTestData;

public class test002ProductCardDataChanges implements DesktopDriver {

    private AuthPage authPage;
    private MainPageNewOrder mainPageNewOrder;
    private ProductCardPage productCardPage;
    private PriceItemTestData priceItemTestData;
    private PriceItemTestData priceItemTestDataChange;

    @BeforeMethod
    void setUp() {
        authPage = new AuthPage();
        mainPageNewOrder = new MainPageNewOrder();
        productCardPage = new ProductCardPage();
        priceItemTestData = new PriceItemTestData("Apple iPhone 11 Pro Max");
        priceItemTestData
                // для указания пробелов в сумме использовалась комбинация клавиш Alt+0160 (для пробела xpath &nbsp)
                .setTotalCost("113 990 ₽")
                .setLeasingSum("124 980 ₽")
                .setResidualSum("45 117 ₽")
                .setMonthPay("6 655 ₽")
                .setColor("олотой")
                .setVolume("256 ГБ");
        priceItemTestDataChange = new PriceItemTestData("Apple iPhone 11 Pro Max");
        priceItemTestDataChange
                .setTotalCost("131 990 ₽")
                .setLeasingSum("142 980 ₽")
                .setResidualSum("52 242 ₽")
                .setMonthPay("7 562 ₽")
                .setColor("еребристый")
                .setVolume("512 ГБ");

    }


    @Test
    void test() {
        authPage
                .authUser("9683333423", "111111");

        mainPageNewOrder
                .enterItemNameToSearchField(priceItemTestData.getItemName())
                .goToProductCardPage(priceItemTestData.getItemName());
        productCardPage
                .setItemOptions(priceItemTestData.getVolume(), priceItemTestData.getColor())
                .checkLeasingPricesInfoBlock(priceItemTestData)
                .setItemOptions(priceItemTestDataChange.getVolume(), priceItemTestDataChange.getColor())
                .checkLeasingPricesInfoBlock(priceItemTestDataChange);
    }
}
