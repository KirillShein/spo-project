package tests;

import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.RegistrationPage;

public class RegistrationFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    MainPage mainPage = new MainPage();

    @Test
    void successfullRegistrationTest() {
        registrationPage.openPage()
                .login(login)
                .password(password)
                .submitClick();

        mainPage.checkSectionsPresence("Камера")
                .checkSectionsPresence("События")
                .checkSectionsPresence("Пользователи")
                .checkSectionsPresence("Настройки")
                .checkSectionsPresence("Администрирование")
                .checkSectionsPresence("Отчеты")
                .checkSectionsPresence("Выход");


    }

    @Test
    void testLoginWithWrongPassword() {
        registrationPage.openPage()
                .login(login)
                .password(passwordWrong)
                .submitClick()
                .openModalWrong()
                .titleWrongModal("Ошибка!")
                .descWrongModal("Неверный логин или пароль!")
                .clickButtonWrongModal()
                .closeWrongModal();
    }

    @Test
    void testLoginWithWrongLogin() {
        registrationPage.openPage()
                .login(loginWrong)
                .password(password)
                .submitClick()
                .openModalWrong()
                .titleWrongModal("Ошибка!")
                .descWrongModal("Неверный логин или пароль!")
                .clickButtonWrongModal()
                .closeWrongModal();
    }
}
