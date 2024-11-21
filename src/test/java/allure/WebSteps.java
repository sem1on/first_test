package allure;


import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("Open Start page")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Search repository")
    public void searchReposetory(String repo) {
        $(".header-search-button").click();
        $("#query-builder-test").sendKeys(repo);
        $("#query-builder-test").submit();
    }

    @Step("Click to repository")
    public void clickReposetory(String repo) {
        $(linkText(repo)).click();
    }

    @Step("Open Issue")
    public void openIssue() {
        $("#issues-tab").click();
    }

    @Step("Check number")
    public void checkNumber(int number) {
        $(withText("#" + number)).should(Condition.exist);
    }
}
