package utils;

import com.github.javafaker.Faker;
import java.util.Random;

public class RandomUtils {

    private Faker faker = new Faker();

    public String getFirstName() {
        return faker.name().firstName();
    }

    public String getLastName() {
        return faker.name().lastName();
    }

    public String getEmail() {
        return faker.internet().emailAddress();
    }

    public String getGender() {
        return faker.options().option ("Male", "Female", "Other");
    }

    public String getNumber() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public String getDayOfBirthDate() {
        return Integer.toString(getRandomInt(1, 28));
    }

    public String getMonthOfBirthDate() {
        String[] months = {"January", "February", "March", "April", "June", "July", "August", "September", "October", "November", "December"};

        return faker.options().option(months);
    }

    public String getYearOfBirthDate() {
        return Integer.toString(getRandomInt(1900, 2010));
    }

    public String getSubject() {
        String[] subjects = {"Maths", "Chemistry", "Commerce", "Economics", "English"};

        return faker.options().option(subjects);
    }

    public String getHobby() {
        String[] hobbies = {"Sports", "Reading", "Music"};

        return faker.options().option(hobbies);
    }

    public String getPicture() {
        return "smile.png";
    }

    public String getAddress() {
        return faker.address().fullAddress();
    }

    public String getState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};

        return faker.options().option(states);
    }

    public String getCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Lucknow", "Agra", "Merrut");
            case "Haryana" -> faker.options().option("Panipat", "Karnal");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> throw new IllegalArgumentException("Invalid state");
        };
    }

    public int getRandomInt(int min, int max) {
        return new Random().nextInt(min, max);
    }
}
