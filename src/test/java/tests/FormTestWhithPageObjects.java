package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormTestWhithPageObjects extends TestBace {

    @Test
    void formTest() {

        registratioinPage.openPage()
                .setFirstName("John")
                .setSecondName("Smith")
                .setEmail("JSmith@gmail.ru")
                .setPhoneNumber("9991112233")
                .setText("#currentAddress", "New York, Lenina str. 17");

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
