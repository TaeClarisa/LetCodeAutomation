package LetCode.TC;

import LetCode.Pages.DragAndDrop;

public class DragAndDropByTC {
    DragAndDrop dragAndDropCases = new DragAndDrop();

    public void dragSquareToGivenOffset() throws InterruptedException {
        dragAndDropCases.dragElementAround();
        dragAndDropCases.dragAndDrop();
    }

}
