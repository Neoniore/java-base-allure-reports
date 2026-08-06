package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    @BeforeEach
    public void setup() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
}
