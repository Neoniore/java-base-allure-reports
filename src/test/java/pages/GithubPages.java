package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.commands.TakeScreenshot;
import com.codeborne.selenide.selector.ByText;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class GithubPages {

    @Step("Открываем страницу с репозиториями Neoniore")
    public GithubPages openPage() {
        open("https://github.com/Neoniore?tab=repositories");
        return this;
    }

    @Attachment(value = "Скриншот страницы", type = "image/png")
    public byte[] makeScreenshot() {
        return screenshot(OutputType.BYTES);
    }

    @Step("Ищем репозиторий {repo} и выбираем его")
    public GithubPages findRepo(String repo) {
        element(ByText.linkText(repo)).click();
        return this;
    }

    @Step("Открываем таб с issues")
    public GithubPages openIssueTab() {
        element("#issues-tab").click();
        return this;
    }

    @Step("Проверяем, что открыта вкладка Issues")
    public void checkOnIssueTab() {
        element(withText("All issues")).shouldBe(Condition.exist);
    }
}
