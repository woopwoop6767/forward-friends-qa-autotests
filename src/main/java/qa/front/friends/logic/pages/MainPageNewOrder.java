package qa.front.friends.logic.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Selenide.*;

import static com.codeborne.selenide.Selenide.$x;


public class MainPageNewOrder {

    private SelenideElement elOrdersButton = $x("//*[@data-test='top-menu' and text() = 'Заявки']");
    private SelenideElement elTariffsButton = $x("//*[@data-test='top-menu' and text() = 'Тарифы']");
    private SelenideElement elPodpishisRFButtonLink = $x("//*[@data-test='top-menu' and text() = 'Подпишись.рф']");
    private SelenideElement elCabinetButton = $x("//a[@routerlink='/cabinet']");
    private SelenideElement elNewOrderMenuItem = $x("//*[@class='order-menu']//*[text()='Новая заявка']");
    private SelenideElement elContractsMenuItem = $x("//*[@class='order-menu']//*[text()='Мои договоры']");
    private SelenideElement elSearchFieldInput = $x("//input[@data-test='search-field' and @placeholder='Поиск']");
    private SelenideElement elSecondProductCardSearchResult = $x("//div[2][@data-test='product-card']");


    @Step("I enter item's {itemName} to the search field")
    public MainPageNewOrder enterItemNameToSearchField(String itemName) {
        elSearchFieldInput.shouldBe(Condition.visible).sendKeys(itemName);
        return this;
    }

    @Step("I check search result")
    public MainPageNewOrder checkSearchResult(String itemName) {
        SelenideElement elFirstProductCard = $x("//*[@data-test='product-card']//span[text()='" + itemName + "']");
        elFirstProductCard.shouldBe(Condition.visible);
        elSecondProductCardSearchResult.shouldNotBe(Condition.visible);
        return this;
    }

    @Step("I go to product card page")
    public MainPageNewOrder goToProductCardPage(String itemName) {
        SelenideElement elGoToItemCardButton;
        elGoToItemCardButton = $x("//span[text()='" + itemName + "']/ancestor::*[@data-test='product-card'][1]");
        elGoToItemCardButton.shouldBe(Condition.visible);
        actions().moveToElement(elGoToItemCardButton).click().perform();
        return this;
    }




}
