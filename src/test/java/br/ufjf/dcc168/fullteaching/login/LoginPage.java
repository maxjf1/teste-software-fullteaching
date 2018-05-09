package br.ufjf.dcc168.fullteaching.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    private WebDriver driver;

    @FindBy(css = ".right > li:nth-child(2) > a:nth-child(1)")
    private WebElement loginButton;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "log-in-btn")
    private WebElement login;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage loginProfessor(String email, String password){

        loginButton.click();

        this.email.sendKeys(email);
        this.password.sendKeys(password);
        login.click();

        return this;

    }
}
