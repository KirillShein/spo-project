package tests;

import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;

public class VideoArchiveTests extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();
    MainPage mainPage = new MainPage();

    @Test
    void checkRecordsCountIsDisplayed() {
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
            mainPage.sectionClick("Видеоархив");
        });



        step("нажать на селект", () -> {
            mainPage.clickRecordSelect();
        });

        step("выбрать количество отображение записей", () -> {
            mainPage.choiseSelectOption(1);
        });

        step("проскроллить и проверить, что загружено 100 записей", () -> {
            mainPage.scrollToEndAndVerifyLastRecordNumber(100);
        });



        sleep(5000);
    }

    @Test
    void checkingIconBlockDeleteChange() {
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
            mainPage.sectionClick("Видеоархив");
        });

        step("нажать на иконку Открытый замок", () -> {
            mainPage.clickIconNoBlockDeleteFile();
        });

        step("проверить что иконка заменилась на Закрытый замок", () -> {
            mainPage.checkIconChangeYesBlocked();
        });

        step("нажать на иконку Закрытый замок", () -> {
            mainPage.clickIconYesBlockDeleteFile();
        });

        step("проверить что иконка заменилась на Открытый замок", () -> {
            mainPage.checkIconChangeNoBlocked();
        });

    }

    @Test
    void checkingPhotoDisplay() {
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
            mainPage.sectionClick("Видеоархив");
        });

        step("выбрать сортировку по фото", () -> {
            mainPage.clickSelectFoto("фото");
        });

        sleep(5000);
    }

    @Test
    void checkingFilteringByName() {

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
            mainPage.sectionClick("Видеоархив");
        });

        step("нажать на кнопку Фильтр", () -> {
            mainPage.clickButtonFilter();
        });

        step("ввести ФИО сотрудника", () -> {
            mainPage.inputName("Жестаков Максим Мамович");
        });

        step("нажать на кнопку Поиск", () -> {
            mainPage.clickButtonSearch();
        });

        step("кликнуть по месту вне модального окна", ()-> {
            mainPage.clickOutside();
        });

        step("проверить что отобразились записи с Жестаков Максим Мамович", ()-> {
            mainPage.verifyEmployeeName("Жестаков Максим Мамович");
        });
    }

    @Test
    void checkingFilteringByCodeEmployee() {

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
            mainPage.sectionClick("Видеоархив");
        });

        step("нажать на кнопку Фильтр", () -> {
            mainPage.clickButtonFilter();
        });

        step("ввести код сотрудника", () -> {
            mainPage.inputCodeEmployee("1405");
        });

        step("нажать на кнопку Поиск", () -> {
            mainPage.clickButtonSearch();
        });

        step("кликнуть по месту вне модального окна", ()-> {
            mainPage.clickOutside();
        });

        step("проверить что отобразились записи с Бирюков Андрей Сергеевич", ()-> {
            mainPage.verifyEmployeeName("Бирюков Андрей Сергеевич");
        });
    }
}
