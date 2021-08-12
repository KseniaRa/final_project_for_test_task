package tests;

import helpers.DriverUtils;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.title;
import static io.qameta.allure.Allure.step;

public class MainPageTests extends TestBase{

    @Test
    void titleTest() {
        step("Open url 'https://www.vprok.ru/'", () ->
                open("https://www.vprok.ru/"));

        step("Page title should have text 'Vprok.ru Перекрёсток – доставка продуктов на дом и на дачу Впрок'", () -> {
            String expectedTitle = "Vprok.ru Перекрёсток – доставка продуктов на дом и на дачу Впрок";
            String actualTitle = title();

            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }



    @Test
    void searchLineTest() {
        step("открыть \"https://www.vprok.ru/\"", () -> {
            step("// todo: just add selenium action");
        });

        step("ввести поисковую строку \"Петрушка\"", () -> {
            step("// todo: just add selenium action");
        });

        step("нажать на поиск", () -> {
            step("// todo: just add selenium action");
        });

        step("убедиться что на странице есть слова \"результаты поиска\"", () -> {
            step("// todo: just add selenium action");
        });
    }







    @Test
    void consoleShouldNotHaveErrorsTest() {
        step("Open url 'https://www.vprok.ru/'", () ->
                open("https://www.vprok.ru/"));

        step("Console logs should not contain text 'SEVERE'", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}
