package org.example.pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class RegistrationPage {
    private WebDriver driver;
    private By nameForm = By.cssSelector("* > fieldset:nth-child(1) > div > div > input");
    private By emailForm = By.cssSelector("* > fieldset:nth-child(2) > div > div > input");
    private By passForm = By.cssSelector("* > fieldset:nth-child(3) > div > div > input");
    private By regButton = By.xpath("//button[text()='Зарегистрироваться']");
    private By loginButton = By.xpath("//a[text()='Войти']");
    private By passwordError = By.xpath("//p[@class='input__error text_type_main-default']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void sendKeysNameForm(String name) {
        driver.findElement(nameForm).sendKeys(name);
    }

    public void sendKeysEmailForm(String email) {
        driver.findElement(emailForm).sendKeys(email);
    }

    public void sendKeysPassForm(String password) {
        driver.findElement(passForm).sendKeys(password);
    }

    public void clickRegButton() {
        driver.findElement(regButton).click();
    }

    public void registrationStep(String name, String email, String password) {
        sendKeysNameForm(name);
        sendKeysEmailForm(email);
        sendKeysPassForm(password);
        clickRegButton();
    }

    public boolean isPasswordErrorVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(passwordError));
        return driver.findElement(passwordError).isDisplayed();
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}
