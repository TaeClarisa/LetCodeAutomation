package LetCode.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;

public class Button extends BasePage {
    public Button(){super(driver);}

    private By clickButton = By.xpath("//a[contains(text(),'Click')]");
    private By goToHomeBtn = By.id("home");
    private By locationBtn = By.id("position");
    private By colorBtn = By.id("color");
    private By sizeBtn = By.id("property");
    private By disabledBtn = By.xpath("//button[contains(text(),'Disabled')]");
    private By holdButton = By.xpath("//button[@class='button is-primary' and @id='isDisabled']");

    public void clickClick(){findElement(clickButton).click();}
    public void goToHomeAndReturn() {
        findElement(goToHomeBtn).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        backPage();
    }

    //Get X & Y coordinates
    public void findLocation(){
        Point location = findElement(locationBtn).getLocation();
        int x = location.getX();
        int y = location.getY();
        System.out.println("Location of X: "+ x + "\n"+"Location of Y: "+y);}

    //Get background color by CssValue
    public String getBtnColour(){
        String btnColur = findElement(colorBtn).getCssValue("background-color");
        return btnColur;}

    //Get button size
    public void getBtnSize(){
        Dimension size = findElement(sizeBtn).getSize();
            int width = size.getWidth();
            int heigh = size.getHeight();

            System.out.println("Heigh is: "+ heigh + "\n"+"Width is: "+width);
            String sizeAsString = String.valueOf(findElement(sizeBtn).getSize());
            System.out.println(sizeAsString);
    //Otra forma de obtener ancho, altura y posicion
            Rectangle rect = findElement(sizeBtn).getRect();
        System.out.println("Width "+rect.getWidth());
        System.out.println("Heigh "+rect.getHeight());
        System.out.println("Position "+rect.getPoint());
    }

    public boolean isButtonEnabled(){
        boolean isEnabled = false;
        if (findElement(disabledBtn).isEnabled()){
            return true;}
        return isEnabled;
    }
 public void clickAndHoldBtn(){clickAndHold(holdButton);}


}

