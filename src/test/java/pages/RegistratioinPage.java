package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistratioinPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationModal registrationModal = new RegistrationModal();

    private final String titleText = "Student Registration Form";
    private SelenideElement firstNameInput = $("[id=firstName]");
    private SelenideElement secondNameInput = $("[id=lastName]");

    public RegistratioinPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-from-wrapper").shouldHave(text(titleText));
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
}
