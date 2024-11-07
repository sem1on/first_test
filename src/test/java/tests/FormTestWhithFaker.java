package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import static utils.RandomUtils.*;

public class FormTestWhithFaker extends TestBace {

    @Test
    void formTest() {

        Faker faker = new Faker();

        String[] months = {"May", "October", "September", "August", "July"};
        String userName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                userEmail = faker.internet().emailAddress(),
                currentAddress = faker.address().fullAddress(),
                monthBirth = getRandomItemFromArray(months),
                phoneNumber = faker.number().digits(10);

// Заполнение формы
        registratioinPage.openPage()
                .setFirstName(userName)
                .setSecondName(lastName)
                .setEmail(userEmail)
                .setPhoneNumber(phoneNumber)
                .setText("#currentAddress", currentAddress)
                .setBirthDate("30", monthBirth, "1999")
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
                .setVerifyResult("Mobile", phoneNumber)
                .setVerifyResult("Address", currentAddress);
    }
}
