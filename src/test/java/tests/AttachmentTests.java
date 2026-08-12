package tests;


import org.junit.jupiter.api.Test;
import pages.GithubPages;


import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;

public class AttachmentTests extends TestBase {

    public static final String REPOSITORY = "java-base-jenkins-simple-tests";

    GithubPages githubPages = new GithubPages();

    @Test
    public void testLambdaAttachments() {
        step("Открываем страницу с репозиториями Neoniore", () -> {
            open("https://github.com/Neoniore?tab=repositories");
            attachment("source", webdriver().driver().source());
        });
    }

    @Test
    public void testAtAttachments() {
        githubPages
                .openPage()
                .makeScreenshot();

    }
}
