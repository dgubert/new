import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

public class Tests {

    @BeforeAll
    static void setUp() {
        //Configuration.browserSize = "1920*1080";
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
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
        $("#uploadPicture").uploadFromClasspath("smile.png");
        $("#currentAddress").setValue("Saint-Petersburg, Lipovaya Avenue 9");
        $("#state input").sendKeys("NCR");
        $("#state input").pressEnter();
        $("#city input").sendKeys("Noida");
        $("#city input").pressEnter();
        $("#submit").click();

        $(".modal-title").shouldHave (text("Thanks for submitting the form"));
        $(".modal-body").shouldHave (text("Denis Gubert"));
        $(".modal-body").shouldHave (text("denis@gubert.com"));
        $(".modal-body").shouldHave (text("Male"));
        $(".modal-body").shouldHave (text("8999100101"));
        $(".modal-body").shouldHave (text("10 April,1986"));
        $(".modal-body").shouldHave (text("Maths"));
        $(".modal-body").shouldHave (text("Reading"));
        $(".modal-body").shouldHave (text("smile.png"));
        $(".modal-body").shouldHave (text("Saint-Petersburg, Lipovaya Avenue 9"));
        $(".modal-body").shouldHave (text("NCR Noida"));
    }
}
