package br.ufjf.dcc168.fullteaching;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.gecko.driver", String.valueOf(BaseTest.class.getClassLoader().getResource("geckodriver").getFile()));

        if(driver == null)
            driver = new FirefoxDriver();
    }

    public static void click(By identifier){
        driver.findElement(identifier).click();
    }
}
