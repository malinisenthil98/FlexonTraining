package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyEbay {

    public WebDriver driver;
    @FindBy(linkText = "My eBay" )
    WebElement saved;
    @FindBy(id = "userid" )
    WebElement uid;
    @FindBy(id = "signin-continue-btn" )
    WebElement contnue;

    public MyEbay(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement getSaved() {
        return saved;
    }

    public WebElement getUid() {
        return uid;
    }

    public WebElement getContnue() {
        return contnue;
    }
}
