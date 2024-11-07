package tests;

import org.junit.jupiter.api.Test;

import static utils.RandomUtils.getRandomString;

public class FormTestWhithRandonUtils extends TestBace {

    @Test
    void formTest() {

        String userName = getRandomString(10),
                lastName = getRandomString(10),
                userEmail = "JSmith@gmail.ru";
// Заполнение формы
        registratioinPage.openPage()
                .setFirstName(userName)
                .setSecondName(lastName)
                .setEmail(userEmail)
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
                .setVerifyResult("Student Name", userName + " " + lastName)
                .setVerifyResult("Student Email", userEmail)
                .setVerifyResult("Mobile", "9991112233")
                .setVerifyResult("Address", "New York, Lenina str. 17");
    }
}
