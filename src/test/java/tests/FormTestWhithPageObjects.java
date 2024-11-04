package tests;

import org.junit.jupiter.api.Test;

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
                .setText("#currentAddress", "New York, Lenina str. 17")
                .setBirthDate("30", "October", "1999");

        $("#gender-radio-2").parent().click();
        $("#subjectsInput").setValue("maths").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("21.png");
//        $("uploadPicture").uploadFile(new File("src/test/resources/21.png"));
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();
        $("[id=submit]").click();

        registratioinPage.setVerifyModal()
                .setVerifyResult("Student Name", "John Smith")
                .setVerifyResult("Student Email", "JSmith@gmail.ru")
                .setVerifyResult("Mobile", "9991112233")
                .setVerifyResult("Address", "New York, Lenina str. 17");
    }
}
