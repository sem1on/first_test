package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class DrugAndDrop {

    @Test
    void drugAndDrop() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadTimeout = 600000;
        Configuration.holdBrowserOpen = true;
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDrop(DragAndDropOptions.to("#column-b"));
    }
}
