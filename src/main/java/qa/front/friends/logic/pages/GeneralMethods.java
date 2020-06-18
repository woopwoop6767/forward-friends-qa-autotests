package qa.front.friends.logic.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class GeneralMethods {

    @Step("I switch to tab {tab}")
    public GeneralMethods switchToTab(int tab) {
        switchTo().window(tab);
        return this;
    }

    @Step("I open new tab in browser")
    public GeneralMethods openNewTabInBrowser() {
        executeJavaScript("window.open()");
        return this;
    }

    @Step("I open new tab in browser with URL {URL}")
    public GeneralMethods openNewTabInBrowserWithUrl(String url) {
        executeJavaScript("window.open('"+ url +"','_blank');");
        return this;
    }

    @Step("I close tab")
    public GeneralMethods closeTab() {
        closeWindow();
        return this;
    }
}
