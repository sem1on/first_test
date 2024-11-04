package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistratioinPage;

public class TestBace {
    RegistratioinPage registratioinPage = new RegistratioinPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadTimeout = 600000;
        Configuration.holdBrowserOpen = true;
    }
}
