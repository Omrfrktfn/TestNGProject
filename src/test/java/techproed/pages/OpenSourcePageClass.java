package techproed.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.Driver;

public class OpenSourcePageClass {


    //username locate
    public static WebElement userName(){
        return Driver.getDriver().findElement(By.xpath("//*[@name='username']"));
    }

    //password locate
    public static WebElement password(){
        return Driver.getDriver().findElement(By.xpath("//*[@name='password']"));
    }


    //loginButton locate
    public static WebElement loginButton(){
        return Driver.getDriver().findElement(By.xpath("//*[@type='submit']"));
    }

    //verify locate
    public static WebElement verify(){
        return Driver.getDriver().findElement(By.xpath("//h6"));
    }
}
