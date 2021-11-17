package resources;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public WebDriver driver;
    public Properties prop;

    public WebDriver initializeDriver() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Malini\\Flexon_Training\\EbayProject\\src\\main\\java\\resources\\data.properties");
        prop.load(fis);
        String browserName = prop.getProperty("browser");

        if (browserName.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver","C:\\Malini\\Selenium\\chromedriver.exe");
            driver = new ChromeDriver();
        }

        else if (browserName.equals("IE"))
        {
            System.setProperty("webdriver.ie.driver","C:\\Malini\\Selenium\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe");
             driver = new InternetExplorerDriver();
        }

        else if (browserName.equals("firefox"))
        {
            System.setProperty("webdriver.gecko.driver","C:\\Malini\\Selenium\\geckodriver.exe");
            driver = new FirefoxDriver();

        }

        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }

}
