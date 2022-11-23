package org.example.Pages;

import org.example.StepDefinition.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P01_Register {
    public WebElement RegisterLink()
    {
        return Hooks.driver.findElement(By.className("ico-register"));
    }
    public WebElement GenderType()
    {
        return Hooks.driver.findElement(By.id("gender-male"));
    }
    public WebElement FirstName ()
    {
        return Hooks.driver.findElement(By.id("FirstName"));
    }
    public WebElement LastName ()
    {
        return Hooks.driver.findElement(By.id("LastName"));
    }
    public WebElement BirthDay()
    {
        return Hooks.driver.findElement(By.name("DateOfBirthDay"));
    }
    public WebElement BirthMonth()
    {
        return Hooks.driver.findElement(By.name("DateOfBirthMonth"));
    }
    public WebElement BirthYear()
    {
        return Hooks.driver.findElement(By.name("DateOfBirthYear"));
    }
    public WebElement email ()
    {
        return Hooks.driver.findElement(By.id("Email"));
    }
    public WebElement pasword()
    {
        return Hooks.driver.findElement(By.id("Password"));
    }
    public WebElement confirmPassword()
    {
        return Hooks.driver.findElement(By.id("ConfirmPassword"));
    }
    public WebElement registerButton()
    {
        return Hooks.driver.findElement(By.id("register-button"));
    }
    public  WebElement successMessage()
    {
        return Hooks.driver.findElement(By.className("result"));
    }
}