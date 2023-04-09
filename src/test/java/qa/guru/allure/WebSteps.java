package qa.guru.allure;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("��������� ������� ��������")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("���� ����������� {repo}")
    public void searchForRepository(String repo) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();
    }

    @Step("������� �� ������ ����������� {repo}")
    public void clickOnRepositoryLink(String repo) {
        $(linkText(repo)).click();
    }

    @Step("��������� ��� Issues")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("��������� ������� Issue � ������� {issue}")
    public void shouldSeeIssueWithName(int issue) {
        $(withText("#" + issue)).should(Condition.exist);
    }
}