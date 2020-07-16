package qa.front.friends.logic.pages;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class UserActsPage {


    private SelenideElement elNumberOfDisplayedActs = $x("//span[contains(text(),'| Показано ')]");
    private SelenideElement elLoadMoreActsButton = $x("//a[@data-test='load-acts' and contains(text(),'Загрузить ещё')]");
    private SelenideElement elLoadAllActsButton = $x("//a[@data-test='acts-show-all' and contains(text(),'Все')]");
    private ElementsCollection elsRowNumberColumnValues = $$x("//*[@class='table-orders-body']//*[@fxlayout='row']//*[1][not(@data-test='act-print-download')]");
    private ElementsCollection elsDateColumnValues = $$x("//*[@class='table-orders-body']//*[@fxlayout='row' and not (@fxlayoutalign)]//*[2]");
    private ElementsCollection elsStatusColumnValues = $$x("//*[@class='table-orders-body']//*[@fxlayout='row' and not (@fxlayoutalign)]//*[3]");
    private ElementsCollection elsPaymentColumnValues = $$x("//*[@class='table-orders-body']//*[@fxlayout='row' and not (@fxlayoutalign)]//*[4]");
    private ElementsCollection elsContractsColumnValues = $$x("//*[@class='table-orders-body']//*[@fxlayout='row' and not (@fxlayoutalign)]//*[5]");
    private ElementsCollection elsRowsInActsTable = $$x("//*[@class='table-orders-body']//*[@fxlayout='row' and not (@fxlayoutalign)]");


    @Step("I check number of displayed acts is visible")
    public UserActsPage checkActsTotalNumberMatcherRegex() {
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

    @Step("I check row number column matches regex")
    public UserActsPage checkRowNumberColumnMatchesRegex() {
        for (SelenideElement el : elsRowNumberColumnValues) {
            el.shouldHave(Condition.matchText("^\\d+$"));
        }
        return this;
    }

    @Step("I check data column matches regex")
    public UserActsPage checkDataColumnMatchesRegex() {
        for (SelenideElement el : elsDateColumnValues) {
            el.shouldHave(Condition.matchText("(^\\d{2}[.]{1}\\d{2}[.]{1}\\d{4}$)|" +
                    "(^\\d{1,2}\\/\\d{1,2}\\/\\d{4}$)"));
        }
        return this;
    }

    //https://wiki.forward.lc/pages/viewpage.action?pageId=4719015 - документация по статусам
    @Step("I check status column matches regex")
    public UserActsPage checkStatusColumnMatchesRegex() {
        for (SelenideElement el : elsStatusColumnValues) {
            el.shouldHave(Condition.matchText("^(Новый)$|^(Подписан, ожидает оплаты)$|^(Оплачен)$|^(Ошибка оплаты)$|" +
                    "^(Ошибка создания акта)$|^(Отменен)$"));
        }
        return this;
    }

    @Step("I check payment column matches regex")
    public UserActsPage checkPaymentColumnMatchesRegex() {
        for (SelenideElement el : elsPaymentColumnValues) {
            el.shouldHave(Condition.matchText("^\\d+$"));
        }
        return this;
    }

    @Step("I check contracts column matches regex")
    public UserActsPage checkContractsColumnMatchesRegex() {
        for (SelenideElement el : elsContractsColumnValues) {
            el.shouldHave(Condition.matchText("^(\\d+[,]{1} \\d+)|(^\\d+)$"));
        }
        return this;
    }

    @Step("I check MyActs table data matches regex")
    public UserActsPage checkMyActsTableValuesMatchRegex() {
        checkRowNumberColumnMatchesRegex();
        checkDataColumnMatchesRegex();
        checkStatusColumnMatchesRegex();
        checkPaymentColumnMatchesRegex();
        checkContractsColumnMatchesRegex();
        return this;
    }


}
