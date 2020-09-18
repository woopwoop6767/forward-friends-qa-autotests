package qa.front.friends.logic.pages;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

import static com.codeborne.selenide.Selenide.$x;


public class MainPageNewOrder {


    private SelenideElement elOrdersButton = $x("//*[@data-test='top-menu' and text() = 'Заявки']");
    private SelenideElement elTariffsButton = $x("//*[@data-test='top-menu' and text() = 'Тарифы']");
    private SelenideElement elPodpishisRFButtonLink = $x("//*[@data-test='top-menu' and text() = 'Подпишись.рф']");
    private SelenideElement elCabinetButton = $x("//*[@data-test='cabinet-link']");
    private SelenideElement elNewOrderMenuItem = $x("//*[@data-test='new-order-link']");
    private SelenideElement elContractsMenuItem = $x("//*[@data-test='contracts-link']");
    private SelenideElement elSearchFieldInput = $x("//input[@data-test='search-field' and @placeholder='Поиск']");
    private ElementsCollection elsProductCardsArray = $$x("//*[@data-test='product-card' and @fxlayout='column']");


    @Step("I enter item's {itemName} to the search field")
    public MainPageNewOrder enterItemNameToSearchField(String itemName) {
        elSearchFieldInput.shouldBe(Condition.visible).sendKeys(itemName);
        return this;
    }

    @Step("I check search result")
    public MainPageNewOrder checkSearchResult(String itemName) {
        elsProductCardsArray.find(Condition.text(itemName))
                .shouldBe(Condition.visible);
        return this;
    }

    @Step("I go to product card page")
    public MainPageNewOrder goToProductCardPage(String itemName) {
        elsProductCardsArray.find(Condition.text(itemName))
                .click();
        return this;
    }

    @Step("I click user cabinet button")
    public MainPageNewOrder clickCabinetButton() {
        elCabinetButton.click();
        return this;
    }

}
