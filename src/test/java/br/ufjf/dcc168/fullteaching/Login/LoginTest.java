package br.ufjf.dcc168.fullteaching.Login;

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
        Login login = PageFactory.initElements(driver, Login.class);

        login.loginProfessor("teacher@gmail.com","pass");
    }

}
