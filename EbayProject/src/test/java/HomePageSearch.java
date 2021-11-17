import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObject.HomePage;
import resources.Base;

import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;


public class HomePageSearch extends Base {

    @AfterTest
    public void afterTest(){
        driver.close();
    }


    @Test
    public void searchItem() throws IOException {
        String item = "laptop i7";
        String cat = "Computers/Tablets & Networking";
        String brand = "HP";
        String linkText = "Electronics";
        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
        HomePage l = new HomePage(driver);
        l.getLinkTx().click();
        String actualTitle = driver.getTitle();
        System.out.println(linkText+" link has been clicked!");
        System.out.println("Title of the Page : "+actualTitle);
        l.getSearchBox().sendKeys(item);
        System.out.println("Item : "+item+" has been entered in Search box");
        Select s = new Select(l.getCategory());

        s.selectByVisibleText(cat);

        System.out.println("Category : "+cat+" has been selected");
        l.getSearchButton().click();
        System.out.println("Search Button clicked");
        String des = l.getResult().get(1).getAttribute("innerText");
        System.out.println("Description of first item on search result : "+des);
        String itemPrice = l.getPrice().get(1).getText();
        System.out.println("Price of first item on search result : "+itemPrice);
        for (WebElement chkbox: l.getCheckbox()){
            String br = chkbox.getAttribute("aria-label");
            System.out.println(br);
            if (br != null && !br.equals("")){
                if (br.contentEquals(brand)) {
                    System.out.println(br);
                    chkbox.click();
                    System.out.println("Check Box : " + br + " has been checked");
                    break;
                }
            }
        }

    }
    @Test
    public void validation(){
        String expectedTitle = "laptop i7 in \"Computers, Tablets, and Networking\" | eBay";
        System.out.println("Expected Title : "+expectedTitle);
        String actualTitle = driver.getTitle();
        System.out.println("Actual Title : "+actualTitle);
        if (expectedTitle.equals(actualTitle))
            System.out.println("Test Passed");
        else
            System.out.println("Test Failed");
    }



}