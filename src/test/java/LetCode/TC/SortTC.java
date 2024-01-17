package LetCode.TC;

import LetCode.Pages.Sort;
import org.junit.Assert;

import java.util.List;

public class SortTC {
    Sort sortCases = new Sort();

    public void testingSortSingleElement() {
        sortCases.moveFrom_ToDo_To_Done();
        List<String> actualDone = sortCases.doneList();
        String expectedDone = "Get to work";
        Assert.assertTrue("List of Done is: " + actualDone, actualDone.contains(expectedDone));
    }
}
