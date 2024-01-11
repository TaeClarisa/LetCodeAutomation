package LetCode.TC;

import LetCode.Pages.Windows;
import org.junit.Assert;

public class WindowsTC {
   Windows windows = new Windows();
    public void TestingWindowHandle(){

        windows.clickTabs();
        windows.HandlingOneWindow();

        String actualPageTittle = windows.getPageTittle();
        String expectedPageTittle = "Practice and become pro in test automation";
        System.out.println(actualPageTittle);
        Assert.assertTrue(actualPageTittle.contains(expectedPageTittle));
       windows.closingWindows();
    }
}
