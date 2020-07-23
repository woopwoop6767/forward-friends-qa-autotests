package qa.front.friends.logic.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class BestToPayPage {


    SelenideElement elCardNumberInput = $x("//input[@class='card-input card-number']");
    SelenideElement elCardDateInput = $x("//input[@class='card-input card-date']");
    SelenideElement elCardCvcInput = $x("//input[@class='card-input card-cvc']");
    SelenideElement elPayByCardButton = $x("//button[contains(text(),'оплатить картой')]");

    @Step("I enter card number {cardNumber}")
    public BestToPayPage enterCardNumber(String cardNumber) {
        elCardNumberInput.waitUntil(Condition.visible, 20000).sendKeys(cardNumber);
        return this;
    }

    @Step("I enter card date {cardDate}")
    public BestToPayPage enterCardDate(String cardDate) {
        elCardDateInput.sendKeys(cardDate);
        return this;
    }

    @Step("I enter card CVC {cardCvc}")
    public BestToPayPage enterCardCvc(String cardCvc) {
        elCardCvcInput.sendKeys(cardCvc);
        return this;
    }

    @Step("I click [Pay by Card] button")
    public BestToPayPage clickPayByCard() {
        elPayByCardButton.click();
        return this;
    }

}
