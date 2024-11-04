package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadTimeout = 600000;
//        Configuration.holdBrowserOpen = true;
    }

    @Test
    void formTest() {
        open("https://demoqa.com/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        $("[id=firstName]").setValue("John");
        $("[id=lastName]").setValue("Smith");
        $("#userEmail").setValue("JSmith@gmail.ru");
        $("#gender-radio-2").parent().click();
        $("[id=userNumber]").setValue("9991112233");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").selectOptionByValue("1999");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("21.png");
//        $("uploadPicture").uploadFile(new File("src/test/resources/21.png"));
        $("#currentAddress").setValue("New York, Lenina str. 17");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();
        $("[id=submit]").click();
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("John"), text("JSmith@gmail.ru"),
                text("9991112233"));
    }
}
