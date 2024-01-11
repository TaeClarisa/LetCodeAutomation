package LetCode.Pages;

import org.openqa.selenium.By;

import java.util.List;

public class Dropdown extends BasePage {
    public Dropdown(){super(driver);}

    private By Drop_DownButton = By.xpath("//a[contains(text(),'Drop-Down')]");
    String selection;
    private By fruitList = By.id("fruits");
    private By messageConfirmation;
    private By superHerosList = By.id("superheros");
    public By setMsgConfirmation(String selection) {
     return this.messageConfirmation  = By.xpath("//p[contains(text(),'You have selected "+ selection +"')]");}
    private By langProgramList = By.id("lang");

    private By textOption;
    public By setTextOption(String message) {
        return this.textOption  = By.xpath("//option[contains(text(),'"+message+"')]");}

    //Enter section
    public void clickDropDown(){findElement(Drop_DownButton).click();}


    //Select the apple using visible text
    public String selectAppleFromList(String fruit) {
    selectByVisibleText(fruitList, "Apple");
    return getVisibleText(setMsgConfirmation(fruit));
    }
    //Get all fruit options
    public List<String> allFruits(){
    return getAllOptions(fruitList);
    }
    //Select your super hero's using Value
    public String selectYourSuperHero(String superHero){
    selectByValue(superHerosList, "ww");
    return getVisibleText(setMsgConfirmation(superHero));
    }
    //Select the last programming language using Index and print all the options
    public String selectLastProgLang(String languageProgramm){
    selectByIndex(langProgramList, 4);
    return getVisibleText(setMsgConfirmation(languageProgramm));}

    public List<String>getAllProgrammingLang(){return getAllOptions(langProgramList);}
}
