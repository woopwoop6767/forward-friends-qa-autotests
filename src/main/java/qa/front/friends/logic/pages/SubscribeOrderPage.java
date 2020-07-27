package qa.front.friends.logic.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class SubscribeOrderPage {


    SelenideElement elEntranceButton = $x("//button[contains(text(),'Вход')]");
    SelenideElement elPhoneNumberInput = $x("//input[@name='phone']");
    SelenideElement elPinCodeInput = $x("//input[@name='number']");
    SelenideElement elGetCodeForSignButton = $x("//button[.//span[contains(text(),'Получить код для подписания')]]");
    SelenideElement elSignOrderButton = $x("//button[.//span[contains(text(),'Подписать')]]");
    SelenideElement elOrderingIsCompleteText = $x("//p[contains(text(),'Вы завершили процедуру оформления')]");


    @Step("I click [Entrance] button")
    public SubscribeOrderPage clickEntranceButton() {
        elEntranceButton.waitUntil(Condition.visible, 20000).click();
        return this;
    }

    @Step("I enter phone number {phoneNumber}")
    public SubscribeOrderPage enterPhoneNumber(String phoneNumber) {
        elPhoneNumberInput.sendKeys(phoneNumber);
        return this;
    }

    @Step("I enter SMS number {smsCode}")
    public SubscribeOrderPage enterSmsCode(String smsCode) {
        elPinCodeInput.sendKeys(smsCode);
        return this;
    }

    @Step("I click [Get code for sign] button")
    public SubscribeOrderPage clickGetCodeForSignButton() {
        elGetCodeForSignButton.click();
        return this;
    }

    @Step("I click [Sign order] button")
    public SubscribeOrderPage clickSignOrderButton() {
        elSignOrderButton.click();
        return this;
    }

    @Step("I check [Ordering is complete] message is visible")
    public SubscribeOrderPage checkOrderingIsCompleteIsVisible() {
        elOrderingIsCompleteText.shouldBe(Condition.visible);
        return this;
    }


}
