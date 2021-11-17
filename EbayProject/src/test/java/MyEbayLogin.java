import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.HomePage;
import pageObject.MyEbay;
import resources.Base;

import java.io.IOException;

public class MyEbayLogin extends Base {

    @AfterTest
    public void afterTest(){
        driver.close();
    }


        @Parameters("userName")
        @Test
        public void login(String user) throws IOException {
            driver = initializeDriver();
            driver.get(prop.getProperty("url"));
            HomePage l = new HomePage(driver);
            MyEbay s = new MyEbay(driver);


            try {
                s.getSaved().click();
                System.out.println("My Ebay has been clicked");
                s.getUid().sendKeys(user);
                System.out.println("User name Entered");
                s.getContnue().click();
                System.out.println("Continue Button clicked");
            }
            catch (org.openqa.selenium.NoSuchElementException e) {
                System.out.println("Oops This page need captcha. Please retry..");
            }

        }



}

