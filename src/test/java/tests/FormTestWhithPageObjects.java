package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistratioinPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormTestWhithPageObjects {

    RegistratioinPage registratioinPage = new RegistratioinPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadTimeout = 600000;
//        Configuration.holdBrowserOpen = true;
    }

    @Test
    void formTest() {

        registratioinPage.openPage();
        registratioinPage.setFirstName("John");
        registratioinPage.setSecondName("Smith");
        registratioinPage.setEmail("JSmith@gmail.ru");
        registratioinPage.setPhoneNumber("9991112233");
        registratioinPage.setText("#currentAddress", "New York, Lenina str. 17");

        $("#gender-radio-2").parent().click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").selectOptionByValue("1999");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("21.png");
//        $("uploadPicture").uploadFile(new File("src/test/resources/21.png"));
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
