package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadTimeout = 600000;
    }

    @Test
    void fillForText() {
        open("https://demoqa.com/text-box");
        $("[id=userName]").setValue("Jon Smith");
        $("#userEmail").setValue("JSmith@gmail.ru");
        $("#currentAddress").setValue("New York, Lenina str. 17");
        $("[id=permanentAddress]").setValue("Chicago, Mira str. 23");
        $("[id=submit]").click();
        $("#output").shouldHave(text("Jon Smith"), text("JSmith@gmail.ru"),
                text("New York, Lenina str. 17"), text("Chicago, Mira str. 23"));
    }

}
