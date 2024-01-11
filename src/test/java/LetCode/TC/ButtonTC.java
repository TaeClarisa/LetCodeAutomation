package LetCode.TC;

import LetCode.Pages.Button;
import org.junit.Assert;

public class ButtonTC {
    Button newButton = new Button();

    public void TestDifferentButtons()  {
        newButton.clickClick();
        System.out.println("Going into Button Page");

        newButton.goToHomeAndReturn();
        newButton.findLocation();
        newButton.getBtnColour();

        String actualColour = newButton.getBtnColour();
        String expectedColour = "rgba(138, 77, 118, 1)";
        Assert.assertTrue("Button colour is:" + actualColour,actualColour.contains(expectedColour));

        newButton.getBtnSize();

        Assert.assertFalse("Button is enabled",newButton.isButtonEnabled());

        newButton.clickAndHoldBtn();
    }

}
