package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class TechproPage {

    public TechproPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@name='username']")
    public WebElement username;


    @FindBy(xpath = "//*[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement submit;


    @FindBy(xpath = "//div[@role='alert']")
    public WebElement girisverify;


    @FindBy(xpath = "//*[@class='btn btn-dark']")
    public WebElement logout;

    @FindBy(xpath = "//h2")
    public WebElement loginPageVeriyfy;

}
