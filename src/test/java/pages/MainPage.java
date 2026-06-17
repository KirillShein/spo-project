package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.CollectionCondition.size;
import java.time.Duration;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class MainPage {

    private SelenideElement selectRegords = $("select.MuiNativeSelect-select");

    private ElementsCollection sectionName = $$(".MuiListItemText-root"),
                               videoRecordingsItems = $$(".MuiListItem-root");



    public MainPage checkSectionsPresence(String value) {
        Selenide.executeJavaScript("arguments[0].click();", sectionName.findBy(text(value)));
        return this;
    }


    public MainPage sectionClick(String value) {
        sectionName.findBy(text(value)).click();

        return this;
    }



    public MainPage clickRecordSelect() {
        selectRegords.click();

        return this;
    }

    public MainPage choiseSelectOption(int index) {
        selectRegords.selectOption(index);

        return this;
    }

    public MainPage verifyItemsCountLessOrEqualTo100(int count) {
        videoRecordingsItems.shouldHave(size(count));
        return this;
    }

    public MainPage scrollToEndAndVerifyLastRecordNumber(int expectedLastNumber) {
        // Прокручиваем до конца несколько раз
        for (int i = 0; i < 10; i++) {
            Selenide.executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
            sleep(500);
        }

        // Ищем элемент с номером 100
        SelenideElement record100 = $x("//span[contains(text(), '100.')]");
        record100.shouldBe(visible, Duration.ofSeconds(10));

        System.out.println("Запись №100 найдена: " + record100.getText());

        return this;
    }
}
