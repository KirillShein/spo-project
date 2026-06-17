package pages;

import com.codeborne.selenide.SelenideElement;
import utils.TestData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class EventsPage  {

    TestData testData = new TestData();

    private SelenideElement filterButton = $x("//button[text()='Фильтр']"),
                            eventPlaceholder = $x("//div[contains(text(), '" + testData.eventsPlaceholderText + "')]");




    public EventsPage clickFilterButton() {
        filterButton.click();

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

    public EventsPage verifyEventsByTypeOrPlaceholder(String selectedOneCheckbox) {

        if (eventPlaceholder.isDisplayed()) {
            verifyEventPlaceholder();
        } else {
            verifyEventsByOneType(selectedOneCheckbox);
        }

        return this;
    }

    public EventsPage verifyEventsByMultipleTypeOrPlaceholder(List<String> eventTypes) {

        if (eventPlaceholder.isDisplayed()) {
            verifyEventPlaceholder();
        } else {
            verifyEventsByMultipleTypes(eventTypes);
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

    public EventsPage verifyEventsByOneType(String selectedOneCheckbox) {

        $x("// span[contains(text(), '" + selectedOneCheckbox + "')]").shouldBe(visible);

        return this;
    }

    public EventsPage verifyEventsByMultipleTypes(List<String> eventTypes) {
        for (String type : eventTypes) {
            verifyEventsByOneType(type);
        }
        return this;
    }
}
