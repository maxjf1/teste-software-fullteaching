package br.ufjf.dcc168.fullteaching.cursos;

import br.ufjf.dcc168.fullteaching.login.LoginTest;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCoursesPage {

    private WebDriver driver;

    @FindBy(id = "add-course-icon")
    private WebElement addCoursesBtn;


    private WebElement courseNameInput;

    @FindBy(id = "submit-post-course-btn")
    private WebElement submitBtn;




    public AddCoursesPage(WebDriver driver) {
        this.driver = driver;
    }

    public AddCoursesPage addCourses (String courseName){

        try{


            LoginTest loginTest = new LoginTest();
            loginTest.loginProfessor();

            WebDriverWait wait = new WebDriverWait(driver, 3);
            wait.until(ExpectedConditions.elementToBeClickable(addCoursesBtn));
            addCoursesBtn.click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#input-post-course-name")));

            this.courseNameInput = driver.findElement(By.cssSelector("#input-post-course-name"));

            courseNameInput.sendKeys(courseName);

            wait.until(ExpectedConditions.elementToBeClickable(submitBtn));

            submitBtn.click();



        }catch (Exception e){

            System.out.println(e.getMessage());
        }

        return this;
    }


}
