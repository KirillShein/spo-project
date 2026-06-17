package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class ModalLogoutPage {

    private SelenideElement modalLogout = $x("//h2[text()='Выход']/ancestor::div[@role='dialog']"),
                            noButtonModalLogout = $x("//button[normalize-space()='Нет']"),
                            yesButton = modalLogout.$x(".//button[normalize-space()='Да']");

    public ModalLogoutPage openModalLogout() {
        modalLogout.shouldBe(visible);

        return this;
    }

    public ModalLogoutPage closedModalLogout() {
        Selenide.executeJavaScript("arguments[0].remove();", modalLogout);
        return this;
    }

    public ModalLogoutPage clickYesButtonModalLogout() {
        yesButton.shouldBe(visible, Duration.ofSeconds(10));
        yesButton.click();

        modalLogout.shouldBe(hidden, Duration.ofSeconds(5));

        return this;
    }

    public ModalLogoutPage clickNoButtonModalLogout() {

        Selenide.executeJavaScript("arguments[0].click();", noButtonModalLogout);
        return this;
    }

}
