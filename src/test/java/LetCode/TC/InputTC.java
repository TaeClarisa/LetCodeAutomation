package LetCode.TC;
import LetCode.Pages.Input;
import org.junit.Assert;


public class InputTC {
    Input newInput = new Input();

    public void TestInputFields() {
        newInput.clickEdit();
        System.out.println("ingreso");

        newInput.enterYourFullName();
        System.out.println("ingreso mi nombre");

        newInput.setAppendText();

        String expected = "ortonikc";
        String actual = newInput.getTextInBox();
        Assert.assertTrue("Actual message into the box is: " + actual, actual.contains(expected));

        newInput.clearTextInBox();

        Assert.assertFalse(newInput.confirmEditFieldIsDisabled());

        String attribute = newInput.confirmTexttIsReadOnly();
        Assert.assertTrue(attribute.equals("true"));
        System.out.println(attribute);
    }

}
