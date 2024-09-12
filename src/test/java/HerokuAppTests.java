import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class HerokuAppTests {

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920*1080";
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void dragAndDropByActionsTest() {
        open("/drag_and_drop");
        $(".column header").shouldHave(text("A"));
        actions().dragAndDrop($("#column-a"), $("#column-b")).release().perform();
        $(".column header").shouldHave(text("B"));
    }

    @Test
    void dragAndDropNotByActionsTest() {
        open("/drag_and_drop");
        $(".column header").shouldHave(text("A"));
        $("#column-a").dragAndDrop(to($("#column-b")));
        $(".column header").shouldHave(text("B"));
    }
}
