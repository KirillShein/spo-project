package tests;

import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.RegistrationPage;

public class VerifyLogoutTest extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();
    MainPage mainPage = new MainPage();

    @Test
    void verifyUserIsLoggedOut() throws InterruptedException {
        registrationPage.openPage()
                .login(login)
                .password(password)
                .submitClick();

        Thread.sleep(3000);

        mainPage.logoutSectionClick("Выход")
                .openModalLogout();


        registrationPage.checkAuthozationModal();
    }
}
