package tests;

import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.RegistrationPage;
import pages.UserPage;
import utils.TestData;

import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;


public class UserTabTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    MainPage mainPage = new MainPage();
    UserPage userPage = new UserPage();
    TestData testData = new TestData();


    @Test
    void successfulSearch() {

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

        step("нажать на кнопку Пользователи", () -> {
            mainPage.sectionClick("Пользователи");
        });

        step("ввести имя пользователя", () -> {
            userPage.enterIntoSearch(testData.nameUser);
        });

        step("проверить правильность поиска", () -> {
            userPage.verifyUser();
        });
    }

    @Test
    void unsuccessfulSearch() {

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

        step("нажать на кнопку Пользователи", () -> {
            mainPage.sectionClick("Пользователи");
        });

        step("ввести имя пользователя, которого нет в списке", () -> {
            userPage.enterIntoSearch(testData.unsuccessfulUserName);
        });

        step("проверить что отобразилась заглушка", () -> {
            userPage.verifyUserTabPlaceholder();
        });
    }

    @Test
    void searchСleaningСheck() {

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

        step("нажать на кнопку Пользователи", () -> {
            mainPage.sectionClick("Пользователи");
        });

        step("ввести имя пользователя", () -> {
            userPage.enterIntoSearch(testData.nameUser);
        });

        step("проверить правильность поиска", () -> {
            userPage.verifyUser();
        });

        step("нажать на иконку крестик в поле поиска", () -> {
            userPage.clickIconClearSearch();
        });

        step("проверить что отобразились все пользователи", () -> {
            userPage.verifyUSersItems();
        });
    }
}
