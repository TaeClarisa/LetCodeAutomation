package TestSuite;

import LetCode.Pages.BasePage;
import LetCode.TC.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class PageSuite {
    static WebDriver driver = null;
    static String browser = "Chrome";
    static final String urlLetCode = "https://letcode.in/test";

    @BeforeClass
    public static void TestConfig() {
        try {
            driver = BasePage.getDriver(browser);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        BasePage.navigateTo(urlLetCode);

    }

    @Test
    public void testingInputFields() {
        InputTC tc1 = new InputTC();
        tc1.TestInputFields();
    }

    @Test
    public void testingDifferentButtons() {
        ButtonTC tc2 = new ButtonTC();
        tc2.TestDifferentButtons();
    }

    @Test
    public void testingDropDowns() {
        DropdownTC tc3 = new DropdownTC();
        tc3.testingDropDowns();
    }

    @Test
    public void testingAlerts() {
        AlertsTC tc4 = new AlertsTC();
        tc4.TestAlertManage();
    }

    @Test
    public void testingIframes() {
        FramesTC tc4 = new FramesTC();
        tc4.TestPageWithIframes();
    }

    @Test
    public void testingOpenWindows() {
        WindowsTC tc5 = new WindowsTC();
        tc5.TestingWindowHandle();
    }

    @Test
    public void testingImageAndLinks() {
        ElementsTC tc6 = new ElementsTC();
        tc6.TestingElements();
    }

    @Test
    public void testingDragAndDropAction() throws InterruptedException {
        DragAndDropByTC tc7 = new DragAndDropByTC();
        tc7.dragSquareToGivenOffset();
    }

    @Test
    public void testingSortElements() {
        SortTC tc8 = new SortTC();
        tc8.testingSortSingleElement();
    }

    @Test
    public void testingMultiSelect() {
        MultiSelectTC tc9 = new MultiSelectTC();
        tc9.testingMultiSelect();
    }

    @AfterClass
    public static void closeBrowser() {
        //driver.quit();
    }


}
