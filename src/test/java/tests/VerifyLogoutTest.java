package tests;

import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;


public class VerifyLogoutTest extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();
    MainPage mainPage = new MainPage();

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
            mainPage.logoutSectionClick("Выход");
        });

        step("проверить, что открылось модальное окно с подтверждением действия", () -> {
            mainPage.openModalLogout();
        });

        step("нажать на кнопку Нет", () -> {
            mainPage.clickNoButtonModalLogout();
        });

        step("проверрить, что модальное окно было закрыто", () -> {
            mainPage.closedModalLogout();
        });
    }

    @Test
    void verifyConfirmLogout() {
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

        step("проверить, что открылось модальное окно с подтверждением действия", () -> {
            mainPage.openModalLogout();
        });

        step("нажать на кнопку Да", () -> {
            mainPage.clickYesButtonModalLogout();
        });
    }
}
