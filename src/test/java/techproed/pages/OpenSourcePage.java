package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class OpenSourcePage {

    /*

         Bir sayfanin locatelerini page class'inda tutariz. Page class'inda locatelere ulasabilmek icin
    PageFactory'den initelements() methodu ile driver'imimizi bu class'a tanimlariz.
    findelement()methodu yerine @FindBy notasyonu ile bu notasyona parametre olarak locateleri gireriz.

         */

    public OpenSourcePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@name='username']")
    public WebElement username;

    @FindBy(xpath = "//*[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//*[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")
    public WebElement loginButon;


    @FindBy(xpath = "//*[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
    public WebElement verify;




}
