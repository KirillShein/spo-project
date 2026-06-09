package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private SelenideElement modalLogout = $x("//h2[text()='Выход']/ancestor::div[@role='dialog']"),
                            yesButtonModalLogout = $x("//button[normalize-space()='Да']"),
                            noButtonModalLogout = $x("//button[normalize-space()='Нет']");



    private ElementsCollection sectionName = $$(".MuiListItemText-root");

    public MainPage checkSectionsPresence(String value) {
        sectionName.findBy(text(value));

        return this;
    }

    public MainPage logoutSectionClick(String value) {
        sectionName.findBy(text(value)).click();

        return this;
    }

    public MainPage openModalLogout() {
        modalLogout.shouldBe(visible, Duration.ofSeconds(10));

        return this;
    }


    public MainPage closedModalLogout() {
        modalLogout.shouldBe(hidden);

        return this;
    }

    public MainPage clickYesButtonModalLogout() {
        yesButtonModalLogout.click();

        return this;
    }

    public MainPage clickNoButtonModalLogout() {
        noButtonModalLogout.click();

        return this;
    }




}
