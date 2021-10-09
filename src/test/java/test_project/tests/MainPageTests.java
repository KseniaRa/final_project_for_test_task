package test_project.tests;



import test_project.helpers.DriverUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class MainPageTests extends TestBase {

    @Test
    @DisplayName("Page title should have header text")
    void titleTest() {
            open("https://www.vprok.ru/");
            String expectedTitle = "Vprok.ru Перекрёсток – доставка продуктов на дом и на дачу Впрок";
            String actualTitle = title();
            assertThat(actualTitle).isEqualTo(expectedTitle);

    }

    @Test
    @DisplayName("Вход/Регистрация")
    void loginTest() {

             open("https://www.vprok.ru/");
             $(".xfnew-header__user-nav:nth-child(5)").click();
             $(".xf-auth-title__text")
                        .shouldHave(text("Вход или регистрация"));

    }

    @Test
    @DisplayName("Попап регионов")
    void regionTest() {
            open("https://www.vprok.ru/");
            $(".xfnew-header__change-region").click();
            $(".xf-popup-polygons__block-check-region")
                    .shouldHave(text("Выберите ваш регион"));

    }

    @Test
    @DisplayName("Открыть страницу с акциями")
    void promoTest() {
                open("https://www.vprok.ru/");
                $(byText("Акции")).click();
                $(".xf-caption__title")
                        .shouldHave(text("Акции"));
    }


    @Test
    @DisplayName("Открыть раздел Каталога")
    void testCatalog(){
                open("https://www.vprok.ru/");
                $(".xfnew-header__catalog-button").click();
                $$(".fo-catalog-menu__nav a").
                        findBy(text("Молоко, сыр, яйца")).click();

                $(".fo-breadcrumbs__current").
                        shouldHave(text("Молоко, сыр, яйца"));

    }


    @Test
    @DisplayName("Открыть новость")
    void newsTest() {
                open("https://www.vprok.ru/");
                $(".xf-mp-recipe-news__list").scrollIntoView(true).click();
                $(".xf-mp-recipe-news__img-block").click();

                $(".xf-caption__title").shouldBe(visible);

    }


    @Test
    @DisplayName("Page console log should not have errors")
    void consoleShouldNotHaveErrorsTest() {
                open("https://www.vprok.ru/");
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";

            assertThat(consoleLogs).doesNotContain(errorText);


    }

}