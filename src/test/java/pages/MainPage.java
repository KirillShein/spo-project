package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private SelenideElement modalLogout = $x("//h2[text()='Выход']/ancestor::div[@role='dialog']"),
                            noButtonModalLogout = $x("//button[normalize-space()='Нет']");



    private ElementsCollection sectionName = $$(".MuiListItemText-root");



    public MainPage checkSectionsPresence(String value) {
        Selenide.executeJavaScript("arguments[0].click();", sectionName.findBy(text(value)));
        return this;
    }


    public MainPage logoutSectionClick(String value) {
        sectionName.findBy(text(value)).click();

        return this;
    }

    public MainPage openModalLogout() {
        modalLogout.shouldBe(visible);

        return this;
    }

    public MainPage closedModalLogout() {
        Selenide.executeJavaScript("arguments[0].remove();", modalLogout);
        return this;
    }

    public MainPage clickYesButtonModalLogout() {

        SelenideElement yesButton = modalLogout.$x(".//button[normalize-space()='Да']");

        yesButton.shouldBe(visible, Duration.ofSeconds(10));
        yesButton.click();

        modalLogout.shouldBe(hidden, Duration.ofSeconds(5));

        return this;
    }

    public MainPage clickNoButtonModalLogout() {

        Selenide.executeJavaScript("arguments[0].click();", noButtonModalLogout);
        return this;
    }
}
