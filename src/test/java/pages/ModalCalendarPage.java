package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ModalCalendarPage {

    private SelenideElement buttonNowDate = $x("//button[text()='Сегодня']");

    public ModalCalendarPage clickButtonNowDate() {
        buttonNowDate.click();

        return this;
    }
}
