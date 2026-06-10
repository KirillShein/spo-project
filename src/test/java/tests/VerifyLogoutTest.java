package tests;

import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.sleep;


public class VerifyLogoutTest extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();
    MainPage mainPage = new MainPage();

    @Test
    void verifyCancelLogout() {
        registrationPage.openPage()
                .login(login)
                .password(password)
                .submitClick();

        mainPage.logoutSectionClick("Выход")
                .openModalLogout()
                .clickNoButtonModalLogout()
                .closedModalLogout();

    }

    @Test
    void verifyConfirmLogout() {
        registrationPage.openPage()
                .login(login)
                .password(password)
                .submitClick();

        mainPage.logoutSectionClick("Выход")
                .openModalLogout()
                .clickYesButtonModalLogout();
        sleep(2000);
    }
}
