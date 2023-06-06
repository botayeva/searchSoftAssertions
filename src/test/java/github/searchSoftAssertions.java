package github;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class searchSoftAssertions {

    @BeforeAll
    static void search() {
        pageLoadStrategy = "eager";
        baseUrl = "https://github.com";
    }

    @Test
    void successTest() {
        // Открыть страницу Selenide в Github:
        open("/selenide/selenide");
        // Перейти в раздел Wiki проекта:
        $("#wiki-tab").click();
        // Убедиться, что в списке страниц есть страница SoftAssertions:
        $("#wiki-pages-filter").setValue("SoftAssertions").pressEnter();
        $("div.wiki-rightbar a[href*='SoftAssertions']").shouldHave(text("SoftAssertions")).click();
        // Открыть страницу SoftAssertions:
        $("a[href='/selenide/selenide/wiki/SoftAssertions']").click();
        // Проверить, что внутри страницы есть пример кода для JUnit5:
        $("#user-content-3-using-junit5-extend-test-class").parent().sibling(0).shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" + "class Tests {\n" + "  @Test\n" + "  void test() {\n" + "    " + "Configuration.assertionMode = SOFT;\n" + "    open(\"page.html\");\n" + "\n" + "    " + "$(\"#first\").should(visible).click();\n" + "    " + "$(\"#second\").should(visible).click();\n" + "  }\n" + "}"));
    }

}
