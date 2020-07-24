package qa.front.friends.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.front.friends.logic.driver.DesktopDriver;
import qa.front.friends.logic.pages.AuthPage;
import qa.front.friends.logic.pages.MainPageContracts;

public class test004CheckContractsDataInfo implements DesktopDriver {


    private AuthPage authPage;
    private MainPageContracts mainPageContracts;

    @BeforeMethod
    void setUp() {
        authPage = new AuthPage();
        mainPageContracts = new MainPageContracts();
    }

    @Test
    void test() {

        authPage
                .authUser("9683333423", "111111");

        mainPageContracts
                .clickMyContractsButton()
                .checkStatisticBarDataIsNotEqualZero()
                .checkContractsTableHasRows()
                .clickLoadMoreContractsButton();
    }
}
