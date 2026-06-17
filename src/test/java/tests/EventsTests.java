package tests;

import org.junit.jupiter.api.Test;
import pages.*;
import utils.TestData;

import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;

public class EventsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    MainPage mainPage = new MainPage();
    EventsPage eventsPage = new EventsPage();
    ModalCalendarPage modalCalendarPage = new ModalCalendarPage();

    @Test
    void filterEventsByDate() {

        step("открыть страницу с формой авторизации", () -> {
            registrationPage.openPage();
        });

        step("ввести логин и пароль", () -> {
            registrationPage.login(login)
                    .password(password);
        });

        step("нажать на кнопку Войти", () -> {
            registrationPage.submitClick();
        });

        step("нажать на кнопку Видеоархив", () -> {
            mainPage.sectionClick("События");
        });

        step("нажать на кнопку Фильтр", () -> {
            eventsPage.clickFilterButton();
        });

        step("нажать на поле События за", () -> {
            eventsPage.clickInputEventsForDate();
        });

        step("выбрать день", () -> {
            modalCalendarPage.selectRandomDateInCurrentMonth();
        });

        step("проверить правильность фильтрации по дате или отображения заглушки", () -> {
            eventsPage.verifyEventsByDateOrPlaceholder(modalCalendarPage.getSelectedDate());
        });

    }
}
