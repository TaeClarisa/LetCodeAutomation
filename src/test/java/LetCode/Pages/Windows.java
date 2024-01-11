package LetCode.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Windows extends BasePage {
    public Windows() {
        super(driver);
    }

    private By tabs = By.linkText("Tabs");
    private By openHomePage = By.id("home");
    private By pageTittle = By.xpath("//h1[contains(text(),' Practice and become pro in test automation')]");

    public void clickTabs() {
        findElement(tabs).click();
    }

    public void HandlingOneWindow() {
//Click on the home button
        findElement(openHomePage).click();
//Goto the newly opened tab
        switchWindow(2);
    }

    public String getPageTittle() {
        waitFor.until(ExpectedConditions.visibilityOfElementLocated(pageTittle));
//Print the title of the page
        return getVisibleText(pageTittle);
    }

public void closingWindows(){
//Close the child window
closePage();
//Close the parent window
switchWindow(1);
closePage();
}
}
