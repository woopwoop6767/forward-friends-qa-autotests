package qa.front.friends.logic.pages;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;

import java.util.NoSuchElementException;

import static com.codeborne.selenide.Selenide.*;

import static com.codeborne.selenide.Selenide.$x;


public class MainPageNewOrder extends GeneralMethods {


    private SelenideElement elOrdersButton = $x("//*[@data-test='top-menu' and text() = 'Заявки']");
    private SelenideElement elTariffsButton = $x("//*[@data-test='top-menu' and text() = 'Тарифы']");
    private SelenideElement elPodpishisRFButtonLink = $x("//*[@data-test='top-menu' and text() = 'Подпишись.рф']");
    private SelenideElement elCabinetButton = $x("//a[@routerlink='/cabinet']");
    private SelenideElement elNewOrderMenuItem = $x("//*[@class='order-menu']//*[text()='Новая заявка']");
    private SelenideElement elContractsMenuItem = $x("//*[@class='order-menu']//*[text()='Мои договоры']");
    private SelenideElement elSearchFieldInput = $x("//input[@data-test='search-field' and @placeholder='Поиск']");
    private ElementsCollection elsProductCardsArray = $$x("//*[@data-test='product-card' and @fxlayout='column']");


    @Step("I enter item's {itemName} to the search field")
    public MainPageNewOrder enterItemNameToSearchField(String itemName) {
        elSearchFieldInput.shouldBe(Condition.visible).sendKeys(itemName);
        return this;
    }

    @Step("I check search result")
    public MainPageNewOrder checkSearchResult(String itemName) {
        elsProductCardsArray.shouldBe(CollectionCondition.size(1)).stream()
                .filter(var -> var.getText().contains(itemName))
                .findFirst().orElseThrow(NoSuchElementException::new);
        return this;
    }

    @Step("I go to product card page")
    public MainPageNewOrder goToProductCardPage(String itemName) {
        elsProductCardsArray.shouldBe(CollectionCondition.sizeGreaterThan(0)).stream()
                .filter(var -> var.shouldBe(Condition.visible).getText().contains(itemName))
                .findFirst().orElseThrow(NoSuchElementException::new).click();
        return this;
    }

}
