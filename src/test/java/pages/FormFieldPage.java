package pages;

import enums.AutomationOption;
import enums.FavoriteColor;
import enums.FavoriteDrink;
import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormFieldPage {

    private final WebDriver driver;

    public FormFieldPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"feedbackForm\"]/label[1]")
    private WebElement name;

    @FindBy(xpath = "//*[@id=\"feedbackForm\"]/label[2]")
    private WebElement password;

    @FindBy(css = "#automation > option:nth-child(2)")
    private WebElement doYouLikeAutomation;

    @FindBy (xpath = "//Label[text()='Automation tools']/following-sibling::ul/li")
    private List<WebElement> automationTools;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "message")
    private WebElement message;

    @FindBy (id="feedbackForm")
    private WebElement form;

    @Step("Input name")
    public FormFieldPage inputName(String name) {
        this.name.sendKeys(name);
        return this;
    }

    @Step("Input password")
    public FormFieldPage inputPassword(String password) {
        this.password.sendKeys(password);
        return this;
    }

    @Step("Select favorite drink")
    public FormFieldPage selectFavoriteDrinks(FavoriteDrink... favoriteDrinks) {
        for (FavoriteDrink favoriteDrink : favoriteDrinks) {
            String id = favoriteDrink.getId();
            driver.findElement(By.id(id))
                    .click();
        }
        return this;
    }

    @Step("Select favorite colour")
    public FormFieldPage selectFavoriteColor(FavoriteColor favoriteColor) {
        String id = favoriteColor.getId();
        driver.findElement(By.id(id))
                .click();
        return this;
    }

    @Step("Select automation option")
    public FormFieldPage selectAutomationOption(AutomationOption automationOption) {
        String css = automationOption.getCss();
        this.doYouLikeAutomation.click();
        driver.findElement(By.cssSelector(css))
                .click();
        return this;
    }

    @Step("Get automation options list size")
    public int getAutomationToolsSize() {
        if (this.automationTools.isEmpty()) {
            throw new IllegalStateException("Automation tools list is empty");
        }
        return this.automationTools.size();
    }

    @Step("Get longest automation tool name")
    public String getLongestAutomationToolName() {
        if (this.automationTools.isEmpty()) {
            throw new IllegalStateException("Automation tools list is empty");
        }
        return automationTools.stream()
                .map(WebElement::getText)
                .max(Comparator.comparingInt(String::length))
                .get();
    }

    @Step("Input email")
    public FormFieldPage inputEmail(String email) {
        this.email.sendKeys(email);
        return this;
    }

    @Step("Input message")
    public FormFieldPage inputMessage(String message) {
        this.message.sendKeys(message);
        return this;
    }

    @Step("Submit form")
    public FormFieldPage submitForm() {
        this.form.submit();
        return this;
    }

    @Step("Assert alert message")
    public FormFieldPage checkAlertMessage(String expectedMessage) {
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.alertIsPresent());
        assertEquals(expectedMessage, alert.getText(), "Messages do not match");
        return this;
    }
}
