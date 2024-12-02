package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import pages.components.ButtonClick;
import pages.components.CalendarComponent;
import pages.components.RegistrationModal;
import pages.components.SelectStateAndCity;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistratioinPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationModal registrationModal = new RegistrationModal();
    SelectStateAndCity selectStateAndCity = new SelectStateAndCity();
    ButtonClick buttonClick = new ButtonClick();

    private final String titleText = "Student Registration Form";
    private SelenideElement firstNameInput = $("[id=firstName]");
    private SelenideElement secondNameInput = $("[id=lastName]");

    public RegistratioinPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(titleText));
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistratioinPage setText(String nameClass, String value) {
        $(nameClass).setValue(value);
        return this;
    }
    public RegistratioinPage setFirstName( String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistratioinPage setSecondName( String value) {
        secondNameInput.setValue(value);
        return this;
    }

    public RegistratioinPage setEmail( String value) {
        $("#userEmail").setValue(value);
        return this;
    }

    public RegistratioinPage setPhoneNumber( String value) {
        $("[id=userNumber]").setValue(value);
        return this;
    }

    public RegistratioinPage setBirthDate (String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistratioinPage setVerifyModal () {
        registrationModal.verifyModalAppers();
        return this;
    }

    public RegistratioinPage setVerifyResult (String key, String value) {
        registrationModal.verifyResult(key, value);
        return this;
    }

    public RegistratioinPage setGender() {
        $("#gender-radio-2").parent().click();
        return this;
    }

    public RegistratioinPage setSubject(String value) {
        $("#subjectsInput").setValue(value).pressEnter();
        return this;
    }

    public RegistratioinPage setHobbies(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();
        return this;
    }

    public RegistratioinPage loadPicture(String pictureName) {
        $("#uploadPicture").uploadFromClasspath(pictureName);
//        $("uploadPicture").uploadFile(new File("src/test/resources/21.png"));
        return this;
    }

    public RegistratioinPage setStateCity(String state, String city) {
        selectStateAndCity.setStateCity(state, city);
        return this;
    }

    public RegistratioinPage clickButton(String idButton){
        buttonClick.buttonClick(idButton);
        return this;
    }
}
