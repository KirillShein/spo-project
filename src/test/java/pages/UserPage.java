package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import utils.TestData;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;



public class UserPage {

    TestData testData = new TestData();

    private SelenideElement searchInput = $("#findUser"),
                            userName = $x("//h4[contains(text(), '" + testData.nameUser + "')]"),
                            userTabPlaceholder = $x("//div[contains(text(), '" + testData.userTabPlaceholderText + "')]"),
                            iconCleanSearch = $("[data-testid='ClearRoundedIcon']"),
                            administratorUser = $x("//h4[contains(text(), 'Администратор')]"),
                            buttonCreateUser = $x("//button[text()='Добавить']");

    private ElementsCollection usersItem = $$x("//div[contains(text(), 'Добавлен:')]");


    public UserPage enterIntoSearch(String value) {
        searchInput.setValue(value);

        return this;
    }

    public UserPage verifyUser() {
        userName.shouldBe(visible);

        return this;
    }

    public UserPage verifyUserTabPlaceholder() {
        userTabPlaceholder.shouldBe(visible);

        return this;
    }

    public UserPage clickIconClearSearch() {
        iconCleanSearch.click();

        return this;
    }

    public UserPage verifyUSersItems() {
        usersItem.shouldHave(sizeGreaterThan(2));

        return this;
    }

    public UserPage clickAdministratorItem() {
        administratorUser.click();

        return this;
    }

    public UserPage clickButtonCreateUser() {
        buttonCreateUser.click();

        return this;
    }

    public UserPage verifyCreatedUser(String firstName) {
        $x("//h4[contains(text(), '" + firstName + "')]").shouldBe(visible);

        return this;
    }



}
