package br.ufjf.dcc168.fullteaching.login;

import br.ufjf.dcc168.fullteaching.BaseTest;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class LoginTest extends BaseTest {

    @BeforeClass
    public static void beforeClass(){
        driver.get("https://atlantis.isti.cnr.it:5000/");

    }

    @Test
    public void loginProfessor()
    {
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

        loginPage.loginProfessor("teacher@gmail.com","pass");
    }

}
