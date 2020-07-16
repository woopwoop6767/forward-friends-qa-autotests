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
    private ElementsCollection elsRowNumberColumnValues = $$x("//*[@class='table-orders-body']//*[@fxlayout='row']//div[1]");
    private ElementsCollection elsDataColumnValues = $$x("//*[@class='table-orders-body']//*[@fxlayout='row']//div[2]");
    private ElementsCollection elsClientColumnValues = $$x("//*[@class='table-orders-body']//*[@fxlayout='row']//div[3]");
    private ElementsCollection elsItemColumnValues = $$x("//*[@class='table-orders-body']//*[@fxlayout='row']//div[4]");
    private ElementsCollection elsContractColumnValues = $$x("//*[@class='table-orders-body']//*[@fxlayout='row']//div[5]");
    private ElementsCollection elsStatusColumnValues = $$x("//*[@class='table-orders-body']//*[@fxlayout='row']//div[6]");




    @Step("I click [My contracts] menu button")
    public MainPageContracts clickMyContractsButton() {
        elMyContractsMenuButton.click();
        return this;
    }

    @Step("I check number of applications is not equals 0")
    public MainPageContracts checkNumberOfAppsIsNotEqualZero() {
        elNumberOfApplicationsInfo.shouldNotHave(Condition.matchText("0"));
        return this;
    }

    @Step("I check applications to issue is not equals 0")
    public MainPageContracts checkAppsToIssueIsNotEqualZero() {
        elApplicationsToIssueInfo.shouldNotHave(Condition.matchText("0"));
        return this;
    }

    @Step("I check issued applications is not equals 0")
    public MainPageContracts checkAppsIssuedIsNotEqualZero() {
        elApplicationsIssuedInfo.shouldNotHave(Condition.matchText("0"));
        return this;
    }

    @Step("I check summary balance is not equals 0")
    public MainPageContracts checkSummaryBalanceIsNotEqualZero() {
        elSummaryBalanceInfo.shouldNotHave(Condition.matchText("0 ₽"));
        return this;
    }

    @Step("I check active balance is not equals 0")
    public MainPageContracts checkActiveBalanceIsNotEqualZero() {
        elActiveBalanceInfo.shouldNotHave(Condition.matchText("0 ₽"));
        return this;
    }

    @Step("I check statistic bar data is not equal 0")
    public MainPageContracts checkStatisticBarDataIsNotEqualZero() {
        checkNumberOfAppsIsNotEqualZero();
        checkAppsToIssueIsNotEqualZero();
        checkAppsIssuedIsNotEqualZero();
        checkSummaryBalanceIsNotEqualZero();
        checkActiveBalanceIsNotEqualZero();
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

    @Step("I check row number column matches regex")
    public MainPageContracts checkRowNumberColumnMatchesRegex() {
        for (SelenideElement el : elsRowNumberColumnValues) {
            el.shouldHave(Condition.matchText("^\\d+$"));
        }
        return this;
    }

    @Step("I check data column matches regex")
    public MainPageContracts checkDataColumnMatchesRegex() {
        for (SelenideElement el : elsDataColumnValues) {
            el.shouldHave(Condition.matchText("^\\d{2}[.]{1}\\d{2}[.]{1}\\d{4}$"));
        }
        return this;
    }

    @Step("I check client column matches regex")
    public MainPageContracts checkClientColumnMatchesRegex() {
        for (SelenideElement el : elsClientColumnValues) {
            el.shouldHave(Condition.matchText("^[А-Яа-я]+ [А-Яа-я]{1}[*]+[А-Яа-я]{1} \\d+[*]+\\d+$"));
        }
        return this;
    }

    @Step("I check item column matches regex")
    public MainPageContracts checkItemColumnMatchesRegex() {
        for (SelenideElement el : elsItemColumnValues) {
            el.shouldHave(Condition.matchText("[A-Za-zА-Яа-я]"));
        }
        return this;
    }

    @Step("I check contract column matches regex")
    public MainPageContracts checkContractColumnMatchesRegex() {
        for (SelenideElement el : elsContractColumnValues) {
            el.shouldHave(Condition.matchText("^\\d+$"));
        }
        return this;
    }

    //https://wiki.forward.lc/pages/viewpage.action?pageId=4718816 - документация по статусам
    @Step("I check status column matches regex")
    public MainPageContracts checkStatusColumnMatchesRegex() {
        for (SelenideElement el : elsStatusColumnValues) {
            el.shouldHave(Condition.matchText("^(Отказ)$|^(Одобрено)$|^(Договор подписан)$|^(Товар выдан)$|" +
                    "^(Договор подписан, доставка оплачена)$|^(Доставка в процессе, товар отгружен)$|" +
                    "^(Аннулировано)$|^(Договор завершен)$"));
        }
        return this;
    }

    @Step("I check Contracts table data matches regex")
    public MainPageContracts checkContractsTableValuesMatchRegex() {
        checkRowNumberColumnMatchesRegex();
        checkDataColumnMatchesRegex();
        checkClientColumnMatchesRegex();
        checkItemColumnMatchesRegex();
        checkContractColumnMatchesRegex();
        checkStatusColumnMatchesRegex();
        return this;
    }




}
