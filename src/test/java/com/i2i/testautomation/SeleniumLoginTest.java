package com.i2i.testautomation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumLoginTest {

    private WebDriver driver;

    @Test
    public void shouldLoginSuccessfullyToSauceDemo() {
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        WebElement usernameInput = driver.findElement(By.id("user-name"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameInput.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");
        loginButton.click();

        String currentUrl = driver.getCurrentUrl();

        Assertions.assertTrue(
                currentUrl.contains("inventory"),
                "Login failed. Inventory page was not opened."
        );
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
        //    driver.quit();
        }
    }
}