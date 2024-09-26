import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;

public class RegistrationPageTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    RandomUtils randomUtils = new RandomUtils();

    @Test
    void successfulRegistrationTest() {
        String firstName = randomUtils.getFirstName(),
                lastName = randomUtils.getLastName(),
                email = randomUtils.getEmail(),
                gender = randomUtils.getGender(),
                number = randomUtils.getNumber(),
                dayOfBirth = randomUtils.getDayOfBirthDate(),
                monthOfBirth = randomUtils.getMonthOfBirthDate(),
                yearOfBirth = randomUtils.getYearOfBirthDate(),
                subject = randomUtils.getSubject(),
                hobby = randomUtils.getHobby(),
                picture = randomUtils.getPicture(),
                address = randomUtils.getAddress(),
                state = randomUtils.getState(),
                city = randomUtils.getCity(state);

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
        String firstName = randomUtils.getFirstName(),
                lastName = randomUtils.getLastName(),
                gender = randomUtils.getGender(),
                number = randomUtils.getNumber();


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
