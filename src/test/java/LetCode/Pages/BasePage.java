package LetCode.Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BasePage {
    protected static WebDriver driver;
    private static String browser;

    public BasePage(WebDriver driver) {
        try {
            BasePage.driver = getDriver(browser);
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

    /*----------Instances----------*/
    Actions action = new Actions(driver);

    /*Find Element/s*/
    //This method return an element to interact with it
    public WebElement findElement(By element) {
        waitFor.until(ExpectedConditions.visibilityOfElementLocated(element));
        return driver.findElement(element);
    }

    //This method return all the elements in a list
    /*public List<WebElement> findAllElements(By element) {
        waitFor.until(ExpectedConditions.visibilityOfElementLocated(element));
        return driver.findElements(element);
    }*/

    public List<WebElement> findAllElements(By element) {
        waitFor.until(ExpectedConditions.visibilityOfElementLocated(element));
        return driver.findElements(element);
    }

    /*--Driver Navigation Commands--*/
//Launch Website and resize the browser
    public static void navigateTo(String url) {
        Dimension d = new Dimension(1024, 768);
        driver.navigate().to(url);
        //driver.manage().window().setSize(d);
        driver.manage().window().maximize();
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

    /*-------------ACTIONS------------*/
    /*Click and Hold button*/
    public void clickAndHold(By element) {
        action.clickAndHold().build().perform();
    }

    /*Drag and Drop*/
    //This method firstly performs a click-and-hold on the source element,
    // moves to the location of the target element and then releases the mouse.
    public void dragAndDrop(By dragElement, By dropElement) {
        action.dragAndDrop(findElement(dragElement), findElement(dropElement)).build().perform();
    }

    //This method firstly performs a click-and-hold on the source element,
    // moves to the given offset and then releases the mouse.
    public void dragAnDropBy(By dragElement, By dropElement, int x, int y) {
        Dimension target = findElement(dropElement).getRect().getDimension();
        int height = findElement(dropElement).getSize().getHeight();
        int width = findElement(dropElement).getSize().getWidth();
        System.out.println("Height: " + height + "Width: " + width);
        try {
            action.dragAndDropBy(findElement(dragElement), x, y).build().perform();
        } catch (MoveTargetOutOfBoundsException outOfBoundsException) {
            System.out.println("*** Out of bounded " + "Height: " + height + "Width: " + width + " ***");
        }
    }

    //Select all elements in a list
    public void selectAll(By elements) {
        List<WebElement> elementList = findAllElements(elements);
        for (WebElement e : elementList) {
            action
                    .sendKeys(Keys.CONTROL)
                    .moveToElement(e)
                    .click()
                    .sendKeys(Keys.CONTROL)
                    .perform();
        }
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

    //Get all dropdown options as String and return as List of String
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
        System.out.println(driver.getCurrentUrl());
    }

    // Opens a new tab and switches to new tab - new implementations according Selenium dev
    public void switchNewTab() {
        driver.switchTo().newWindow(WindowType.TAB);
    }

    // Opens a new window and switches to new window - new implementations according Selenium dev
    public void switchNewWindow() {
        driver.switchTo().newWindow(WindowType.WINDOW);
    }
}





