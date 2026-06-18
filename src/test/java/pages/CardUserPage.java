package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Selenide.$x;

public class CardUserPage {

    private SelenideElement buttonDeleteUser = $x("//button[text()='Фильтр']");

    public CardUserPage checkingForMissingPartition(String chapterName) {
        $x("//li[contains(text(), '" + chapterName + "')]").shouldBe(hidden);

        return this;
    }

    public CardUserPage checkingForMissingButtonDeleteUser() {
        buttonDeleteUser.shouldBe(hidden);

        return this;
    }


}
