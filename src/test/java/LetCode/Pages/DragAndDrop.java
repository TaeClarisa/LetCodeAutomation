package LetCode.Pages;

import org.openqa.selenium.By;

public class DragAndDrop extends BasePage {
    public DragAndDrop() {
        super(driver);
    }

    //Drag and Drop By given offset
    private By AUI_1Btutton = By.linkText("AUI - 1");
    private By draggable = By.id("sample-box");
    private By droppable = By.className("example-boundary");

    //Drag from source to target
    private By AUI_2Btutton = By.linkText("AUI - 2");
    private By dragFrom = By.id("draggable");
    private By dropTo = By.id("droppable");

    /*Steps*/
    //Drag the square within the dotted container
    public void dragElementAround() {
        findElement(AUI_1Btutton).click();
        System.out.println("Insight");
        dragAnDropBy(draggable, droppable, 300, 1500);
        backPage();
        System.out.println("Return to Home Page");
    }

    //Drag from source to target
    public void dragAndDrop() {
        findElement(AUI_2Btutton).click();
        System.out.println("Insight");
        dragAndDrop(dragFrom, dropTo);
    }


}
