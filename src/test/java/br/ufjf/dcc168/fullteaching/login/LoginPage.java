package br.ufjf.dcc168.fullteaching.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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


    private WebElement failPanel;

    private boolean logged;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage login(String email, String password){

        loginButton.click();

        this.email.sendKeys(email);
        this.password.sendKeys(password);
        login.click();
        try{
            WebDriverWait wait = new WebDriverWait(driver, 3);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form.col > app-error-message:nth-child(4)")));

            this.failPanel = driver.findElement(By.cssSelector("form.col > app-error-message:nth-child(4)"));
           this.logged =false;
        }catch(Exception e){
            this.logged =true;
            System.out.println(e.getMessage());
        }



        return this;



    }

    public WebElement getFailPanel(){
        return this.failPanel;
    }

    public boolean isLogged() {
        return logged;
    }
}
