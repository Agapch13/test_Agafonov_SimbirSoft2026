package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.FormFieldPage;

import static enums.AutomationOption.YES;
import static enums.FavoriteColor.YELLOW;
import static enums.FavoriteDrink.COFFEE;
import static enums.FavoriteDrink.MILK;

class FormTest extends TestBase {

    private final static String URL = "https://practice-automation.com/form-fields/";

    @BeforeEach
    void openUrl() {
        driver.get(URL);
    }

    @Test
    void formFieldsTest() {
        var formFieldPage = new FormFieldPage(driver);

        formFieldPage.inputName("name")
                .inputPassword("password")
                .selectFavoriteDrinks(MILK, COFFEE)
                .selectFavoriteColor(YELLOW)
                .selectAutomationOption(YES)
                .inputEmail("name@example.com");

        int automationToolsSize = formFieldPage.getAutomationToolsSize();
        String longestAutomationToolName = formFieldPage.getLongestAutomationToolName();
        formFieldPage.inputMessage("%d %s".formatted(automationToolsSize, longestAutomationToolName))
                .submitForm()
                .checkAlertMessage("Message received!");
    }
}
