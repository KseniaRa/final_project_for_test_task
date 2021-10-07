package test_project.tests;


import test_project.helpers.DriverUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
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

        step("Page title should have text 'Vprok.ru Перекрёсток – доставка продуктов на дом и на дачу Впрок'", () -> {
            String expectedTitle = "Vprok.ru Перекрёсток – доставка продуктов на дом и на дачу Впрок";
            String actualTitle = title();
            assertThat(actualTitle).isEqualTo(expectedTitle);
        });
    }


    @Test
    @DisplayName("Перейти на страницу Каталога")
    void testCatalog(){
        step("Open url 'https://www.vprok.ru/'", () ->
                open("https://www.vprok.ru/"));
        step("Перейти на страницу Каталога", () -> {
            $(".xfnew-header__catalog-button").click();
            $$(".fo-catalog-menu").findBy(text("Молоко, сыр, яйца")).click();
        });
    }

    @Test
    @DisplayName("Сменить регион")
    void testChangeRegion(){
        step("Open url 'https://www.vprok.ru/'", () ->
                open("https://www.vprok.ru/"));
        step("Регион", () -> {
            $(".xfnew-header__change-region").click();
            $(".xf-popup-polygons__block-check-region").shouldHave(text("Выберите ваш регион"));
        });
    }

    @Test
    @DisplayName("Открыть страницу с акциями")
    void testOpenPromoPage(){
        step("Open url 'https://www.vprok.ru/'", () ->
                open("https://www.vprok.ru/"));
       step("Кликнуть на блок Акции над шапкой", () -> {
            $(byText("Акции")).click();;
           $(".xf-caption__title").shouldHave(text("Акции"));
        });
   }





    @Test
    @DisplayName("Открыть рецепт")
    void testOpenRecipe(){
        step("Open url 'https://www.vprok.ru/'", () ->
                open("https://www.vprok.ru/"));
        step("Проскролить до блока с рецептами", () -> {
            $(".xf-mp-recipe-news__list").scrollIntoView(true);


        });
//        step("Проверяем, что открылась страница с рецептом", () -> {
//            $(".xf-popup-polygons__block-check-region").shouldHave(text("Выберите ваш регион"));
//        });
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