package LetCode.Pages;


import org.openqa.selenium.By;

public class Alert extends BasePage{
    public Alert(){super(driver);}

    private By dialogButton = By.xpath("//a[contains(text(),'Dialog')]");
    private By alertButton;

    public By getAlertButton(String text) {
        return this.alertButton = By.xpath("//button[contains(text(),'"+text+"')]");
    }

    private By nameFromPromptAlert = By.id("myName");

    private By closeModernAlert = By.xpath("//button[@aria-label='close']");

    //Enter Section
    public void clickDialog(){findElement(dialogButton).click();}
    //Accept the Alert
    public void acceptSimpleAlert(){
        findElement(getAlertButton("Simple Alert")).click();
        acceptAlert();}

    //Dismiss the Alert & print the alert text
    public String getTextInTheAlert(){
        findElement(getAlertButton("Confirm Alert")).click();
        String textInAlert = getAlertText();
        return textInAlert;}
    public void cancelAlert(){dismissAlert();}

    //Type your name & accept
    public void typeYourNameAndAccept(){
        findElement(getAlertButton("Prompt Alert")).click();
        sendTextToAlertBox("Clarisa Saade");
        acceptAlert();}
    public String getNameSent(){return getVisibleText(nameFromPromptAlert);}

    public void setCloseModernAlert(){
        findElement(getAlertButton("Modern Alert")).click();
        findElement(closeModernAlert).click();
    }
}
