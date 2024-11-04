package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class ButtonClick {

    public void buttonClick(String idButton) {
        $("#" + idButton).click();
    }
}
