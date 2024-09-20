import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPageTests {

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920*1080";
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;
    }

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Denis")
                .setLastName("Gubert")
                .setUserEmail("denis@gubert.com")
                .selectGender("Male")
                .setUserNumber("9991001010")
                .setDateOfBirth("10", "April", "1986")
                .setSubject("Maths")
                .setHobby("Reading")
                .setPicture("smile.png")
                .setAddress("Saint-Petersburg, Lipovaya Avenue 9")
                .setState("NCR")
                .setCity("Noida")
                .submitForm();

        registrationPage.checkResult("Student Name", "Denis Gubert")
                .checkResult("Student Email", "denis@gubert.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9991001010")
                .checkResult("Date of Birth", "10 April,1986")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Reading")
                .checkResult("Picture", "smile.png")
                .checkResult("Address", "Saint-Petersburg, Lipovaya Avenue 9")
                .checkResult("State and City", "NCR Noida");
    }

    @Test
    void successfulRegistrationRequiredFieldsTest() {
        registrationPage.openPage()
                .setFirstName("Denis")
                .setLastName("Gubert")
                .selectGender("Male")
                .setUserNumber("9991001010")
                .submitForm();

        registrationPage.checkResult("Student Name", "Denis Gubert")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9991001010");
    }

    @Test
    void unsuccessfulRegistrationTest() {
        registrationPage.openPage()
                .submitForm();

        registrationPage.checkUnsuccessfulRegistration();
    }
}
