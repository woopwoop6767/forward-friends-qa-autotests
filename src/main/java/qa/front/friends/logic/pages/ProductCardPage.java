package qa.front.friends.logic.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import qa.front.friends.logic.pojo.PriceItemTestData;

import static com.codeborne.selenide.Selenide.$x;

public class ProductCardPage {


    private SelenideElement elBackToCatalogButton = $x("//app-button[@title='Назад к списку']//button[1]");
    private SelenideElement elBuyButton = $x("//app-button[@title='Оформить']//button[1]");


    @Step("I click {itemFirstVolume} radio button")
    private ProductCardPage clickVolumeRadioButton(String itemVolume) {
        SelenideElement elVolumeRadioButton = $x("//*[contains(text(), '" + itemVolume + "')]//ancestor::app-radio-element[1]");
        elVolumeRadioButton.click();
        return this;
    }

    @Step("I click {itemColor} radio button")
    private ProductCardPage clickCoverColorRadioButton(String itemColor) {
        SelenideElement elCoverColorRadioButton = $x("//*[contains(text(), '" + itemColor + "')]//ancestor::app-radio-element[1]");
        elCoverColorRadioButton.click();
        return this;
    }

    @Step("I set up item options")
    public ProductCardPage setItemOptions(String itemVolume, String itemColor) {
        clickVolumeRadioButton(itemVolume);
        clickCoverColorRadioButton(itemColor);
        return this;
    }

    @Step("I check leasing prices info is displayed correctly")
    public ProductCardPage checkLeasingPricesInfoBlock(PriceItemTestData priceItemTestData) {
        SelenideElement elCartTotalCostDisplay = $x("//*[@data-test='cart-block']//*[contains(text(), '" + priceItemTestData.getItemName() +"')]/..//*[text()='" + priceItemTestData.getTotalCost() + "']");
        SelenideElement elCartCoverColorDistplay = $x("//*[@data-test='cart-block']//*[contains(text(), '" + priceItemTestData.getColor() + "')]");
        SelenideElement elCartLeasingSumDisplay = $x("//*[@data-test='cart-block']//*[text()='Общая сумма договора']/..//*[contains(text(), '" + priceItemTestData.getLeasingSum() + "')]");
        SelenideElement elCartResidualSumDisplay = $x("//*[@data-test='cart-block']//*[text()='Остаточная стоимость']/..//*[contains(text(), '" + priceItemTestData.getResidualSum() +"')]");
        SelenideElement elCartMonthPay = $x("//*[@data-test='cart-block']//*[text()='Сумма к оплате']/..//*[contains(text(), '" + priceItemTestData.getMonthPay() + "')]");
        elCartTotalCostDisplay.shouldBe(Condition.visible);
        elCartCoverColorDistplay.shouldBe(Condition.visible);
        elCartLeasingSumDisplay.shouldBe(Condition.visible);
        elCartResidualSumDisplay.shouldBe(Condition.visible);
        elCartMonthPay.shouldBe(Condition.visible);
        return this;
    }



}
