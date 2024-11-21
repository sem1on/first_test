package allure;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final int NUMBER = 95;

    @Test
    public void testLambdaSteps() {
//        Configuration.pageLoadTimeout = 600000;
        Configuration.holdBrowserOpen = true;
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Open Start page", () -> {
            open("https://github.com");
        });
        step("Search repository" + REPOSITORY, () -> {
            $(".header-search-button").click();
            $("#query-builder-test").sendKeys(REPOSITORY);
            $("#query-builder-test").submit();
        });
        step("Click to repository", () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Open Issue", () -> {
            $("#issues-tab").click();
        });
        step("Check number" + NUMBER, () -> {
            $(withText("#" + NUMBER)).should(Condition.exist);
        });
    }

    @Test
    public void testAnnotation() {
        WebSteps steps = new WebSteps();
        SelenideLogger.addListener("allure", new AllureSelenide());

        steps.openMainPage();
        steps.searchReposetory(REPOSITORY);
        steps.clickReposetory(REPOSITORY);
        steps.openIssue();
        steps.checkNumber(NUMBER);
    }
}
