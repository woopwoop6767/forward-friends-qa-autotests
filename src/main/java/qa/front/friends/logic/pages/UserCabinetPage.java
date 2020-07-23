package qa.front.friends.logic.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class UserCabinetPage {


    private SelenideElement elAgentsRulesLink = $(By.partialLinkText("Правила агентской программы"));
    private SelenideElement elMyActsLink = $(By.partialLinkText("Мои акты"));
    private SelenideElement elMyAgentContractLink = $(By.partialLinkText("Мой агентский договор"));
    private SelenideElement elTerminateContractLink = $(By.partialLinkText("Расторгнуть договор"));
    private SelenideElement elLastNameInput = $x("//*[contains(text(),'Личные данные')]//following::input[@data-test='last-name-field']");
    private SelenideElement elFirstNameInput = $x("//*[contains(text(),'Личные данные')]//following::input[@data-test='first-name-field']");
    private SelenideElement elMiddleNameInput = $x("//*[contains(text(),'Личные данные')]//following::input[@data-test='middle-name-field']");
    private SelenideElement elPhoneInput = $x("//*[contains(text(),'Личные данные')]//following::input[@data-test='phone-field']");
    private SelenideElement elEmailInput = $x("//*[contains(text(),'Личные данные')]//following::input[@data-test='email-field']");
    private SelenideElement elInnInput = $x("//*[contains(text(),'Документы')]//following::input[@data-test='inn-field']");
    private SelenideElement elSnilsInput = $x("//*[contains(text(),'Документы')]//following::input[@data-test='snils-field']");
    private SelenideElement elPayAccNumberInput = $x("//*[contains(text(),'Реквизиты для получения')]//following::input[@data-test='pay-account-number-field']");
    private SelenideElement elPayAccBikInput = $x("//*[contains(text(),'Реквизиты для получения')]//following::input[@data-test='pay-account-bik-field']");
    private SelenideElement elEditUserDataButton = $x("//*[contains(text(),'Изменить')]//ancestor::button");
    private SelenideElement elSaveUserDataButton = $x("//*[contains(text(),'Сохранить')]//ancestor::button");
    private SelenideElement elCalcelUserDataButton = $x("//*[contains(text(),'Отмена')]//ancestor::button");
    private ElementsCollection elsBikBankSelector = $$x("//*[@data-test='set-pay-account-bik']");
    private SelenideElement elSuccessAlert = $x("//*[contains(text(),'Изменения успешно сохранены')]");


    @Step("I click agent rules link")
    public UserCabinetPage clickAgentsRulesLink() {
        elAgentsRulesLink.click();
        return this;
    }

    @Step("I click acts link")
    public UserCabinetPage clickMyActsLink() {
        elMyActsLink.click();
        return this;
    }

    @Step("I click agent contract link")
    public UserCabinetPage clickMyAgentContractLink() {
        elMyAgentContractLink.click();
        return this;
    }

    @Step("I click terminate the contract link")
    public UserCabinetPage clickTerminateContractLink() {
        elTerminateContractLink.click();
        return this;
    }

    @Step("I check data fields are contain text and disabled for edit")
    public UserCabinetPage checkDataFieldsContainTextAndDisabled() {
        elLastNameInput.shouldHave(Condition.attribute("formcontrolname", "lastName"))
                .shouldNotBe(Condition.enabled);
        elFirstNameInput.shouldHave(Condition.attribute("formcontrolname", "firstName"))
                .shouldNotBe(Condition.enabled);
        elMiddleNameInput.shouldHave(Condition.attribute("formcontrolname", "middleName"))
                .shouldNotBe(Condition.enabled);
        elPhoneInput.shouldHave(Condition.attribute("formcontrolname", "mobilePhone"))
                .shouldNotBe(Condition.enabled);
        elEmailInput.shouldHave(Condition.attribute("formcontrolname", "email"))
                .shouldNotBe(Condition.enabled);
        elInnInput.shouldHave(Condition.attribute("formcontrolname", "inn"))
                .shouldNotBe(Condition.enabled);
        elSnilsInput.shouldHave(Condition.attribute("formcontrolname", "snils"))
                .shouldNotBe(Condition.enabled);
        return this;
    }

    @Step("I click [Edit] user data button")
    public UserCabinetPage clickEditUserDataButton() {
        elEditUserDataButton.click();
        return this;
    }

    @Step("I enter pay account number {payAccNumber}")
    public UserCabinetPage enterPayAccNumber(String payAccNumber) {
        elPayAccNumberInput.clear();
        elPayAccNumberInput.sendKeys(payAccNumber);
        return this;
    }

    @Step("I check [Save] user data button is disabled")
    public UserCabinetPage checkSaveUserDataButtonIsDisabled() {
        elSaveUserDataButton.shouldBe(Condition.disabled);
        return this;
    }

    @Step("I click [Calcel] user data button")
    public UserCabinetPage clickCalcelUserDataButton() {
        elCalcelUserDataButton.click();
        return this;
    }

    @Step("I click [Save] user data button")
    public UserCabinetPage clickSaveUserDataButton() {
        elSaveUserDataButton.click();
        return this;
    }

    @Step("I enter BIK {bik}")
    public UserCabinetPage enterBik(String bik) {
        elPayAccBikInput.clear();
        elPayAccBikInput.sendKeys(bik);
        return this;
    }

    @Step("I click bank in BIK selector {bikBank}")
    public UserCabinetPage clickBikBankInSelector(String bikBank) {
        elsBikBankSelector.find(Condition.text(bikBank)).click();
        return this;
    }

    @Step("I check [Success] alert is visible")
    public UserCabinetPage checkSuccessAlertIsVisible() {
        elSuccessAlert.shouldBe(Condition.visible);
        return this;
    }
}
