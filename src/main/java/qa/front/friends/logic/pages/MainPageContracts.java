package qa.front.friends.logic.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class MainPageContracts {


    private SelenideElement elMyContractsMenuButton = $x("//*[contains(@class,'menu-item')]//a[contains(text(),'Мои договоры')]");
    private SelenideElement elNumberOfApplicationsInfo = $x("//*[contains(text(),'Количество заявок')]/preceding-sibling::*[@class='act-title']");
    private SelenideElement elApplicationsToIssueInfo = $x("//*[contains(text(),'Ожидают выдачи')]/preceding-sibling::*[@class='act-title']");
    private SelenideElement elApplicationsIssuedInfo = $x("//*[contains(text(),'Выдано')]/preceding-sibling::*[@class='act-title']");
    private SelenideElement elSummaryBalanceInfo = $x("//*[contains(text(),'Баланс за все время')]//ancestor::*[@class='act-block']//*[@class='act-title rubles']");
    private SelenideElement elActiveBalanceInfo = $x("//*[contains(text(),'На счету')]//ancestor::*[contains(@class,'act-block')]//*[contains(@class,'act-title rubles')]");
    private SelenideElement elWithdrawButton = $x("//*[text()='Снять']/ancestor::button");
    private ElementsCollection elsRowsInContractsTable = $$x("//*[@class='table-orders-body']//*[@fxlayout='row' and not (@fxlayoutalign)]");
    private SelenideElement elLoadMoreContractsButton = $x("//a[contains(text(),'Загрузить ещё')]");
    private SelenideElement elAppsLink = $x("//*[@class='header-menu']//a[@data-test='top-menu' and contains(text(),'Заявки')]");


    @Step("I click [My contracts] menu button")
    public MainPageContracts clickMyContractsButton() {
        elMyContractsMenuButton.click();
        return this;
    }

    @Step("I check active balance equals 0")
    public MainPageContracts checkActiveBalanceEqualsZero() {
        elActiveBalanceInfo.shouldHave(Condition.matchText("0 ₽"));
        return this;
    }

    @Step("I check active balance is not equal 0")
    public MainPageContracts checkActiveBalanceIsNotEqualZero() {
        elActiveBalanceInfo.shouldNotHave(Condition.matchText("0 ₽"));
        return this;
    }

    @Step("I check statistic bar data is not equal 0")
    public MainPageContracts checkStatisticBarDataIsNotEqualZero() {
        elNumberOfApplicationsInfo.shouldNotHave(Condition.matchText("0"));
        elApplicationsToIssueInfo.shouldNotHave(Condition.matchText("0"));
        elApplicationsIssuedInfo.shouldNotHave(Condition.matchText("0"));
        elSummaryBalanceInfo.shouldNotHave(Condition.matchText("0 ₽"));
        elActiveBalanceInfo.shouldNotHave(Condition.matchText("0 ₽"));
        return this;
    }

    @Step("I check Contracts table has rows > 0")
    public MainPageContracts checkContractsTableHasRows() {
        elsRowsInContractsTable.shouldBe(CollectionCondition.sizeGreaterThan(0));
        return this;
    }

    @Step("I click [load more contracts] button")
    public MainPageContracts clickLoadMoreContractsButton() {
        elLoadMoreContractsButton.click();
        return this;
    }

    @Step("I click [Withdraw] button")
    public MainPageContracts clickWithdrawButton() {
        elWithdrawButton.click();
        return this;
    }

    @Step("I click [Applications] link")
    public MainPageContracts clickAppsLink() {
        elAppsLink.click();
        return this;
    }

}
