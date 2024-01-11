package LetCode.TC;

import LetCode.Pages.Frames;
import org.junit.Assert;

public class FramesTC {

    Frames frameCases = new Frames();

    public void TestPageWithIframes() {
        frameCases.clickDialog();
        frameCases.enterDetails();
        /*Validation of Form Tittle*/
        String actualFormTittle = frameCases.getFormTittle();
        System.out.println(actualFormTittle);

        String expectedFormTittle = "Enter Details";
        Assert.assertTrue("The form tittle is: " + actualFormTittle, actualFormTittle.contains(expectedFormTittle));

        /*Validation of Page Tittle*/
        String actualPageTittle = frameCases.getPageTittle();
        System.out.println(actualPageTittle);
        String expectedPageTittle = "Frame";

        Assert.assertTrue("The page tittle is: " + actualPageTittle, actualPageTittle.contains(expectedPageTittle));


    }
}
