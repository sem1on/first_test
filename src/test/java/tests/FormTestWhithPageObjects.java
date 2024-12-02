package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

public class FormTestWhithPageObjects extends TestBace {

    @Test
    void formTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
// Заполнение формы
        registratioinPage.openPage()
                .setFirstName("John")
                .setSecondName("Smith")
                .setEmail("JSmith@gmail.ru")
                .setPhoneNumber("9991112233")
                .setText("#currentAddress", "New York, Lenina str. 17")
                .setBirthDate("30", "October", "1999")
                .setGender()
                .setSubject("maths")
                .setHobbies("Sports")
                .loadPicture("21.png")
                .setStateCity("Haryana", "Karnal")
                .clickButton("submit");
// Проверка прохождения теста
        registratioinPage.setVerifyModal()
                .setVerifyResult("Student Name", "John Smith")
                .setVerifyResult("Student Email", "JSmith@gmail.ru")
                .setVerifyResult("Mobile", "9991112233")
                .setVerifyResult("Address", "New York, Lenina str. 17");
    }
}
