package qa.front.friends.logic.pages;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.WebDriverWait;
import qa.front.friends.logic.WebElementsCollectionHandler;
import qa.front.friends.logic.api.SelfieUploader;

import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;

public class ProductCardPage implements WebElementsCollectionHandler, SelfieUploader {


    private SelenideElement elBackToCatalogButton = $x("//app-button[@title='Назад к списку']//button");
    private SelenideElement elBuyButton = $x("//app-button[@title='Оформить']//button[1]");
    private SelenideElement elCartBlockItemValueInfo = $x("//*[@data-test='product-price']/../*[1]");
    private ElementsCollection elsOptionsRadioBtns= $$x("//*[@class='name-item' and //app-radio-element[@data-test='radio-point']]");
    private SelenideElement elProductPriceInfo = $x("//*[@data-test='product-price']");
    private SelenideElement elProductColorInfo = $x("//*[@data-test='product-color']");
    private SelenideElement elProductDeliveryTypeInfo = $x("//*[@data-test='product-delivery']");
    private SelenideElement elProductTotalAmountInfo = $x("//*[@data-test='total-amount']");
    private SelenideElement elProductResidualSumInfo = $x("//*[@data-test='residual-sum']");
    private SelenideElement elProductMonthTermInfo = $x("//*[@data-test='month-term']");
    private SelenideElement elProductAmountPayInfo = $x("//*[@data-test='amount-pay']");


    @Step("I click {optionValue} radio button")
    public ProductCardPage clickOptionsRadioBtn(String optionValue) {
        elsOptionsRadioBtns.find(Condition.text(optionValue))
                .click();
        return this;
    }

    @Step("I check {itemValue} is displayed correctly in cart block")
    public ProductCardPage checkCartBlockItemValue(String itemValue) {
        elCartBlockItemValueInfo.shouldBe(Condition.visible)
                .shouldHave(Condition.text(itemValue));
        return this;
    }

    @Step("I check {productPrice} is displayed correctly in cart block")
    public ProductCardPage checkProductPriceInfo(String productPrice) {
        elProductPriceInfo.shouldBe(Condition.visible)
                .shouldHave(Condition.text(productPrice));
        return this;
    }

    @Step("I check {productColor} is displayed correctly in cart block")
    public ProductCardPage checkProductColorInfo(String productColor) {
        elProductColorInfo.shouldBe(Condition.visible)
                .shouldHave(Condition.text(productColor));
        return this;
    }

    @Step("I check {productResidualSum} is displayed correctly in cart block")
    public ProductCardPage checkProductResidualSumInfo(String productResidualSum) {
        elProductResidualSumInfo.shouldBe(Condition.visible)
                .shouldHave(Condition.text(productResidualSum));
        return this;
    }

    @Step("I check {productMonthTerm} is displayed correctly in cart block")
    public ProductCardPage checkProductMonthTermInfo(String productMonthTerm) {
        elProductMonthTermInfo.shouldBe(Condition.visible)
                .shouldHave(Condition.text(productMonthTerm));
        return this;
    }

    @Step("I check {productDeliveryType} is displayed correctly in cart block")
    public ProductCardPage checkProductDeliveryTypeInfo(String productDeliveryType) {
        elProductDeliveryTypeInfo.shouldBe(Condition.visible)
                .shouldHave(Condition.text(productDeliveryType));
        return this;
    }

    @Step("I check {productTotalAmount} is displayed correctly in cart block")
    public ProductCardPage checkProductTotalAmountInfo(String productTotalAmount) {
        elProductTotalAmountInfo.shouldBe(Condition.visible)
                .shouldHave(Condition.text(productTotalAmount));
        return this;
    }

    @Step("I check {productAmountPay} is displayed correctly in cart block")
    public ProductCardPage checkProductAmountPayInfo(String productAmountPay) {
        elProductAmountPayInfo.shouldBe(Condition.visible)
                .shouldHave(Condition.text(productAmountPay));
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
