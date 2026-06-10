package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import io.github.cdimascio.dotenv.Dotenv;

public class TestBase {

    protected static String login;
    protected static String password;

    protected static String loginWrong;
    protected static String passwordWrong;

    @BeforeAll
    static void beforeAll() {
        Dotenv dotenv = Dotenv.load();
        login = dotenv.get("login_successfull");
        password = dotenv.get("password_successfull");

        loginWrong = dotenv.get("login_wrong");
        passwordWrong = dotenv.get("password_wrong");

        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "http://localhost:8083/";
        Configuration.pageLoadStrategy = "eager";


    }



}
