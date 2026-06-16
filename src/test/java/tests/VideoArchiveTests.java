package tests;

import org.junit.jupiter.api.Test;
import pages.FilterModalVideoArchivePage;
import pages.MainPage;
import pages.RegistrationPage;
import pages.VideoArchivePage;
import utils.TestData;

import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;

public class VideoArchiveTests extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();
    MainPage mainPage = new MainPage();
    VideoArchivePage videoArchivePage = new VideoArchivePage();
    FilterModalVideoArchivePage filterModalVideoArchivePage = new FilterModalVideoArchivePage();
    TestData testData = new TestData();

//    @Test
//    void checkRecordsCountIsDisplayed() {
//        step("открыть страницу с формой авторизации", () -> {
//            registrationPage.openPage();
//        });
//
//        step("ввести логин и пароль", () -> {
//            registrationPage.login(login)
//                    .password(password);
//        });
//
//        step("нажать на кнопку Войти", () -> {
//            registrationPage.submitClick();
//        });
//
//        step("нажать на кнопку Видеоархив", () -> {
//            mainPage.sectionClick("Видеоархив");
//        });
//
//
//
//        step("нажать на селект", () -> {
//            mainPage.clickRecordSelect();
//        });
//
//        step("выбрать количество отображение записей", () -> {
//            mainPage.choiseSelectOption(1);
//        });
//
//        step("проскроллить и проверить, что загружено 100 записей", () -> {
//            mainPage.scrollToEndAndVerifyLastRecordNumber(100);
//        });
//
//
//
//        sleep(5000);
//    }

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
            videoArchivePage.clickIconNoBlockDeleteFile();
        });

        step("проверить что иконка заменилась на Закрытый замок", () -> {
            videoArchivePage.checkIconChangeYesBlocked();
        });

        step("нажать на иконку Закрытый замок", () -> {
            videoArchivePage.clickIconYesBlockDeleteFile();
        });

        step("проверить что иконка заменилась на Открытый замок", () -> {
            videoArchivePage.checkIconChangeNoBlocked();
        });

    }

//    @Test
//    void checkingPhotoDisplay() {
//        step("открыть страницу с формой авторизации", () -> {
//            registrationPage.openPage();
//        });
//
//        step("ввести логин и пароль", () -> {
//            registrationPage.login(login)
//                    .password(password);
//        });
//
//        step("нажать на кнопку Войти", () -> {
//            registrationPage.submitClick();
//        });
//
//        step("нажать на кнопку Видеоархив", () -> {
//            mainPage.sectionClick("Видеоархив");
//        });
//
//        step("выбрать сортировку по фото", () -> {
//            mainPage.clickSelectFoto("фото");
//        });
//
//        sleep(5000);
//    }

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
            videoArchivePage.clickButtonFilter();
        });

        step("ввести ФИО сотрудника", () -> {
            filterModalVideoArchivePage.inputName(testData.nameUser);
        });

        step("нажать на кнопку Поиск", () -> {
            filterModalVideoArchivePage.clickButtonSearch();
        });

        step("кликнуть по месту вне модального окна", ()-> {
            videoArchivePage.clickOutside();
        });

        step("проверить что отобразились записи с фио сотрудника", ()-> {
            videoArchivePage.verifyEmployeeName();
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
            videoArchivePage.clickButtonFilter();
        });

        step("ввести код сотрудника", () -> {
            filterModalVideoArchivePage.inputCodeEmployee(testData.codeUser);
        });

        step("нажать на кнопку Поиск", () -> {
            filterModalVideoArchivePage.clickButtonSearch();
        });

        step("кликнуть по месту вне модального окна", ()-> {
            videoArchivePage.clickOutside();
        });

        step("проверить что отобразились записи с выбранным кодом сотрудника", ()-> {
            videoArchivePage.verifyEmployeeName();
        });
    }


    @Test
    void checkingFilteringByDepartment() {

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
            videoArchivePage.clickButtonFilter();
        });

        step("ввести название подразделения", () -> {
            filterModalVideoArchivePage.inputDepartment(testData.departmentUser);
        });

        step("нажать на кнопку Поиск", () -> {
            filterModalVideoArchivePage.clickButtonSearch();
        });

        step("кликнуть по месту вне модального окна", ()-> {
            videoArchivePage.clickOutside();
        });

        step("проверить что отобразились записи с сотрудникми выбранного подразделения", ()-> {
            videoArchivePage.verifyEmployeeName();
        });
    }

    @Test
    void checkingFilteringByNowDate() {

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
            videoArchivePage.clickButtonFilter();
        });

       step("нажать на Дата с", () -> {
           filterModalVideoArchivePage.startDateClick();
       });



       sleep(5000);
    }
}
