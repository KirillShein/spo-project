package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class FieldErrorModalPage {

    private SelenideElement descriptionErrorModal = $("#parent-modal-description"),
                            buttonClosedErrorModal = $x("//button[text()='ОК']");

    public FieldErrorModalPage verifyOpenErrorModal(String textDecription) {
        descriptionErrorModal.shouldBe(exactText(textDecription));

        return this;
    }

    public FieldErrorModalPage clickClosedErrorModal() {
        buttonClosedErrorModal.click();

        return this;
    }

    public FieldErrorModalPage verifyClosedErrorModal() {
        descriptionErrorModal.shouldBe(hidden);

        return this;
    }
}
