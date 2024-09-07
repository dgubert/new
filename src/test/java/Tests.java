import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebElementCondition;
import org.junit.jupiter.api.*;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Tests {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920*1080";
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Denis");
        $("#lastName").setValue("Gubert");
        $("#userEmail").setValue("denis@gubert.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("89991001010");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").sendKeys("1986");
        $(".react-datepicker__month-select").sendKeys("April");
        $(".react-datepicker__day--010").click();
        $("#subjectsContainer input").click();
        $("#subjectsContainer input").sendKeys("Maths");
        $("#subjectsContainer input").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/smile.png"));
        $("#currentAddress").setValue("Saint-Petersburg, Lipovaya Avenue 9");
        $("#state input").sendKeys("NCR");
        $("#state input").pressEnter();
        $("#city input").sendKeys("Noida");
        $("#city input").pressEnter();
        $("#submit").click();

        Assertions.assertTrue($(".modal-title").text().contains("Thanks for submitting the form"));
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
}
