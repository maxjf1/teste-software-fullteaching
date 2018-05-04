package br.ufjf.dcc168.fullteaching;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.gecko.driver", "/home/rodolpho/Downloads/geckodriver-v0.20.1-linux64/geckodriver");

        if(driver == null)
            driver = new FirefoxDriver();
    }

    public static void click(By identifier){
        driver.findElement(identifier).click();
    }
}
