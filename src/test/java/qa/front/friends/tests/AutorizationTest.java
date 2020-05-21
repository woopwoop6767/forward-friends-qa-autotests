package qa.front.friends.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import qa.front.friends.logic.driver.DesktopDriver;
import qa.front.friends.logic.pages.AuthPage;

public class AutorizationTest implements DesktopDriver {

    private AuthPage authPage;

    @BeforeMethod
    void setUp() {
        authPage = new AuthPage();
    }

    @Test
    void test() {


        authPage
                .authUser("+7 968 333-34-23", "111111");
    }

}
