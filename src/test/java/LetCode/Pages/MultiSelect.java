package LetCode.Pages;

import org.openqa.selenium.By;

public class MultiSelect extends BasePage {
    public MultiSelect() {
        super(driver);
    }

    private By AUI_4Btutton = By.linkText("AUI - 4");
    private By elementsList = By.id("selectable");

    public void selectAllListed() {
        findElement(AUI_4Btutton).click();
        selectAll(elementsList);
    }

}
