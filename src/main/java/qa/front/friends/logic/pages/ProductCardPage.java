package qa.front.friends.logic.pages;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.WebDriverWait;
import qa.front.friends.logic.WebElementsCollectionHandler;
import qa.front.friends.logic.api.SelfieUploader;

import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;

public class ProductCardPage implements WebElementsCollectionHandler, SelfieUploader {


    private SelenideElement elBackToCatalogButton = $x("//app-button[@title='Назад к списку']//button[1]");
    private SelenideElement elBuyButton = $x("//app-button[@title='Оформить']//button[1]");
    private ElementsCollection elsVolumeRadioButtons = $$x("//*[@data-test='volume-select']//*[@style='display: block;']//*[@data-test='radio-point']");
    private ElementsCollection elsCoverColorRadioButtons = $$x("//*[@data-test='color-select']//*[@data-test='radio-point']");
    private ElementsCollection elsCartBlockItemInfo = $$x("//*[@style='display: block;']//*[@data-test='cart-block']//*[contains(@style,'flex-direction')]");


    @Step("I click {itemVolume} radio button")
    public ProductCardPage clickVolumeRadioButton(String itemVolume) {
        elsVolumeRadioButtons.find(Condition.text(itemVolume))
                .click();
        return this;
    }

    @Step("I click {itemColor} radio button")
    public ProductCardPage clickCoverColorRadioButton(String itemColor) {
        elsCoverColorRadioButtons.find(Condition.text(itemColor))
                .click();
        return this;
    }

    @Step("I check {itemName} is displayed correctly in cart block")
    public ProductCardPage checkCartBlockItemName(String itemName) {
        elsCartBlockItemInfo.find(Condition.text(itemName))
                .shouldBe(Condition.visible);
        return this;
    }

    @Step("I check {itemVolume} is displayed correctly in cart block")
    public ProductCardPage checkCartBlockItemVolume(String itemVolume) {
        elsCartBlockItemInfo.find(Condition.text(itemVolume))
                .shouldBe(Condition.visible);
        return this;
    }

    @Step("I check {itemColor} is displayed correctly in cart block")
    public ProductCardPage checkCartBlockColor(String itemColor) {
        elsCartBlockItemInfo.find(Condition.text(itemColor))
                .shouldBe(Condition.visible);
        return this;
    }

    @Step("I check {totalCost} is displayed correctly in cart block")
    public ProductCardPage checkCartBlockTotalCost(String totalCost) {
        elsCartBlockItemInfo.find(Condition.text(totalCost))
                .shouldBe(Condition.visible);
        return this;
    }

    @Step("I check {leasingSum} is displayed correctly in cart block")
    public ProductCardPage checkCartBlockLeasingSum(String leasingSum) {
        elsCartBlockItemInfo.find(Condition.text(leasingSum))
                .shouldBe(Condition.visible);
        return this;
    }

    @Step("I check {residualSum} is displayed correctly in cart block")
    public ProductCardPage checkCartBlockResidualSum(String residualSum) {
        elsCartBlockItemInfo.find(Condition.text(residualSum))
                .shouldBe(Condition.visible);
        return this;
    }

    @Step("I check {monthTerm} is displayed correctly in cart block")
    public ProductCardPage checkCartBlockMonthTerm(String monthTerm) {
        elsCartBlockItemInfo.find(Condition.text(monthTerm))
                .shouldBe(Condition.visible);
        return this;
    }

    @Step("I check {monthPay} is displayed correctly in cart block")
    public ProductCardPage checkCartBlockMonthPay(String monthPay) {
        elsCartBlockItemInfo.find(Condition.text(monthPay))
                .shouldBe(Condition.visible);
        return this;
    }

    @Step("I click BackToCatalogButton")
    public ProductCardPage clickBackToCatalogButton() {
        elBackToCatalogButton.click();
        return this;
    }

    @Step("I check URL contains {url}")
    public ProductCardPage checkUrlContains(String url) {
        new WebDriverWait(WebDriverRunner.getWebDriver(), 10).until(urlContains(url));
        return this;
    }

    @Step("I click buy button")
    public ProductCardPage clickBuyButton() {
        elBuyButton.click();
        return this;
    }

}
