package qa.front.friends.logic.pages;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class UserActsPage {


    private SelenideElement elNumberOfDisplayedActs = $x("//span[contains(text(),'| Показано ')]");
    private SelenideElement elLoadMoreActsButton = $x("//a[@data-test='load-acts' and contains(text(),'Загрузить ещё')]");
    private SelenideElement elLoadAllActsButton = $x("//a[@data-test='acts-show-all' and contains(text(),'Все')]");
    private ElementsCollection elsRowsInActsTable = $$x("//*[@class='table-orders-body']//*[@fxlayout='row' and not (@fxlayoutalign)]");
    private SelenideElement elConfirmWithdrawButton = $x("//button[.//*[contains(text(),'Подтвердить выплату')]]");
    private SelenideElement elSignWithdrawButton = $x("//button[.//*[contains(text(),'Подписать')]]");
    private SelenideElement elAgreeTermsCheckbox = $x("//span[contains(text(),'С условиями согласен')]/ancestor::*//label[@role='checkbox']");
    private SelenideElement elSmsCodeInput = $x("//input[@data-test='pin-input']");
    private SelenideElement elBackLink = $x("//*[@data-test='link-back']");
    private SelenideElement elAnnulFirstActInTableLink = $x("//*[@data-test='annul-act'][1]");


    @Step("I check number of displayed acts is visible")
    public UserActsPage checkActsTotalNumberMatchesRegex() {
        elNumberOfDisplayedActs.shouldBe(Condition.matchText("^[|] Показано [0-9]+ из [0-9]+ [|]$"));
        return this;
    }

    @Step("I click [load more acts] button")
    public UserActsPage clickLoadMoreActsButton() {
        elLoadMoreActsButton.click();
        return this;
    }

    @Step("I click [load all acts] button")
    public UserActsPage clickLoadAllActsButton() {
        elLoadAllActsButton.click();
        return this;
    }

    @Step("I check load more acts is not visible")
    public UserActsPage checkLoadMoreActsButtonIsNotVisible() {
        elLoadMoreActsButton.shouldNotBe(Condition.visible);
        return this;
    }

    @Step("I check MyActs table has rows > 0")
    public UserActsPage checkMyActsTableHasRows() {
        elsRowsInActsTable.shouldBe(CollectionCondition.sizeGreaterThan(0));
        return this;
    }

    @Step("I click [Confirm withdraw] button")
    public UserActsPage clickConfirmWithDrawButton() {
        elConfirmWithdrawButton.click();
        return this;
    }

    @Step("I check [Sign withdraw] button is disabled")
    public UserActsPage checkSignWithdrawButtonIsDisabled() {
        elSignWithdrawButton.shouldNotBe(Condition.enabled);
        return this;
    }

    @Step("I check [Sign withdraw] button is enable")
    public UserActsPage checkSignWithdrawButtonIsEnable() {
        elSignWithdrawButton.shouldBe(Condition.enabled);
        return this;
    }

    @Step("I click [Agree terms] checkbox")
    public UserActsPage clickAgreeTermsCheckbox() {
        elAgreeTermsCheckbox.click();
        return this;
    }

    @Step("I enter SMS code {smsCode}")
    public UserActsPage enterSmsCode(String smsCode) {
        elSmsCodeInput.sendKeys(smsCode);
        return this;
    }

    @Step("I click [Back] link")
    public UserActsPage clickBackLink() {
        elBackLink.click();
        return this;
    }

    @Step("I click [Annul] first act in table")
    public UserActsPage clickAnnulFirstActInTableLink() {
        elAnnulFirstActInTableLink.click();
        return this;
    }


}
