package tests;

import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.ModalLogoutPage;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;


public class VerifyLogoutTest extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();
    MainPage mainPage = new MainPage();
    ModalLogoutPage modalLogoutPage = new ModalLogoutPage();

    @Test
    void verifyCancelLogout() {
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

        step("нажать на кнопку Выход", () -> {
            mainPage.sectionClick("Выход");
        });

        step("проверить, что открылось модальное окно с подтверждением действия", () -> {
            modalLogoutPage.openModalLogout();
        });

        step("нажать на кнопку Нет", () -> {
            modalLogoutPage.clickNoButtonModalLogout();
        });

        step("проверрить, что модальное окно было закрыто", () -> {
            modalLogoutPage.closedModalLogout();
        });
    }

    @Test
    void verifyConfirmLogout() {
        step("открыть страницу с формой авторизации", () -> {
            registrationPage.openPage();
        });

        step("закрыть экранную клавиатуру", () -> {
            registrationPage.closedKeybord();
        });

        step("ввести логин и пароль", () -> {
            registrationPage.login(login)
                    .password(password);
        });

        step("нажать на кнопку Войти", () -> {
            registrationPage.submitClick();
        });

        step("нажать на кнопку Выход", () -> {
            mainPage.sectionClick("Выход");
        });

        step("проверить, что открылось модальное окно с подтверждением действия", () -> {
            modalLogoutPage.openModalLogout();
        });

        step("нажать на кнопку Да", () -> {
            modalLogoutPage.clickYesButtonModalLogout();
        });

        step("проверить, что произошел выход из приложения и есть title Авторизация", () -> {
            registrationPage.authorizationTitle("Авторизация");
        });
    }
}
