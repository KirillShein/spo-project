package pages;

import com.codeborne.selenide.SelenideElement;
import utils.TestData;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CardUserPage {

    TestData testData = new TestData();

    private SelenideElement buttonDeleteUser = $x("//button[text()='Фильтр']"),
                            inputLastName = $("#lastName"),
                            inputFirtsName = $("#firstName"),
                            inputPatronymic = $("#patronymic"),
                            inputDepartment = $("#department"),
                            chapterRoleText = $x("//span[contains(text(), 'Укажите роль пользователя')]"),
                            buttonRoleUser = $x("//button[text()='" + testData.roleUser + "']"),
                            inputLogin = $("#login"),
                            inputPassword = $("#password"),
                            inputConfirmePassword = $("#confirmedPassword"),
                            buttonSaveUser = $x("//button[text()='Сохранить']");

    public CardUserPage checkingForMissingPartition(String chapterName) {
        $x("//li[contains(text(), '" + chapterName + "')]").shouldBe(hidden);

        return this;
    }

    public CardUserPage checkingForMissingButtonDeleteUser() {
        buttonDeleteUser.shouldBe(hidden);

        return this;
    }

    public CardUserPage setLastName(String value) {
        inputLastName.setValue(value);

        return this;
    }

    public CardUserPage setFirstName(String value) {
        inputFirtsName.setValue(value);

        return this;
    }

    public CardUserPage setPatronymic(String value) {
        inputPatronymic.setValue(value);

        return this;
    }

    public CardUserPage setDepartment(String value) {
        inputDepartment.setValue(value);

        return this;
    }

    public CardUserPage clickChapterRole() {
        chapterRoleText.click();

        return this;
    }

    public CardUserPage clickButtonRole() {
        buttonRoleUser.click();

        return this;
    }

    public CardUserPage setLogin(String value) {
        inputLogin.setValue(value);

        return this;
    }

    public CardUserPage setPassword(String value) {
        inputPassword.setValue(value);

        return this;
    }

    public CardUserPage setPasswordConfirme(String value) {
        inputConfirmePassword.setValue(value);

        return this;
    }

    public CardUserPage clickButtonSave() {
        buttonSaveUser.click();

        return this;
    }


}
