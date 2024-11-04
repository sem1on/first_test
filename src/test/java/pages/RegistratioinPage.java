package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RegistratioinPage {

    private final String titleText = "Student Registration Form";
    private SelenideElement firstNameInput = $("[id=firstName]");
    private SelenideElement secondNameInput = $("[id=lastName]");

    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-from-wrapper").shouldHave(text(titleText));
        executeJavaScript("$('footer').remove()");
    }

    public void setText(String nameClass, String value) {
        $(nameClass).setValue(value);
    }
    public void setFirstName( String value) {
        firstNameInput.setValue(value);
    }

    public void setSecondName( String value) {
        secondNameInput.setValue(value);
    }

    public void setEmail( String value) {
        $("#userEmail").setValue(value);
    }

    public void setPhoneNumber( String value) {
        $("[id=userNumber]").setValue(value);
    }
}
