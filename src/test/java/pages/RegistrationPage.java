package pages;

import com.codeborne.selenide.SelenideElement;



import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private SelenideElement loginInput = $("#login"),
                            passwordInput = $("#password"),
                            submitForm = $("button[type='submit']"),
                            authorizationModal = $("div[role='dialog']"),
                            wrongModal = $(".jss6.MuiBox-root"),
                            titleWrongModal = $("#parent-modal-title"),
                            descriptionWrongModal = $("#parent-modal-description"),
                            buttonWrongModal = $x("//button[text()='ОК']");



    public RegistrationPage openPage() {
        open("");

        return this;
    }

    public RegistrationPage login(String value) {
        loginInput.setValue(value);

        return this;
    }

    public RegistrationPage password(String value) {
        passwordInput.setValue(value);

        return this;
    }

    public RegistrationPage submitClick() {
        submitForm.click();

        return this;
    }


    public RegistrationPage openModalWrong() {
        wrongModal.shouldBe(visible);

        return this;
    }

    public RegistrationPage titleWrongModal(String value) {
        titleWrongModal.shouldHave(exactText(value));

        return this;
    }

    public RegistrationPage descWrongModal(String value) {
        descriptionWrongModal.shouldHave(exactText(value));

        return this;
    }

    public RegistrationPage clickButtonWrongModal() {
        buttonWrongModal.click();

        return this;
    }

    public RegistrationPage closeWrongModal() {
        wrongModal.shouldBe(hidden);

        return this;
    }

    public RegistrationPage checkAuthozationModal() {
        authorizationModal.shouldBe(visible);

        return this;
    }

}
