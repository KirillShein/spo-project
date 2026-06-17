package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import utils.TestData;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VideoArchivePage {

    TestData testData = new TestData();

    private SelenideElement iconNoBlockedDeleteFile = $("[data-testid='LockOpenIcon']"),
                            iconYesBlockDeleteFile = $("[data-testid='HttpsIcon']"),
                            buttonFilter = $x("//button[text()='Фильтр']"),
                            employeeName = $x("//div[contains(text(), '" + testData.nameUser + "')]"),
                            employeeCamera = $x("//div[contains(text(), 'Камера № " + testData.numberCamera + "')]"),
                            videoArchivePlaceholder = $x("//div[contains(text(), '" + testData.videoArchivePlaceholderText + "')]"),
                            selectSortVideoAndFoto = $x("//select[.//option[text()='Видео/Фото']]"),
                            selectSortFoto = $x("//select[.//option[text()='Фото']]"),
                            onePhotoIcon = $("[data-testid='LocalSeeIcon']"),
                            photoImage = $("img[alt='фото_режим']"),
                            oneVideoIcon = $("[data-testid='OndemandVideoIcon']"),
                            video = $("video");




    private ElementsCollection sectionName = $$(".MuiListItemText-root"),
                               videoRecordingsItems = $$(".MuiListItem-root"),
                               fotoIcons = $$("[data-testid='LocalSeeIcon']"),
                               videoIcons = $$("[data-testid='OndemandVideoIcon']");



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

    public VideoArchivePage verifyPlaceholderText() {
        videoArchivePlaceholder.shouldBe(visible);

        return this;
    }

    public VideoArchivePage clickSortVideoAndFoto() {
        selectSortVideoAndFoto.click();

        return this;
    }

    public VideoArchivePage clickSortFoto() {
        selectSortFoto.selectOption("Фото");

        return this;
    }

    public VideoArchivePage clickSortVideo() {
        selectSortFoto.selectOption("Видео");

        return this;
    }

    public VideoArchivePage verifyFotoRecords() {
        videoIcons.shouldHave(size(0));

        return this;
    }

    public VideoArchivePage verifyVideoRecords() {
        fotoIcons.shouldHave(size(0));

        return this;
    }

    public VideoArchivePage clickItemWithPhoto() {
        onePhotoIcon.click();

        return this;
    }

    public VideoArchivePage verifyImageOpened() {
        // 1. Проверяем, что картинка видима
        photoImage.shouldBe(visible, Duration.ofSeconds(15));

        // 2. Проверяем, что картинка загружена (complete = true)
        boolean isLoaded = Boolean.TRUE.equals(Selenide.executeJavaScript("""
                    var img = arguments[0];
                    return img.complete && img.naturalWidth > 0 && img.naturalHeight > 0;
                """, photoImage));

        assertTrue(isLoaded, "Картинка не загружена или повреждена");

        // 3. Проверяем, что src не пустой
        String src = photoImage.getAttribute("src");
        assertNotNull(src, "Атрибут src отсутствует");
        assertFalse(src.isEmpty(), "Атрибут src пустой");

        return this;
    }

    public VideoArchivePage clickItemWithVideo() {
        oneVideoIcon.click();

        return this;
    }

    public VideoArchivePage verifyVideoOpened() {
        // 1. Видео видимо на экране
        video.shouldBe(visible, Duration.ofSeconds(15));

        // 2. Видео загружено и готово к показу
        boolean isReady = Boolean.TRUE.equals(Selenide.executeJavaScript("""
                    var video = arguments[0];
                    return video.readyState >= 2;
                """, video));

        if (!isReady) {
            System.out.println("Видео не загружено, ожидаем...");
            sleep(2000);
            isReady = Boolean.TRUE.equals(Selenide.executeJavaScript("""
                        var video = arguments[0];
                        return video.readyState >= 2;
                    """, video));
        }

        assertTrue(isReady, "Видео не загружено");

        // 3. Видео воспроизводится
        boolean isPlaying = Boolean.TRUE.equals(Selenide.executeJavaScript("""
                    var video = arguments[0];
                    return !video.paused && video.currentTime > 0;
                """, video));

        if (!isPlaying) {
            // Пробуем запустить видео
            Selenide.executeJavaScript("arguments[0].play();", video);
            sleep(1000);
            isPlaying = Boolean.TRUE.equals(Selenide.executeJavaScript("""
                        var video = arguments[0];
                        return !video.paused && video.currentTime > 0;
                    """, video));
        }

        assertTrue(isPlaying, "Видео не воспроизводится");

        return this;
    }

    public VideoArchivePage verifyRecordsMatchDateAndTimeFilter(LocalDate selectedDate, String selectedTime) {
        // Находим все записи
        ElementsCollection records = $$(".MuiListItem-root");

        if (records.isEmpty()) {
            System.out.println("Нет записей для проверки");
            return this;
        }

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        for (SelenideElement record : records) {
            try {
                // Ищем элемент с датой через XPath
                SelenideElement dateElement = record.$x(".//div[contains(text(), ',') and contains(text(), ':')]");
                String dateTimeText = dateElement.getText();

                System.out.println("Текст даты и времени: " + dateTimeText);

                // Парсим дату и время
                String[] parts = dateTimeText.split(",");
                String datePart = parts[0].trim();
                String timePart = parts[1].trim().split(" - ")[0];

                LocalDate recordDate = LocalDate.parse(datePart, dateFormatter);

                // Проверяем дату
                boolean dateMatch = recordDate.isAfter(selectedDate) || recordDate.isEqual(selectedDate);
                assertTrue(dateMatch,
                        "Запись с датой " + recordDate + " не соответствует фильтру (дата должна быть >= " + selectedDate + ")");

                // Проверяем время
                if (recordDate.isEqual(selectedDate)) {
                    boolean timeMatch = timePart.compareTo(selectedTime) >= 0;
                    assertTrue(timeMatch,
                            "Запись с временем " + timePart + " не соответствует фильтру (время должно быть >= " + selectedTime + ")");
                }

            } catch (Exception e) {
                System.out.println("Не удалось распарсить запись: " + record.getText());
            }
        }

        return this;
    }
}
