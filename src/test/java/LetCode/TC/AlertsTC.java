package LetCode.TC;

import LetCode.Pages.Alert;
import org.junit.Assert;

public class AlertsTC {
    Alert alerts = new Alert();
    String name = "Clarisa Saade";
   public void TestAlertManage(){
      alerts.clickDialog();
       alerts.acceptSimpleAlert();
       String actualAlertText = alerts.getTextInTheAlert();
       System.out.println(actualAlertText);
       String expectAlertText = "Are you happy with LetCode?";
       Assert.assertEquals("Message in the alert is: "+actualAlertText,expectAlertText,actualAlertText);
       alerts.cancelAlert();

       alerts.typeYourNameAndAccept();
       String actualName = alerts.getNameSent();
       String expectedName = name;
       System.out.println("The name sent to the alert is: " + actualName);
        Assert.assertTrue(actualName.contains(expectedName));

        alerts.setCloseModernAlert();
   }
}
