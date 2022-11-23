package org.example.Pages;

import org.example.StepDefinition.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P02_Login {
    public WebElement loginButton()
    {
        return Hooks.driver.findElement(By.xpath("//a[@href=\"/login?returnUrl=%2F\"]"));
    }
    public WebElement email()
    {
        return Hooks.driver.findElement(By.id("Email"));
    }
    public WebElement password()
    {
        return Hooks.driver.findElement(By.id("Password"));
    }
    public WebElement pressLogin()
    {
        return Hooks.driver.findElement(By.cssSelector("button[class=\"button-1 login-button\"]"));
    }
    public WebElement myAccount ()
    {
        return Hooks.driver.findElement(By.className("ico-account"));
    }
    public WebElement errorMessage()
    {
        return Hooks.driver.findElement(By.className("message-error"));
    }
    public WebElement forgetPassword ()
    {
        return Hooks.driver.findElement(By.xpath("//a[@href=\"/passwordrecovery\"]"));
    }
    public WebElement emailAddress ()
    {
        return Hooks.driver.findElement(By.id("Email"));
    }
    public WebElement recoverButton()
    {
        return Hooks.driver.findElement(By.name("send-email"));
    }
    public WebElement resetMessage ()
    {
        return Hooks.driver.findElement(By.className("content"));
    }
}