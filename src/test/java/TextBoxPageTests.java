import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static com.codeborne.selenide.Selenide.$;

public class TextBoxPageTests {

    TextBoxPage textBoxPage = new TextBoxPage();

    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920*1080";
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void successfullTextBoxTest() {
        String fullName = "John Doe";
        String email = "john.doe@example.com";
        String currentAddress = "123 Main St";
        String permanentAddress = "456 Elm St";

        textBoxPage.openPage()
               .setFullName(fullName)
               .setEmail(email)
               .setCurrentAddress(currentAddress)
               .setPermanentAddress(permanentAddress)
               .submitForm();

        textBoxPage.checkResult("Name:", fullName)
               .checkResult("Email:", email)
               .checkResult("Current Address :", currentAddress)
               .checkResult("Permananet Address :", permanentAddress);
    }
}
