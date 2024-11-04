package tests;

import org.junit.jupiter.api.Test;

public class FormTestWhithPageObjects extends TestBace {

    @Test
    void formTest() {
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
                .setHobbies("Sport")
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
