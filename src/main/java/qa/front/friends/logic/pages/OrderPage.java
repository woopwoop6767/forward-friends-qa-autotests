package qa.front.friends.logic.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import qa.front.friends.logic.api.SelfieUploader;

import static com.codeborne.selenide.Selenide.*;

public class OrderPage extends GeneralMethods implements SelfieUploader {

    private SelenideElement elMobilePhoneInput = $x("//input[@name='mobilePhone']");
    private SelenideElement elEmailInput = $x("//input[@name='email']");
    private SelenideElement elSendApproveToClientButton = $x("//span[text()='Отправить на подтверждение клиенту']");
    private SelenideElement elMessageToClientText = $x("//*[contains(text(),'Клиенту отправлено смс-сообщение')]");
    private SelenideElement elClientAgreementCheckbox = $x("//span[contains(text(),'Проставляя галочку')]//ancestor::*[contains(@class,'row label')]//app-ui-checkbox");
    private SelenideElement elClientDataProcessingCheckbox = $x("//span[contains(text(),'ознакомился с текстом')]//ancestor::*[contains(@class,'row label')]//app-ui-checkbox");
    private SelenideElement elClientSmsCodeInput = $x("//app-form-pin-code-tiny//input[@type='tel']");
    private SelenideElement elClientAcceptLeasingButton = $x("//span[contains(text(),'Подтвердить')]/..");
    private SelenideElement elMessageLeasingСonfirmationText = $x("//*[contains(text(),'Спасибо за подтверждение.')]");
    private SelenideElement elContinueOrderButton = $x("//button//span[contains(text(),'Продолжить')]");
    private SelenideElement elLocationInput = $x("//input[@name='reg-add']");
    private SelenideElement elRegistrationFlatInput = $x("//input[@name='registration-flat']");
    private SelenideElement elEmploymentTypeSelector = $x("//span[text()='Выберите тип занятости']");
    private SelenideElement elMonthlySalaryInput = $x("//input[@name='monthlySalary']");
    private SelenideElement elSendAgentDataButton = $x("//span[text()='Отправить']/ancestor::button");
    private SelenideElement elAgentAgreementCheckbox = $x("//*[contains(text(),'ознакомился с текстом')]/..//app-ui-checkbox");
    private SelenideElement elAgentSmsCodeInput = $x("//*[contains(text(),'Код из СМС')]//ancestor::app-form-pin-code-tiny//input[@type='tel']");
    private SelenideElement elSignLeasingButton = $x("//span[text()='подписать']//ancestor::button");
    private SelenideElement elMessageOrderSignedText = $x("//h3[text()='Договор оформлен']");



    @Step("I enter mobile phone {mobilePhone}")
    public OrderPage enterMobilePhone(String mobilePhone) {
        elMobilePhoneInput.sendKeys(mobilePhone);
        return this;
    }

    @Step("I enter email {email}")
    public OrderPage enterEmail(String email) {
        elEmailInput.sendKeys(email);
        return this;
    }

    @Step("I click send approve to client button")
    public OrderPage clickSendApproveToClient() {
        elSendApproveToClientButton.click();
        return this;
    }

    @Step("I check text message for client is visible")
    public OrderPage checkMessageForClient() {
        elMessageToClientText.shouldBe(Condition.visible);
        return this;
    }

    @Step("I click client agreement checkbox")
    public OrderPage clickClientAgreementCheckbox() {
        elClientAgreementCheckbox.click();
        return this;
    }

    @Step("I click client data processing checkbox")
    public OrderPage clickClientDataProcessingCheckbox() {
        elClientDataProcessingCheckbox.click();
        return this;
    }

    @Step("I enter client SMS code {smsCode}")
    public OrderPage enterClientSmsCode(String smsCode) {
        elClientSmsCodeInput.sendKeys(smsCode);
        return this;
    }

    @Step("I click client accept leasing button")
    public OrderPage clickClientAcceptLeasing() {
        elClientAcceptLeasingButton.click();
        return this;
    }

    @Step("I check message leasing confirmation is visible")
    public OrderPage checkMessageLeasingСonfirmation() {
        elMessageLeasingСonfirmationText.shouldBe(Condition.visible);
        return this;
    }

    @Step("I click continue order button")
    public OrderPage clickContinueOrder() {
        elContinueOrderButton.click();
        return this;
    }

    @Step("I upload passport")
    public OrderPage uploadPassport() {
        LocalStorage localStorage = ((WebStorage) WebDriverRunner.getWebDriver()).getLocalStorage();
        localStorage.keySet().forEach(
                val -> {
                    if (val.equals("fwd_basketId")) {
                        passportUploadApi(localStorage.getItem(val),
                                executeJavaScript(String.format("return window.localStorage.getItem('%s');", "auth-token")).toString());
                        return;
                    }
                }
        );
        refresh();
        return this;
    }

    @Step("I upload selfie")
    public OrderPage uploadSelfie() {
        LocalStorage localStorage = ((WebStorage) WebDriverRunner.getWebDriver()).getLocalStorage();
        localStorage.keySet().forEach(
                val -> {
                    if (val.equals("fwd_basketId")) {
                        selfieUploadApi(localStorage.getItem(val),
                                executeJavaScript(String.format("return window.localStorage.getItem('%s');", "auth-token")).toString());
                        return;
                    }
                }
        );
        refresh();
        return this;
    }

    @Step("I enter location data {locationData}")
    public OrderPage enterLocationData(String locationData) {
        elLocationInput.sendKeys(locationData);
        $x("//span[text()='" + locationData + "']").click();
        return this;
    }

    @Step("I enter registration flat {flat}")
    public OrderPage enterRegistrationFlat(String flat) {
        elRegistrationFlatInput.sendKeys(flat);
        return this;
    }

    @Step("I click row in employment type selector {row}")
    public OrderPage clickRowInEmploymentTypeSelector(String row) {
        elEmploymentTypeSelector.click();
        $x("//*[contains(@class,'select__items')]//span[text()='" + row + "']").click();
        return this;
    }

    @Step("I enter monthly salary {monthlySalary}")
    public OrderPage enterMonthlySalary(String monthlySalary) {
        elMonthlySalaryInput.sendKeys(monthlySalary);
        return this;
    }

    @Step("I click send agent data button")
    public OrderPage clickSendAgentData() {
        elSendAgentDataButton.click();
        return this;
    }

    @Step("I wait until agent data is successfully checked")
    public OrderPage waitUntilDataCheckIsOver() {
        elAgentAgreementCheckbox.waitUntil(Condition.visible, 90000);
        return this;
    }

    @Step("I click agent agreement checkbox")
    public OrderPage clickAgentAgreementCheckbox() {
        elAgentAgreementCheckbox.click();
        return this;
    }

    @Step("I enter agent SMS code {smsCode}")
    public OrderPage enterAgentSmsCode(String smsCode) {
        elAgentSmsCodeInput.sendKeys(smsCode);
        return this;
    }

    @Step("I click sign leasing button")
    public OrderPage clickSignLeasing() {
        elSignLeasingButton.click();
        return this;
    }

    @Step("I check message signed order is visible")
    public OrderPage checkMessageOrderIsSigned() {
        elMessageOrderSignedText.shouldBe(Condition.visible);
        return this;
    }

}
