package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import java.util.List;

public class HomePage {

    public WebDriver driver;

    @FindBy(id = "gh-ac")
    WebElement searchBox;
    @FindBy(id = "gh-cat")
    WebElement category;
    @FindBy(id = "gh-btn")
    WebElement searchButton;
    @FindBy(className = "s-item__title")
    List<WebElement> result;
    @FindBy(className = "s-item__price")
    List<WebElement> price;
    @FindBy(className = "checkbox__control")
    List<WebElement> checkbox;
    @FindBy(linkText = "Electronics" )
    WebElement linkTx;


    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement getCategory() {
        return category;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getSearchBox()
    {
        return searchBox;
    }
    public List<WebElement> getResult() {
        return result;
    }

    public List<WebElement> getPrice() {
        return price;
    }

    public List<WebElement> getCheckbox() {
        return checkbox;
    }

    public WebElement getLinkTx() {
        return linkTx;
    }
}
