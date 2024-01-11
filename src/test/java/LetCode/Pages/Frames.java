package LetCode.Pages;

import org.openqa.selenium.By;

public class Frames extends BasePage {
    public Frames() {
        super(driver);
    }

    private By innerHtmlButton = By.xpath("//a[contains(text(),'Inner HTML')]");
    private By inputData;

    public By input(String tagName) {
        return this.inputData = By.xpath("//input[@name='" + tagName + "']");
    }

    private By emailIFrame = By.xpath("//iframe[@src='innerFrame']");
    private By tittleIFrame = By.xpath("//iframe[@src='frameUI']");
    private By pageTittleIFrame = By.xpath("//iframe[@name='google_esf']");
    private By tittle = By.xpath("//h1[contains(text(),'Enter Details')]");
    private By pageTittle = By.xpath("//h1[contains(text(),' Frame')]");

    //Enter Section
    public void clickDialog() {
        findElement(innerHtmlButton).click();
    }

    public void enterDetails() {
        switchFrameByIndex(0);
        inputText(input("fname"), "Clarisa");
        inputText(input("lname"), "Saade");
        switchFrameByElement(emailIFrame);
        inputText(input("email"), "tae.clarisa@gmail.com");
    }

    public String getFormTittle() {
        switchToDefaultContent();
        switchFrameByElement(tittleIFrame);
        return getVisibleText(tittle);
    }

    public String getPageTittle() {
        switchToParentFrame();
        return getVisibleText(pageTittle);
    }

}
