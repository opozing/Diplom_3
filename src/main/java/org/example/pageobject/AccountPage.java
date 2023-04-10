package org.example.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage {
    private WebDriver driver;
    private By headerMessage = By.xpath(
            "p[text()='В этом разделе вы можете изменить свои персональные данные']");
    private By loginForm = By.xpath("//input[@name='Name']");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitOpenAccountPage() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(headerMessage));
    }




}