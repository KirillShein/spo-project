package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    public static final Faker faker = new Faker(new Locale("ru"));

    public String nameUser = "Бирюков Андрей Сергеевич",
                  codeUser = "1405",
                  departmentUser = "Новские",
                  numberCamera = "1",
                  videoArchivePlaceholderText = "Нет файлов, удовлетворяющих критериям поиска",
                  eventsPlaceholderText = "Нет событий за выбранную дату",
                  userTabPlaceholderText = "Нет пользователей",
                  unsuccessfulUserName = "Иванов Антон Павлович",
                  lastNameUser = getRandomLastNameUser(),
                  firstNameUser = getRandomFirstNameUser(),
                  patronymicUser = getRandomPatronymic(),
                  roleUser = getRandomRoleUser(),
                  loginUser = getRandomLoginUser(),
                  passwordUser = getRandomPassword(),
                  codeRandomUser = getRandomCodeUser();


    public static String getRandomLastNameUser() {
        return faker.name().lastName();
    }

    public static String getRandomFirstNameUser() {
        return faker.name().firstName();
    }

    public static String getRandomPatronymic() {
        return faker.name().nameWithMiddle();
    }

    public static String getRandomRoleUser() {
        String[] role = {"Аналитик", "Старший аналитик", "Оператор"};

        return faker.options().option(role);
    }

    public static String getRandomLoginUser() {
        return faker.internet().emailAddress();
    }

    public static String getRandomPassword() {
        return faker.internet().password();
    }

    public static String getRandomCodeUser() {
        return faker.number().toString();
    }

}
