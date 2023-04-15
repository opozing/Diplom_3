package org.example.pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ConstruktorPage {
    private WebDriver driver;
    private By createOrderButton = By.xpath("//button[text()='Оформить заказ']");
    private By createBurgerBunner = By.xpath("//h1[text()='Соберите бургер']");
    private By loginButton = By.xpath("//button[text()='Войти в аккаунт']");
    private By rollsButton = By.xpath("//span[text()='Булки']");
    private By rollsButtonDiv = By.xpath("//span[text()='Булки']//parent::div");
    private By sausesButton = By.xpath("//span[text()='Соусы']");
    private By sausesButtonDiv = By.xpath("//span[text()='Соусы']//parent::div");
    private By fillingsButton = By.xpath("//span[text()='Начинки']");
    private By fillingsButtonDiv = By.xpath("//span[text()='Начинки']//parent::div");


    public ConstruktorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickRollsButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(rollsButton));
        driver.findElement(rollsButton).click();
    }

    public WebElement getRollsButtonDiv() {
        return driver.findElement(rollsButtonDiv);
    }

    public void clickSausesButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(sausesButton));
        driver.findElement(sausesButton).click();
    }

    public WebElement getSausesButtonDiv() {
        return driver.findElement(sausesButtonDiv);
    }

    public void clickFillingsButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(fillingsButton));
        driver.findElement(fillingsButton).click();
    }

    public WebElement getFillingsButtonDiv() {
        return driver.findElement(fillingsButtonDiv);
    }

    public void waitCreateBurgerBunner() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(createBurgerBunner));
    }

    public boolean isCreateOrderButtonVisible() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(createOrderButton));
        return driver.findElement(createOrderButton).isDisplayed();
    }

    public void clickLoginButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(loginButton));
        driver.findElement(loginButton).click();
    }
}
