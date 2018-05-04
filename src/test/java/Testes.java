import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Testes {

    static WebDriver driver;

    private static void log(String message){
        System.out.println(message);
    }

    private static void log(String message, Boolean newLine){
        if(newLine)
            log(message);
        else
            System.out.print(message);
    }


    public static void accessCourse(){
        log("Accessing main Course...", false);
        driver.get("https://atlantis.isti.cnr.it:5000");
        WebElement courseButton = driver.findElement(By.cssSelector("li.collection-item:nth-child(1) > div:nth-child(1) > div:nth-child(2) > span:nth-child(1)"));
        courseButton.click();
        wait(2000);
        log("Done!");
    }


    private static void wait(int time){
        try{
            Thread.sleep(time);
        }
        catch (Exception e){ }
    }

    public static void click(String cssSelector, int timeout){
        driver.findElement(By.id("md-tab-label-0-1")).click();
        if(timeout > 0)
            wait(timeout);
    }

    public static void click(String cssSelector){
        click(cssSelector, 0);
    }

    public static void fill(String cssSelector, String value){
        driver.findElement(By.cssSelector(cssSelector)).sendKeys(value);
    }

    @BeforeClass
    public static void beginTests() {
        System.setProperty("webdriver.gecko.driver", "/home/souzajbr/Downloads/geckodriver-v0.20.1-linux64/geckodriver");
        driver = new FirefoxDriver();
    }

//    @AfterClass
    public static void finishTests() {
        wait(5000);
        driver.close();
    }


    @Test
    public void login(){
        log("Testing Login");
        driver.get("https://atlantis.isti.cnr.it:5000/");

        // modalButton
        click("#navigation-bar > div > ul > li:nth-child(2) > a");

        //email
        fill("[name=\"email\"]", "student1@gmail.com");

        //senha
        fill("[name=\"password\"]", "pass");

        // next
        click("log-in-btn", 3000);
    }

    @Test
    public void TestAccessCourse(){
        log("Testing Access Course");
        accessCourse();
    }

    @Test
    public void TestNavigateCourse(){
        log("Testing Course Navigation");
        accessCourse();

        // navigate tabs

        // Tab 2
        click("md-tab-label-0-1", 2000);

        // Tab 3
        click("md-tab-label-0-2", 2000);

        // Tab 4
        click("md-tab-label-0-3", 2000);

        // Tab 5
        click("md-tab-label-0-4", 2000);

        // Tab 1
        click("md-tab-label-0-0", 2000);
    }

    @Test
    public void TestLogout(){
        log("Testing logout");

        // open dropdown
        click("[data-activates=\"dropdown1\"]", 2000);

        click("#logout-button", 2000);
    }
}
