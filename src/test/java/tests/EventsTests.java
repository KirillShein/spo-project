package tests;

import org.junit.jupiter.api.Test;
import pages.*;


import java.util.List;

import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;

public class EventsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    MainPage mainPage = new MainPage();
    EventsPage eventsPage = new EventsPage();
    FilterModalEvensPage filterModalEvensPage = new FilterModalEvensPage();
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

        step("нажать на кнопку События", () -> {
            mainPage.sectionClick("События");
        });

        step("нажать на кнопку Фильтр", () -> {
            eventsPage.clickFilterButton();
        });

        step("нажать на поле События за", () -> {
            filterModalEvensPage.clickInputEventsForDate();
        });

        step("выбрать день", () -> {
            modalCalendarPage.selectRandomDateInCurrentMonth();
        });

        step("проверить правильность фильтрации по дате или отображения заглушки", () -> {
            eventsPage.verifyEventsByDateOrPlaceholder(modalCalendarPage.getSelectedDate());
        });
    }

    @Test
    void filterEventsByOneTypeEvent() {

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

        step("нажать на кнопку События", () -> {
            mainPage.sectionClick("События");
        });

        step("нажать на кнопку Фильтр", () -> {
            eventsPage.clickFilterButton();
        });

        step("нажать на поле События", () -> {
            filterModalEvensPage.clickInputTypeEvent();
        });

        step("выбрать один тип события", () -> {
           filterModalEvensPage.selectRandomSingleCheckbox();
        });

        step("проверить правильность фильтрации по  выбранному типу события или отображения заглушки", () -> {
            eventsPage.verifyEventsByTypeOrPlaceholder(filterModalEvensPage.getSelectedOneTypeEvent());
        });
    }

    @Test
    void filterEventsBySeveralTypeEvent() {

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

        step("нажать на кнопку События", () -> {
            mainPage.sectionClick("События");
        });

        step("нажать на кнопку Фильтр", () -> {
            eventsPage.clickFilterButton();
        });

        step("нажать на поле События", () -> {
            filterModalEvensPage.clickInputTypeEvent();
        });

        step("выбрать несколько типов события", () -> {
            filterModalEvensPage.selectRandomMultipleCheckboxes(3);
        });

        step("проверить, что отображаются события выбранных типов", () -> {
            List<String> selectedTypes = filterModalEvensPage.getSelectedMultipleCheckboxes();
            eventsPage.verifyEventsByMultipleTypeOrPlaceholder(selectedTypes);
        });


    }

    @Test
    void filterEventsByDateAndOneTypeEvent() {

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

        step("нажать на кнопку События", () -> {
            mainPage.sectionClick("События");
        });

        step("нажать на кнопку Фильтр", () -> {
            eventsPage.clickFilterButton();
        });

        step("нажать на поле События за", () -> {
            filterModalEvensPage.clickInputEventsForDate();
        });

        step("выбрать день", () -> {
            modalCalendarPage.selectRandomDateInCurrentMonth();
        });

        step("нажать на поле События", () -> {
            filterModalEvensPage.clickInputTypeEvent();
        });

        step("выбрать один тип события", () -> {
            filterModalEvensPage.selectRandomSingleCheckbox();
        });

        step("проверить правильность фильтрации по  выбранному типу события или отображения заглушки", () -> {
            eventsPage.verifyEventsByTypeOrPlaceholder(filterModalEvensPage.getSelectedOneTypeEvent());
        });


        step("проверить правильность фильтрации по дате или отображения заглушки", () -> {
            eventsPage.verifyEventsByDateOrPlaceholder(modalCalendarPage.getSelectedDate());
        });

        sleep(5000);

    }

}
