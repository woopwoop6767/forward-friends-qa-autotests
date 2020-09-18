package qa.front.friends.logic.driver;

import com.codeborne.selenide.Browsers;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.selenide.LogType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.logging.Level;

public interface Capabilities {
    default void initLocalCapabilities() {
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
        Configuration.driverManagerEnabled = true;
    }

    default void initRemoteCapabilities(String grid, String browser) {

        switch(browser.trim().toLowerCase()) {
            case ("firefox"):
            case ("ff"):
                Configuration.browser = Browsers.FIREFOX;
                Configuration.browserVersion = "77.0";
                break;
            case ("opera"):
                Configuration.browser = Browsers.OPERA;
                Configuration.browserVersion = "69.0";
                break;
            case ("chrome"):
            default:
                Configuration.browser = Browsers.CHROME;
                Configuration.browserVersion = "84.0";
                break;

        }

        Configuration.timeout = 10000;
//        Configuration.browser = "chrome";
//        Configuration.browserVersion = "83.0";
        Configuration.remote = grid.concat("/wd/hub");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("enableVNC", true);
        desiredCapabilities.setCapability("hostsEntries", new String[] {
                "agent-front-ag-test.forward.lc:192.168.0.12",
                "liza-act-front-test.forward.lc:192.168.0.12",
                "subscribe-rf-front-test.forward.lc:192.168.0.12"
        });
        Configuration.browserCapabilities = desiredCapabilities;
        Configuration.startMaximized = true;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().enableLogs(LogType.BROWSER, Level.ALL));

    }
}
