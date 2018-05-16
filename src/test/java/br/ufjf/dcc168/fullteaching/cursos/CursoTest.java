package br.ufjf.dcc168.fullteaching.cursos;

import br.ufjf.dcc168.fullteaching.BaseTest;
import br.ufjf.dcc168.fullteaching.login.LoginPage;
import br.ufjf.dcc168.fullteaching.login.LoginTest;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

public class CursoTest extends BaseTest {


    @BeforeClass
    public static void beforeClass(){
        driver.get("https://atlantis.isti.cnr.it:5000/");

    }

    @Test
    public void addNewCourse(){

        AddCoursesPage addCourses = PageFactory.initElements(driver,AddCoursesPage.class);
        addCourses.addCourses("Grupo 7: Novo Curso");


    }
}
