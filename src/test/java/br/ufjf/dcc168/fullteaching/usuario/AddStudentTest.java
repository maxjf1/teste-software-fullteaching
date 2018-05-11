package br.ufjf.dcc168.fullteaching.usuario;

import br.ufjf.dcc168.fullteaching.BaseTest;
import org.junit.BeforeClass;
import org.junit.Test;
import br.ufjf.dcc168.fullteaching.login.LoginTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddStudentTest extends BaseTest {

    @BeforeClass
    public static void setup() {
        driver.get("https://localhost:5000");
        LoginTest login = new LoginTest();
        login.loginProfessor();
    }

    @Test
    public void test() {
        WebDriverWait wait = new WebDriverWait(this.driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".calendar-container > div:nth-child(2) > mwl-calendar-month-view:nth-child(1)")));

        WebElement course = driver.findElement(By.cssSelector("li.collection-item:nth-child(1) > div:nth-child(1) > div:nth-child(2) > span:nth-child(1)"));
        course.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".l11")));
        AddStudentPage addStudentPage = PageFactory.initElements(driver, AddStudentPage.class);

        addStudentPage.addStudent("teste@gmail.com");
    }

}
