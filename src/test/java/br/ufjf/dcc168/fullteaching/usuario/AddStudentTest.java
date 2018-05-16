package br.ufjf.dcc168.fullteaching.usuario;

import br.ufjf.dcc168.fullteaching.BaseTest;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import br.ufjf.dcc168.fullteaching.login.LoginTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddStudentTest extends BaseTest {

    private static AddStudentPage addStudentPage;

    @BeforeClass
    public static void init() {

        driver.get("https://localhost:5000");
        LoginTest login = new LoginTest();
        login.loginProfessor();

        sleep(2000);

        WebElement courseButton = driver.findElement(By.cssSelector("li.collection-item:nth-child(1) > div:nth-child(1) > div:nth-child(2) > span:nth-child(1)"));
        courseButton.click();

        WebElement studentsTab = driver.findElement(By.cssSelector("#md-tab-label-0-4 > div:nth-child(1)"));
        studentsTab.click();


    }

    public void openDialog() {
        sleep(200);
        WebElement addStudentsButton = driver.findElement(By.id("add-attenders-icon"));
        addStudentsButton.click();

        sleep(100);
        addStudentPage = PageFactory.initElements(driver, AddStudentPage.class);

        sleep(100);
        WebElement panel = driver.findElement(By.cssSelector(".card-panel > h5:nth-child(2)"));
    }

    @Test
    public void addMultipleStudents() {
        openDialog();
        addStudentPage.addMultipleStudents("student1@gmail.com;student2@gmail.com", ";");
        WebElement panel = driver.findElement(By.cssSelector(".card-panel > h5:nth-child(2)"));
        Assert.assertEquals(panel.getText(), "The following users where properly added");
    }

    @Test
    public void addSimpleStudent() {
        openDialog();

        WebDriverWait wait = new WebDriverWait(this.driver, 15);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".calendar-container > div:nth-child(2) > mwl-calendar-month-view:nth-child(1)")));
/*
        WebElement course = driver.findElement(By.cssSelector("li.collection-item:nth-child(1) > div:nth-child(1) > div:nth-child(2) > span:nth-child(1)"));
        course.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".l11")));*/


        addStudentPage.addStudent("student3@gmail.com");

        WebElement panel = driver.findElement(By.cssSelector(".card-panel > h5:nth-child(2)"));
        Assert.assertEquals(panel.getText(), "The following users where properly added");
    }

    @AfterClass
    public static void dispose() {
        driver.close();
    }
}
