import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideSoftAssertionsTests {
    @Test
    void junit5ShouldBeOnSoftAssertionsPage() {
        open("https://github.com/selenide/selenide");
        $("[data-content='Wiki']").click();
        $("#wiki-body").$("[href*='SoftAssertions'").click();
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class"));
    }
}
