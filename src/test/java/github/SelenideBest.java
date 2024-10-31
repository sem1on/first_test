package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SelenideBest {

    @Test
    void selenideBest() {

        open("https://github.com/selenide/selenide");
        $("div.Layout-sidebar").shouldHave(text("Contributors"))
//                .closest(".BorderGrid-cell").$$("ul li").first().hover(); closeset() - Поиск блоком выше (поднятие), sibling() - поиск ниже на одном уровне( 0 - первый)
                .closest("h2").sibling(0).$$("li").first().hover();

        // Из нескольких элеменитов классв Popover находим первый видимый
//        $$(".Popover").findBy(visible).shouldHave(text("Andrei"));

        $(".Popover-message").shouldHave(text("Andrei"));
    }
}
