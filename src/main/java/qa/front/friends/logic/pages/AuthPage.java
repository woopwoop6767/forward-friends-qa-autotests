package qa.front.friends.logic.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class AuthPage {

    private SelenideElement elLoginPhoneNumberInput = $x("//input[@data-test='login-phone-input']");
    private SelenideElement elPasswordInput = $x("//input[@data-test='login-pin-input']");
    private SelenideElement elLoginButton = $x("//div[(text()='Войти')]/ancestor::button[1]");

    @Step("I enter login {login}")
    private AuthPage enterLogin(String login) {
        elLoginPhoneNumberInput.sendKeys(login);
        return this;
    }

    @Step("I enter password {password}")
    private AuthPage enterPassword(String password) {
        elPasswordInput.sendKeys(password);
        return this;
    }

    @Step("I click login button")
    private AuthPage clickLoginButton() {
        elLoginButton.click();
        return this;
    }

    @Step("I auth")
    public AuthPage authUser(String phoneNumber, String password) {
        enterLogin(phoneNumber);
        enterPassword(password);
        clickLoginButton();
        return this;
    }
}
