package qa.front.friends.logic.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;
public class MainPageNewOrder {

    private SelenideElement elOrdersButton = $x("//*[@data-test='top-menu' and text() = 'Заявки']");
    private SelenideElement elTariffsButton = $x("//*[@data-test='top-menu' and text() = 'Тарифы']");
    private SelenideElement elPodpishisRFButtonLink = $x("//*[@data-test='top-menu' and text() = 'Подпишись.рф']");
    private SelenideElement elCabinetButton = $x("//a[@routerlink='/cabinet']");
    private SelenideElement elNewOrderMenuItem = $x("//*[@class='order-menu']//*[text()='Новая заявка']");
    private SelenideElement elContractsMenuItem = $x("//*[@class='order-menu']//*[text()='Мои договоры']");
    private SelenideElement elSearchFieldInput = $x("//input[@data-test='search-field' and @placeholder='Поиск']");
    private SelenideElement elProductCard = $x("//*[@data-test='product-card']");
    private SelenideElement elSecondProductCardSearchResult = $x("//div[2][@data-test='product-card']");


    @Step("I enter item's {itemName} to the search field")
    public MainPageNewOrder enterItemNameToSearchField(String itemName) {
        elSearchFieldInput.shouldBe(Condition.visible).sendKeys(itemName);
        return this;
    }

    @Step("I get webelement by {itemName}")
    private SelenideElement getSearchResultElementByItemName (String itemName) {
        return $x("//*[@data-test='product-card']//span[text()='" + itemName + "']");
    }

    @Step("I check search result")
    public MainPageNewOrder checkSearchResult(String itemName) {
        getSearchResultElementByItemName(itemName).shouldBe(Condition.visible, Condition.enabled);
        elSecondProductCardSearchResult.shouldNotBe(Condition.visible, Condition.enabled);
        return this;
    }



}
