package qa.front.friends.logic;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.NoSuchElementException;

public interface WebElementsCollectionHandler {


    default SelenideElement getFirstMatchByTextElement(ElementsCollection elementsCollection, String elementByText) {
       return elementsCollection.shouldBe(CollectionCondition.sizeGreaterThan(0)).stream()
                .filter(var -> var.shouldBe(Condition.visible).getText().trim().toLowerCase().contains(elementByText))
                .findFirst().orElseThrow(NoSuchElementException::new);
    }
}
