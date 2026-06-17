package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import utils.TestData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class EventsPage  {

    TestData testData = new TestData();

    private SelenideElement filterButton = $x("//button[text()='Фильтр']"),
                            inputEventsForDate = $x("//label[text()='События за']/following-sibling::div//input"),
                            eventPlaceholder = $x("//div[contains(text(), '" + testData.eventsPlaceholderText + "')]");

    private ElementsCollection eventsList = $$(".MuiListItem-root");

    public EventsPage clickFilterButton() {
        filterButton.click();

        return this;
    }

    public EventsPage clickInputEventsForDate() {
        inputEventsForDate.click();

        return this;
    }

    public EventsPage verifyEventsByDateOrPlaceholder(LocalDate selectedDate) {

        if (eventPlaceholder.isDisplayed()) {
            verifyEventPlaceholder();
        } else {
            verifyEventsByDate(selectedDate);
        }

        return this;
    }

    public EventsPage verifyEventsByDate(LocalDate selectedDate) {
        DateTimeFormatter displayFormatter = DateTimeFormatter.ofPattern("d MMMM yyyy", new Locale("ru"));
        String expectedDate = selectedDate.format(displayFormatter);

        $x("//div[contains(text(), '" + expectedDate + "')]").shouldBe(visible);

        return this;
    }

    public EventsPage verifyEventPlaceholder() {
        eventPlaceholder.shouldBe(visible);

        return this;
    }
}
