package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfullRegistrationTest() {
        registrationPage.openPage()
                .login(login)
                .password(password)
                .submitClick()
                .checkSectionsPresence("Камера")
                .checkSectionsPresence("Видеоархив")
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
