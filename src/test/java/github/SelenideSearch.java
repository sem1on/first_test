package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideSearch {

    @Test
    void searchSelenide() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadTimeout = 600000;
        Configuration.holdBrowserOpen = true;
        open("https://github.com/");
        $(".header-search-button").click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        $$("data-testid=results-list").first().$("a").click();
        $("#repository-container-header").shouldHave(text("selenide"));

    }

}
