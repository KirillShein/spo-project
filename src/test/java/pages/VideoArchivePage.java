package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import utils.TestData;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;

public class VideoArchivePage {

    TestData testData = new TestData();

    private SelenideElement iconNoBlockedDeleteFile = $("[data-testid='LockOpenIcon']"),
                            iconYesBlockDeleteFile = $("[data-testid='HttpsIcon']"),
                            selectFoto = $x("//select[.//option[text()='Фото']]"),
                            buttonFilter = $x("//button[text()='Фильтр']"),
                            employeeName = $x("//div[contains(text(), '" + testData.nameUser + "')]"),
                            employeeCamera = $x("//div[contains(text(), 'Камера № " + testData.numberCamera + "')]");



    private ElementsCollection sectionName = $$(".MuiListItemText-root"),
            videoRecordingsItems = $$(".MuiListItem-root");



    public VideoArchivePage clickIconNoBlockDeleteFile() {
        iconNoBlockedDeleteFile.click();

        return this;
    }

    public VideoArchivePage checkIconChangeYesBlocked() {
        iconYesBlockDeleteFile.shouldBe(visible);

        return this;
    }

    public VideoArchivePage clickIconYesBlockDeleteFile() {
        iconYesBlockDeleteFile.click();

        return this;
    }

    public VideoArchivePage checkIconChangeNoBlocked() {
        iconNoBlockedDeleteFile.shouldBe(visible);

        return this;
    }

    public  VideoArchivePage clickButtonFilter() {
        buttonFilter.click();

        return this;
    }

    public VideoArchivePage clickOutside() {
        $("body").click();

        return this;
    }

    public VideoArchivePage verifyEmployeeName() {
        employeeName.shouldBe(visible);

        return this;
    }

    public VideoArchivePage verifyEmployeeCamera() {
        employeeCamera.shouldBe(visible);
        return this;
    }
}
