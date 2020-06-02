package qa.front.friends.logic.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.NoSuchElementException;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class ProductCardPage {


    private SelenideElement elBackToCatalogButton = $x("//app-button[@title='Назад к списку']//button[1]");
    private SelenideElement elBuyButton = $x("//app-button[@title='Оформить']//button[1]");
    private ElementsCollection elsVolumeRadioButtons = $$x("//*[@data-test='volume-select']//*[@style='display: block;']//*[@data-test='radio-point']");
    private ElementsCollection elsCoverColorRadioButtons = $$x("//*[@data-test='color-select']//*[@data-test='radio-point']");
    private ElementsCollection elsCartBlockItemInfo =$$x("//*[@style='display: block;']//*[@data-test='cart-block']//*[@class='basket-name']");


    @Step("I click {itemVolume} radio button")
    public ProductCardPage clickVolumeRadioButton(String itemVolume) {
        elsVolumeRadioButtons.shouldBe(CollectionCondition.sizeGreaterThan(0)).stream()
                .filter(var -> var.shouldBe(Condition.visible).getText().contains(itemVolume))
                .findFirst().orElseThrow(NoSuchElementException::new).click();
        return this;
    }

    @Step("I click {itemColor} radio button")
    public ProductCardPage clickCoverColorRadioButton(String itemColor) {
        elsCoverColorRadioButtons.shouldBe(CollectionCondition.sizeGreaterThan(0)).stream()
                .filter(var -> var.shouldBe(Condition.visible).getText().contains(itemColor))
                .findFirst().orElseThrow(NoSuchElementException::new).click();
        return this;
    }

    @Step("I check {itemName} and {itemVolume} is displayed correctly in cart block")
    public ProductCardPage checkCartBlockItemInfo(String itemName, String itemVolume) {
        elsCartBlockItemInfo.shouldBe(CollectionCondition.sizeGreaterThan(0)).stream()
                .filter(var -> var.shouldBe(Condition.visible).getText().contains(itemName + " " + itemVolume))
                .findFirst().orElseThrow(NoSuchElementException::new)
                .shouldBe(Condition.visible);
        return this;
    }

    @Step("I check {itemColor} is displayed correctly in cart block")
    public ProductCardPage checkCartBlockColor(String itemColor) {
        elsCartBlockItemInfo.shouldBe(CollectionCondition.sizeGreaterThan(0)).stream()
                .filter(val -> val.shouldBe(Condition.visible).getText().contains("Цвет"))
                .findFirst().orElseThrow(NoSuchElementException::new).$x(".//following-sibling::*[contains(text(),'" + itemColor + "')]")
                .shouldBe(Condition.visible);
        return this;
    }

    @Step("I check {totalCost} is displayed correctly in cart block")
    public ProductCardPage checkCartBlockTotalCost(String totalCost, String itemName, String itemVolume) {
        elsCartBlockItemInfo.shouldBe(CollectionCondition.sizeGreaterThan(0)).stream()
                .filter(val -> val.shouldBe(Condition.visible).getText().contains(itemName + " " + itemVolume))
                .findFirst().orElseThrow(NoSuchElementException::new).$x(".//following-sibling::*[contains(text(),'" + totalCost + "')]")
                .shouldBe(Condition.visible);
        return this;
    }

    @Step("I check {leasingSum} is displayed correctly in cart block")
    public ProductCardPage checkCartBlockLeasingSum(String leasingSum) {
        elsCartBlockItemInfo.shouldBe(CollectionCondition.sizeGreaterThan(0)).stream()
                .filter(var -> var.shouldBe(Condition.visible).getText().contains("Общая сумма договора"))
                .findFirst().orElseThrow(NoSuchElementException::new).$x(".//following-sibling::*[contains(text(),'" + leasingSum + "')]")
                .shouldBe(Condition.visible);
        return this;
    }

    @Step("I check {residualSum} is displayed correctly in cart block")
    public ProductCardPage checkCartBlockResidualSum(String residualSum) {
        elsCartBlockItemInfo.shouldBe(CollectionCondition.sizeGreaterThan(0)).stream()
                .filter(var -> var.shouldBe(Condition.visible).getText().contains("Остаточная стоимость"))
                .findFirst().orElseThrow(NoSuchElementException::new).$x(".//following-sibling::*[contains(text(),'" + residualSum + "')]")
                .shouldBe(Condition.visible);
        return this;
    }

    @Step("I check {monthTerm} is displayed correctly in cart block")
    public ProductCardPage checkCartBlockMonthTerm(String monthTerm) {
        elsCartBlockItemInfo.shouldBe(CollectionCondition.sizeGreaterThan(0)).stream()
                .filter(var -> var.shouldBe(Condition.visible).getText().contains("Количество платежей"))
                .findFirst().orElseThrow(NoSuchElementException::new).$x(".//following-sibling::*[contains(text(),'" + monthTerm + "')]")
                .shouldBe(Condition.visible);
        return this;
    }

    @Step("I check {monthPay} is displayed correctly in cart block")
    public ProductCardPage checkCartBlockMonthPay(String monthPay) {
        elsCartBlockItemInfo.shouldBe(CollectionCondition.sizeGreaterThan(0)).stream()
                .filter(var -> var.shouldBe(Condition.visible).getText().contains("Сумма к оплате"))
                .findFirst().orElseThrow(NoSuchElementException::new).$x(".//following-sibling::*[contains(text(),'" + monthPay + "')]")
                .shouldBe(Condition.visible);
        return this;
    }






}
