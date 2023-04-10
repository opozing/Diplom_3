package org.example.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage {
    private WebDriver driver;
    private By mainLogo = By.xpath("//div[@class='AppHeader_header__logo__2D0X2']");
    private By enterAccountButton = By.xpath("//button[text()='Войти в аккаунт']");


    public HeaderPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickMainLogo() {
        driver.findElement(mainLogo).click();
    }
    public void clickAccountButton() {
        driver.findElement(enterAccountButton).click();
    }
}
