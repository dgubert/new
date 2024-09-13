import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class SolutionsEnterpriseTests {

    @Test
    void openSolutionsEnterprisePageTest() {
        open("https://github.com");
        $(byTagAndText("button", "Solutions")).hover();
        $(byTagAndText("a","Enterprise")).click();
        $("h1#hero-section-brand-heading").shouldHave(text("The AI-powered\ndeveloper platform."));
    }
}
