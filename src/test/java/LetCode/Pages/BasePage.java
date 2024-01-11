package LetCode.Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.time.Duration;

public class BasePage {
    protected static WebDriver driver;
    private static String browser;

    public BasePage(WebDriver driver) {
        try {
            this.driver = getDriver(this.browser);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static WebDriver getDriver(String browser) throws Exception {
        if (driver == null) {
            switch (browser.toLowerCase()) {
                case "chrome": {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                }
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                }
                case "edge": {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                }
            }
        }
        return driver;
    }

    FluentWait waitFor = new FluentWait(driver)
            .withTimeout(Duration.ofSeconds(10))
            .pollingEvery(Duration.ofSeconds(2))
            .ignoring(Exception.class, StaleElementReferenceException.class);

   /* public static void waitFor(){
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
        wait.withTimeout(Duration.ofSeconds(2));
        wait.pollingEvery(Duration.ofSeconds(6));
        wait.ignoring(Exception.class, StaleElementReferenceException.class);
    }*/


    public WebElement findElement(By element) {
        return driver.findElement((By) element);
    }

    /*--Driver Navigation Commands--*/
//Launch Website and resize the browser
    public static void navigateTo(String url) {
        Dimension d = new Dimension(1024, 768);
        driver.navigate().to(url);
        driver.manage().window().setSize(d);
    }

    //Back one page with back button
    public static void backPage() {
        driver.navigate().back();
    }

    //Refresh page
    public static void refreshPage() {
        driver.navigate().refresh();
    }

    //Forward page
    public static void forwardPage() {
        driver.navigate().forward();
    }

    //Close page
    public static void closePage() {
        driver.close();
    }

    /*Input Text - Send Keys*/
    public void inputText(By element, String text) {
        findElement(element).sendKeys(text);
    }

    /*Get Text*/
    public String getVisibleText(By element) {
        return findElement(element).getText();
    }

    /*Actions*/
//Click and Hold button
    public void clickAndHold(By element) {
        Actions action = new Actions(driver);
        action.clickAndHold().perform();
    }

    /*Select*/
    //Select by value - element must be Select tag
    public void selectByValue(By element, String value) {
        Select select = new Select(findElement(element));
        select.selectByValue(value);
    }

    //Select by index
    public void selectByIndex(By element, int index) {
        Select select = new Select(findElement(element));
        select.selectByIndex(index);
    }

    //Select by Visible Text
    public void selectByVisibleText(By element, String text) {
        Select select = new Select(findElement(element));
        select.selectByVisibleText(text);
    }

    //Get all the options as String of the dropdwon and return as List of String
    public List<String> getAllOptions(By element) {
        Select select = new Select(findElement(element));
        List<WebElement> allOptions = select.getOptions();
        List<String> getOptions = new ArrayList<>();
        for (WebElement option : allOptions
        ) {
            getOptions.add(option.getText());
        }
        return getOptions;
    }

    /*Alert*/
    //Accept alert -click OK button-
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    //Dismiss alert -click Cancel button-
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    //capture the alert message
    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    //Send data to the alert box
    public void sendTextToAlertBox(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    /*Frames*/
    //Switch frame for index
    public void switchFrameByIndex(int index) {
        driver.switchTo().frame(index);
    }

    //Switch frame for tag name or ID
    public void switchFrameByName(String name) {
        driver.switchTo().frame(name);
    }

    //Switch frame for WebElement
    public void switchFrameByElement(By element) {
        driver.switchTo().frame(findElement(element));
    }

    //This method is used to come out of the present frame, then we can access the elements outside that frame and not inside of that frame.
    public void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }

    //This method is used to come out of all the frames and switch the focus at the page
    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    /*Window Handle*/
    //Switch window by  index
    public void switchWindow(int index) {
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windowHandlesList = new ArrayList<>(windowHandles);
        driver.switchTo().window(windowHandlesList.get(index));
        System.out.println(driver.getCurrentUrl().toString());
    }

    // Opens a new tab and switches to new tab
    public void switchNewTab() {
        driver.switchTo().newWindow(WindowType.TAB);
    }

    // Opens a new window and switches to new window
    public void switchNewWindow() {
        driver.switchTo().newWindow(WindowType.WINDOW);
    }


}
