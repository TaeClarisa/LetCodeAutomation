package LetCode.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Sort extends BasePage {
    public Sort() {
        super(driver);
    }

    private By AUI_3Button = By.linkText("AUI - 3");
    private By box;

    public By setBox(String text) {
        return this.box = By.xpath("//div[contains(text(),'" + text + "')]");
    }

    private By toDoElementsList = By.xpath("//div[@class='example-container'][1]//div[@id='sample-box1']");
    private By doneElementsList = By.xpath("//div[@class='example-container'][2]//div[@id='sample-box1']");

    public void moveFrom_ToDo_To_Done() {
        findElement(AUI_3Button).click();
        dragAndDrop(setBox(" Get to work"), setBox(" Take a shower"));
    }

    public List<String> doneList() {
        List<WebElement> doneListElements = findAllElements(doneElementsList);
        List<String> doneList = new ArrayList<>();
        for (WebElement singleDone : doneListElements) {
            String text = singleDone.getText();
            doneList.add(text);
        }
        return doneList;
    }

    /*-*********************************************************************************************/
    public void moveAllElements() {
        refreshPage();
        List<WebElement> toDoList = findAllElements(toDoElementsList);
        for (WebElement singleToDO : toDoList) {
            String text = singleToDO.getText();
            dragAndDrop(setBox(text), setBox(" Get up"));
        }
    }
}
