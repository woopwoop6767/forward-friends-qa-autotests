package qa.front.friends.logic.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class UserCabinetPage {


    private SelenideElement elAgentsRulesLink = $(By.partialLinkText("Правила агентской программы"));
    private SelenideElement elMyActsLink = $(By.partialLinkText("Мои акты"));
    private SelenideElement elMyAgentContractLink = $(By.partialLinkText("Мой агентский договор"));
    private SelenideElement elTerminateContractLink = $(By.partialLinkText("Расторгнуть договор"));


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
}
