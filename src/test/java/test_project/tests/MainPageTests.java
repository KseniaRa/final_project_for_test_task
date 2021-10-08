package test_project.tests;


import org.openqa.selenium.By;
import test_project.helpers.DriverUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class MainPageTests extends TestBase {

    @Test
    @DisplayName("Page title should have header text")
    void titleTest() {
        step("Open url 'https://www.vprok.ru/'", () ->
                open("https://www.vprok.ru/"));

        step("Проверяем название", () -> {
            String expectedTitle = "Vprok.ru Перекрёсток – доставка продуктов на дом и на дачу Впрок";
            String actualTitle = title();
            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }

    @Test
    @DisplayName("Вход/Регистрация")
    void loginTest() {
        step("Open url 'https://www.vprok.ru/'", () ->
             open("https://www.vprok.ru/"));
             $(".xfnew-header__user-nav:nth-child(5)").click();

        step("Проверяем, что открылся попап авторизации", () -> {
             $(".xf-auth-title__text")
                        .shouldHave(text("Вход или регистрация"));
        });
    }

    @Test
    @DisplayName("Попап регионов")
    void regionTest() {
        step("Open url 'https://www.vprok.ru/'", () ->
            open("https://www.vprok.ru/"));
            $(".xfnew-header__change-region").click();

        step("Проверяем, что открылся попап с регионами", () -> {
            $(".xf-popup-polygons__block-check-region")
                    .shouldHave(text("Выберите ваш регион"));
        });
    }

    @Test
    @DisplayName("Открыть страницу с акциями")
    void promoTest() {
        step("Кликнуть на блок акции в шапке", () ->
                open("https://www.vprok.ru/"));
                $(byText("Акции")).click();;

        step("Проверяем, что открылась страница с акциями", () -> {
                $(".xf-caption__title")
                        .shouldHave(text("Акции"));
        });
    }


    @Test
    @DisplayName("Открыть раздел Каталога")
    void testCatalog(){
        step("Open url 'https://www.vprok.ru/'", () ->
                open("https://www.vprok.ru/"));
                $(".xfnew-header__catalog-button").click();
                $$(".fo-catalog-menu__nav a").
                        findBy(text("Молоко, сыр, яйца")).click();

        step("Проверяем, что открылась страница каталога", () -> {
                $(".fo-breadcrumbs__current").
                        shouldHave(text("Молоко, сыр, яйца"));;
        });
    }


    @Test
    @DisplayName("Открыть новость")
    void newsTest() {
        step("Кликнуть на блок акции в шапке", () ->
                open("https://www.vprok.ru/"));
                $(".xf-mp-recipe-news__list").scrollIntoView(true).click();
                $(".xf-mp-recipe-news__img-block").click();

        step("Проверяем, что открылась страница с новостью", () -> {
                $(".xf-caption__title").shouldBe(visible);
        });
    }


    @Test
    @DisplayName("Page console log should not have errors")
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