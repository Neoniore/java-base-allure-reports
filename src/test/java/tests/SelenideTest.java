package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.selector.ByText;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.element;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {
    @Test
    public void selenideTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/Neoniore?tab=repositories");

        element(ByText.linkText("java-base-jenkins-simple-tests")).click();
        element("#issues-tab").click();
        element(withText("All issues")).shouldBe(Condition.exist);
    }

}
