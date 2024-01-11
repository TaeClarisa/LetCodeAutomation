package LetCode.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Input extends BasePage {
    public Input(){super(driver);}

    private By editButton = By.xpath("//*[@href=\"/edit\"]");
    private By fullName = By.id("fullName");
    private By appendText = By.id("join");
    private By textBox = By.id("getMe");
    private By clearText = By.id("clearMe");
    private By disabledField = By.id("noEdit");
    private By readonlyText = By.id("dontwrite");

    public void clickEdit(){findElement(editButton).click();}

    public void enterYourFullName(){findElement(fullName).sendKeys("ClariSa");}

    public void setAppendText(){findElement(appendText).clear();
    findElement(appendText).sendKeys("Interact with different types of input fields", Keys.TAB);}

    public String getTextInBox(){return findElement(textBox).getAttribute("value");}

    public void clearTextInBox(){findElement(clearText).clear();}

    public boolean confirmEditFieldIsDisabled(){
        boolean isEnabled = false;
        if (findElement(disabledField).isEnabled()){
            return true;}
        return isEnabled;
    }
     public String confirmTexttIsReadOnly(){return findElement(readonlyText).getAttribute("readonly");}
    }

