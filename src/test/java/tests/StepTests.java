package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.selector.ByText;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.element;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class StepTests {

    public static final String REPOSITORY = "java-base-jenkins-simple-tests";

    @Test
    public void testLambdaStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем страницу с репозиториями Neoniore", () -> {
            open("https://github.com/Neoniore?tab=repositories");
        });
        step("Ищем репозиторий " + REPOSITORY + " и выбираем его", () -> {
            element(ByText.linkText(REPOSITORY)).click();
        });
        step("Открываем таб с issues", () -> {
            element("#issues-tab").click();
        });
        step("Проверяем, что открыта вкладка Issues", () -> {
            element(withText("All issues")).shouldBe(Condition.exist);
        });
    }

}
