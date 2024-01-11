package LetCode.Pages;

import org.openqa.selenium.WebDriver;

public class TestingBrowser extends BasePage {
public TestingBrowser(){super(driver);}

    public static void main(String[] args) throws Exception {
       // EdgeDriverManager.edgedriver().setup();
        //FirefoxDriverManager.firefoxdriver().setup();
        //WebDriver driver;
        //driver = new EdgeDriver();
        //driver = new FirefoxDriver();
       // ChromeDriverManager.chromedriver().setup();
         //driver = new ChromeDriver();
    WebDriver driver = getDriver("Firefox");
    driver.get("https://yahoo.com");
        driver.quit();


    }
}
