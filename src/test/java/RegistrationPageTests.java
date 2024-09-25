import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static utils.RandomUtils.*;

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
        String firstName = getFirstName(),
                lastName = getLastName(),
                email = getEmail(),
                gender = getGender(),
                number = getNumber(),
                dayOfBirth = getDayOfBirthDate(),
                monthOfBirth = getMonthOfBirthDate(),
                yearOfBirth = getYearOfBirthDate(),
                subject = getSubject(),
                hobby = getHobby(),
                picture = getPicture(),
                address = getAddress(),
                state = getState(),
                city = getCity(state);

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .selectGender(gender)
                .setUserNumber(number)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubject(subject)
                .setHobby(hobby)
                .setPicture(picture)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submitForm();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", number)
                .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", picture)
                .checkResult("Address", address)
                .checkResult("State and City", state + " " + city);
    }


    @Test
    void successfulRegistrationRequiredFieldsTest() {
        String firstName = getFirstName(),
                lastName = getLastName(),
                gender = getGender(),
                number = getNumber();


        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .selectGender(gender)
                .setUserNumber(number)
                .submitForm();

        registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", number);
    }

    @Test
    void unsuccessfulRegistrationTest() {
        registrationPage.openPage()
                .submitForm();

        registrationPage.checkUnsuccessfulRegistration();
    }
}
