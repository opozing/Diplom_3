package org.example.pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConstruktorPage {
    private WebDriver driver;
    private By createOrderButton = By.xpath("//button[text()='Оформить заказ']");
    private By createBurgerBunner = By.xpath("//h1[text()='Соберите бургер']");

    public ConstruktorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitOpenConstruktorPage() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(createBurgerBunner));
    }

    public boolean isCreateOrderButtonVisible() {
        return driver.findElement(createOrderButton).isDisplayed();
    }

}
