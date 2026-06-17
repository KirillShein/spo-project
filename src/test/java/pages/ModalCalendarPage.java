package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class ModalCalendarPage {

    private SelenideElement buttonNowDate = $x("//button[text()='Сегодня']"),
                            pencilIcon = $("[data-testid='PenIcon']"),
                            installButton = $x("//button[text()='Установить']");


    private ElementsCollection days = $$(".MuiPickersDay-root:not(.MuiPickersDay-hiddenDaySpacingFiller)"),
                               hourOptions = $$("[role='option']");


    private LocalDate selectedDate;
    private String selectedTime;


    public ModalCalendarPage clickButtonNowDate() {
        buttonNowDate.click();

        return this;
    }

    public ModalCalendarPage clickPencilIcon() {
        pencilIcon.click();

        return this;
    }

    public ModalCalendarPage selectRandomDateInCurrentMonth() {
        LocalDate today = LocalDate.now();
        List<SelenideElement> activeDays = new ArrayList<>();
        List<LocalDate> validDates = new ArrayList<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM yyyy", new Locale("ru"));

        for (SelenideElement day : days) {
            String ariaLabel = day.getAttribute("aria-label");
            if (ariaLabel == null || ariaLabel.isEmpty()) continue;

            try {
                String dateStr = ariaLabel.replace(" г.", "");
                LocalDate date = LocalDate.parse(dateStr, formatter);

                if (!date.isAfter(today)) {
                    activeDays.add(day);
                    validDates.add(date);
                }
            } catch (Exception e) {
                // Пропускаем дни с неправильным форматом
            }
        }

        if (activeDays.isEmpty()) {
            throw new RuntimeException("Нет доступных дней (все дни в будущем или отсутствуют)");
        }

        Random random = new Random();
        int randomIndex = random.nextInt(activeDays.size());
        selectedDate = validDates.get(randomIndex);
        activeDays.get(randomIndex).click();

        return this;
    }

    public ModalCalendarPage selectRandomTime() {
        if (hourOptions.isEmpty()) {
            throw new RuntimeException("Часы не найдены");
        }

        // Фильтруем только видимые часы
        List<SelenideElement> visibleHours = new ArrayList<>();
        for (SelenideElement hour : hourOptions) {
            if (hour.isDisplayed() && hour.isEnabled() && !hour.getText().isEmpty()) {
                visibleHours.add(hour);
            }
        }

        if (visibleHours.isEmpty()) {
            throw new RuntimeException("Нет доступных часов");
        }

        Random random = new Random();
        SelenideElement selectedHour = visibleHours.get(random.nextInt(visibleHours.size()));
        selectedTime = selectedHour.getText() + ":00";

        // Клик через JavaScript
        Selenide.executeJavaScript("arguments[0].click();", selectedHour);

        return this;
    }

    public ModalCalendarPage clickInstallButton() {
        installButton.click();

        return this;
    }

    public LocalDate getSelectedDate() {
        return selectedDate;
    }


    public String getSelectedTime() {
        return selectedTime;
    }
}
