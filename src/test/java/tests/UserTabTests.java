package tests;

import org.junit.jupiter.api.Test;
import pages.CardUserPage;
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
    CardUserPage cardUserPage = new CardUserPage();
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

    @Test
    void checkingTheAdministratorCard() {

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

        step("нажать на пользователя с ролью Администратор", () -> {
            userPage.clickAdministratorItem();
        });

        step("проверить, что отсутствует раздел Роль", () -> {
            cardUserPage.checkingForMissingPartition("Роль");
        });

        step("проверить, что отсутствует раздел Параметры использования камеры", () -> {
            cardUserPage.checkingForMissingPartition("Параметры использования камеры");
        });

        step("проверить, что нельзя отключить учетную запись пользователя", () -> {
            cardUserPage.checkingForMissingPartition("Учетная запись включена");
        });

        step("проверить, что нельзя удалить пользователя", () -> {
            cardUserPage.checkingForMissingButtonDeleteUser();
        });
    }

    @Test
    void successfulUserCreation() {

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

        step("нажать на раздел Пользователи", () -> {
            mainPage.sectionClick("Пользователи");
        });

        step("нажать на кнопку Добавить", () -> {
            userPage.clickButtonCreateUser();
        });

        step("ввести фамилию пользователя", () -> {
            cardUserPage.setLastName(testData.lastNameUser);
        });

        step("ввести имя пользователя", () -> {
            cardUserPage.setFirstName(testData.firstNameUser);
        });

        step("ввести отчество пользователя", () -> {
            cardUserPage.setPatronymic(testData.patronymicUser);
        });

        step("ввести название подразделения", () -> {
            cardUserPage.setDepartment("Выборгское");
        });

        step("Нажать на кнопку Укажите роль пользователя", () -> {
            cardUserPage.clickChapterRole();
        });

        step("выбрать роль пользователя", () -> {
            cardUserPage.clickButtonRole();
        });

        step("ввести логин пользователя", () -> {
            cardUserPage.setLogin(testData.loginUser);
        });

        step("ввести пароль пользователя", () -> {
            cardUserPage.setPassword(testData.passwordUser);
        });

        step("ввести подтверждение пароля пользователя", () -> {
            cardUserPage.setPasswordConfirme(testData.passwordUser);
        });

        step("нажать на кнопку Сохранить", () -> {
            cardUserPage.clickButtonSave();
        });

        step("проверить, что созданный пользователь есть в списке пользователей", () -> {
            userPage.verifyCreatedUser(testData.firstNameUser);
        });
    }
}
