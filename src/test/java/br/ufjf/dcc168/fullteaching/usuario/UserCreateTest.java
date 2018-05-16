package br.ufjf.dcc168.fullteaching.usuario;

import br.ufjf.dcc168.fullteaching.BaseTest;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class UserCreateTest extends BaseTest {

    @BeforeClass
    public static void beforeClass(){
        driver.get("https://atlantis.isti.cnr.it:5000/");

    }

    @Test
    public void createUser() {
        UserCreatePage userCreatePage = PageFactory.initElements(this.driver, UserCreatePage.class);

        userCreatePage.fillFields("teste@teste.com", "cao", "huehuehuebrbr");
    }
}
