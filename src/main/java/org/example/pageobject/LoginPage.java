package org.example.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private By emailForm = By.xpath("//input[@type='text']");
    private By passForm = By.xpath("//input[@type='password']");
    private By loginButton = By.xpath("//button[text()='Войти']");
    private By registrationButton = By.xpath("//a[text()='Зарегистрироваться']");
    private By forgotPassword = By.xpath("//a[text()='Восстановить пароль']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void sendKeysEmailForm(String email) {
        driver.findElement(emailForm).sendKeys(email);
    }

    public void sendKeysPassForm(String password) {
        driver.findElement(passForm).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void waitOpenLoginPage() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(emailForm));
    }

    public void waitRegistrationButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(registrationButton));
    }

    public void loginStep(String email, String password) {
        waitOpenLoginPage();
        sendKeysEmailForm(email);
        sendKeysPassForm(password);
        clickLoginButton();
    }

    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }

    public void clickForgotPassButton() {
        driver.findElement(forgotPassword).click();
    }

    public void waitForgotPassButton() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(forgotPassword));
    }
}
