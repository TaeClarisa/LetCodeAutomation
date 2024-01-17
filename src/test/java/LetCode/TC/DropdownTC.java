package LetCode.TC;

import LetCode.Pages.Dropdown;
import org.junit.Assert;

import java.util.List;

public class DropdownTC {

    public void testingDropDowns() {
        Dropdown dropdownTest = new Dropdown();
        dropdownTest.clickDropDown();
        String itemSelected = dropdownTest.selectAppleFromList("Apple");
        String itemExpected = "You have selected Apple";
        Assert.assertEquals("The item selected is: " + itemSelected, itemExpected, itemSelected);
        List<String> dropDownFruitList = dropdownTest.allFruits();
        Assert.assertTrue("The list of fruits is: " + dropDownFruitList, dropDownFruitList.contains("Apple"));
        System.out.println(dropDownFruitList);

        String superHeroSelected = dropdownTest.selectYourSuperHero("Wonder Woman");
        String superHeoExpected = "You have selected Wonder Woman";
        Assert.assertEquals("Super Hero selected is: " + superHeroSelected, superHeoExpected, superHeroSelected);

        String languageProgrammSelected = dropdownTest.selectLastProgLang("C#");
        String languageProgrammExpected = "You have selected C#";
        Assert.assertEquals("Programming Languagle selected is " + languageProgrammSelected, languageProgrammSelected, languageProgrammExpected);

        List<String> allProgrammingLanguage = dropdownTest.getAllProgrammingLang();
        System.out.println(dropdownTest.getAllProgrammingLang());
        Assert.assertTrue(allProgrammingLanguage.contains("Swift"));


    }
}
