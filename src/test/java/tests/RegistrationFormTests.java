package tests;

import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.RegistrationPage;
import static io.qameta.allure.Allure.step;

public class RegistrationFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    MainPage mainPage = new MainPage();


    @Test
    void successfullRegistrationTest() {

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

        step("проверить что прошла авторизация и отобразились разделы приложения", () -> {
            mainPage.checkSectionsPresence("Камера")
                    .checkSectionsPresence("Видеоархив")
                    .checkSectionsPresence("События")
                    .checkSectionsPresence("Пользователи")
                    .checkSectionsPresence("Настройки")
                    .checkSectionsPresence("Администрирование")
                    .checkSectionsPresence("Отчеты")
                    .checkSectionsPresence("Выход");
        });
    }

    @Test
    void testLoginWithWrongPassword() {

        step("открыть страницу с формой авторизации", () -> {
            registrationPage.openPage();
        });

        step("ввести верный логин и неверый пароль", () -> {
            registrationPage.login(login)
                            .password(passwordWrong);
        });

        step("нажать на кнопку Войти", () -> {
            registrationPage.submitClick();
        });

        step("проверить, что открылось модальное окно с сообщением об ошибке", () -> {
            registrationPage.openModalWrong()
                            .titleWrongModal("Ошибка!")
                            .descWrongModal("Неверный логин или пароль!");
        });

        step("нажать на кнопку Ок", () -> {
            registrationPage.clickButtonWrongModal();
        });

        step("проверить, что модальное окно закрылось", () -> {
            registrationPage.closeWrongModal();
        });
    }

    @Test
    void testLoginWithWrongLogin() {

        step("открыть страницу с формой авторизации", () -> {
            registrationPage.openPage();
        });

        step("ввести неверный логин и верый пароль", () -> {
            registrationPage.login(loginWrong)
                            .password(password);
        });

        step("нажать на кнопку Войти", () -> {
            registrationPage.submitClick();
        });

        step("проверить, что открылось модальное окно с сообщением об ошибке", () -> {
            registrationPage.openModalWrong()
                    .titleWrongModal("Ошибка!")
                    .descWrongModal("Неверный логин или пароль!");
        });

        step("нажать на кнопку Ок", () -> {
            registrationPage.clickButtonWrongModal();
        });

        step("проверить, что модальное окно закрылось", () -> {
            registrationPage.closeWrongModal();
        });
    }
}
