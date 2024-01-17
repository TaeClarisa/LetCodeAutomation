package LetCode.TC;

import LetCode.Pages.Elements;
import org.junit.Assert;

import java.util.List;

public class ElementsTC {

    public void TestingElements() {
        Elements elementsCases = new Elements();

        elementsCases.ClickFindElements();
        elementsCases.UserSearch();
        //Assert that user has image
        Assert.assertTrue("Github avatar is not visible", elementsCases.CheckImageIsPresent());

        //Assert the name of some public repo
        List<String> repoLinksAsString = elementsCases.findAllPublicRepoList();
        Assert.assertTrue(repoLinksAsString.contains("https://github.com/TaeClarisa/LetCodeAutomation"));

        //Assert that no.of public repositories are listed correctly
        Integer actualNumberOfRepos = elementsCases.findAllPublicRepoList().size();
        Assert.assertTrue(actualNumberOfRepos.equals(2));
    }
}
