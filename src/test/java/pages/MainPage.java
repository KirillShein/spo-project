package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.CollectionCondition.size;
import java.time.Duration;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class MainPage {

    private SelenideElement modalLogout = $x("//h2[text()='Выход']/ancestor::div[@role='dialog']"),
                            noButtonModalLogout = $x("//button[normalize-space()='Нет']"),
                            selectRegords = $("select.MuiNativeSelect-select"),
                            iconNoBlockedDeleteFile = $("[data-testid='LockOpenIcon']"),
                            iconYesBlockDeleteFile = $("[data-testid='HttpsIcon']"),
                            selectFoto = $x("//select[.//option[text()='Фото']]"),
                            buttonFilter = $x("//button[text()='Фильтр']"),
                            inputNameFilter = $("#archiveUserName"),
                            buttonSearch = $x("//button[text()='Поиск']"),
                            inputCodeEmployyeFilter = $("#archiveCode"),
                            inputCameraFilter = $("#arhiveCameraId");





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

    public MainPage clickIconNoBlockDeleteFile() {
        iconNoBlockedDeleteFile.click();

        return this;
    }

    public MainPage checkIconChangeYesBlocked() {
        iconYesBlockDeleteFile.shouldBe(visible);

        return this;
    }

    public MainPage clickIconYesBlockDeleteFile() {
        iconYesBlockDeleteFile.click();

        return this;
    }

    public MainPage checkIconChangeNoBlocked() {
        iconNoBlockedDeleteFile.shouldBe(visible);

        return this;
    }

    public MainPage clickSelectFoto(String value) {
        selectFoto.selectOption(value);

        return this;
    }

    public  MainPage clickButtonFilter() {
        buttonFilter.click();

        return this;
    }

    public MainPage inputName(String value) {
        inputNameFilter.setValue(value);

        return this;
    }

    public MainPage clickOutside() {
        $("body").click();
        return this;
    }

    public MainPage verifyEmployeeName(String employeeName) {
        $x("//div[contains(text(), '" + employeeName + "')]").shouldBe(visible);
        return this;
    }

    public  MainPage clickButtonSearch() {
        buttonSearch.click();

        return this;
    }

    public MainPage inputCodeEmployee(String value) {
        inputCodeEmployyeFilter.setValue(value);

        return this;
    }

    public MainPage inputCamera(String value) {
        inputCameraFilter.setValue(value);

        return this;
    }

    public MainPage verifyEmployeeCamera(String employeeCamera) {
        $x("//div[contains(text(), 'Камера № " + employeeCamera + "')]").shouldBe(visible);
        return this;
    }





}
