package br.ufjf.dcc168.fullteaching.usuario;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddStudentPage {

    private WebDriver driver;

    @FindBy(id = "add-attenders-icon")
    private WebElement addButton;

    @FindBy(css = "#md-tab-label-1-0 > div:nth-child(1)")
    private WebElement simpleTab;

    @FindBy(id = "input-attender-simple")
    private WebElement simpleEmail;

    @FindBy(id = "put-modal-btn")
    private WebElement sendButton;

    @FindBy(css = "#md-tab-label-1-1 > div:nth-child(1)")
    private WebElement multipleTab;

    @FindBy(id = "input-attender-separator")
    private WebElement multipleSeparator;

    @FindBy(id = "input-attender-multiple")
    private WebElement multipleEmails;

    public AddStudentPage(WebDriver driver) {
        this.driver = driver;
    }

    public AddStudentPage addStudent(String email) {
        simpleTab.click();
        simpleEmail.sendKeys(email);
        sendButton.click();

        return this;
    }

    public AddStudentPage addMultipleStudents(String emails, String separator) {
        multipleTab.click();
        multipleSeparator.sendKeys(separator);
        multipleEmails.sendKeys(emails);
        sendButton.click();

        return this;
    }
}
