package LetCode.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Elements extends BasePage {
    public Elements() {
        super(driver);
    }

    //Elements
    private By findElementsButton = By.linkText("Find Elements");
    private By inputName = By.name("username");
    private By searchBtn = By.id("search");
    private By image = By.xpath("//figure/img[@class='is-rounded']");

    private By tags;

    public By setTags(String text) {
        return this.tags = By.xpath("//div[@class='tags has-addons']/span[contains(text(),'" + text + "')]");
    }

    private By repoList = By.xpath("//div[@class='block']/div//li/a");

    /*Steps*/
    public void ClickFindElements() {
        findElement(findElementsButton).click();
    }

    public void UserSearch() {
        findElement(inputName).sendKeys("TaeClarisa");
        findElement(searchBtn).click();
    }

    //Verify image is visible
    public boolean CheckImageIsPresent() {
        return findElement(image).isDisplayed();
    }

    //List all the repo links available
    public List<String> findAllPublicRepoList() {
        List<WebElement> anchorList = findAllElements(repoList);
        List<String> hrefList = new ArrayList<>();

        for (WebElement anchor : anchorList) {
            String href = anchor.getAttribute("href");
            hrefList.add(href);
            System.out.println(hrefList);
        }
        return hrefList;
    }

}









