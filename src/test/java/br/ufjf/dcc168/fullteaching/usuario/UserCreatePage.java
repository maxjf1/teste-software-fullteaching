package br.ufjf.dcc168.fullteaching.usuario;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserCreatePage {

    private WebDriver driver;

    @FindBy(id = "signUpButton")
    private WebElement signupDialogButton;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "nickName")
    private WebElement nickName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPassword;

    @FindBy(id = "recaptcha-anchor")
    private WebElement recaptchaAnchor;

    @FindBy(id = "sign-up-btn")
    private WebElement signupButton;

    public UserCreatePage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillFields(String email, String nickname, String password) {
        this.signupDialogButton.click();

        WebDriverWait wait = new WebDriverWait(this.driver, 10);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("recaptcha-anchor")));

        this.email.sendKeys(email);
        this.nickName.sendKeys(nickname);
        this.password.sendKeys(password);
        this.confirmPassword.sendKeys(password);

        this.recaptchaAnchor.click();
        this.signupButton.click();
    }
}
