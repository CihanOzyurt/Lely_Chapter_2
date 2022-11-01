package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static Utilities.GWD.driver;

public class Lely_Steps {

    DialogContent dc=new DialogContent();
    ArrayList<String> expectedHappySearchNumber=new ArrayList<>();

    @Given("Navigate to Lely")
    public void navigate_to_lely()
    {
        GWD.getDriver().get("https://www.lely.com/en");
        GWD.getDriver().manage().window().maximize();
        dc.findAndClick("acceptCookies");
    }

    @When("User clicks on search icon")
    public void user_clicks_on_search_icon()
    {
        dc.findAndClick("mainSearchButton");
    }

    @Then("Search area should appear")
    public void search_area_should_appear()
    {
        dc.findAndContainsText("searchWelcoming","What are you looking for?");
    }

    @When("User enters {string} in search box")
    public void userEntersInSearchBox(String arg0)
    {
        dc.findAndSend("searchBox", "happy");
    }

    @When("clicks search button")
    public void clicks_search_button()
    {
        dc.findAndClick("searchButton");
    }

    @Then("Verifies for each result contains happy")
    public void verifies_for_each_result_contains_happy()
    {
        for (WebElement element:dc.openedPageHappyList ) {
            expectedHappySearchNumber.add(element.getText());
        }
        for (int i = 0; i <dc.pageList.size(); i++) {
            for (WebElement element: dc.openedPageHappyList ) {
                expectedHappySearchNumber.add(element.getText());
            }
            dc.findAndClick("nextButton");
        }
        String resultString= dc.getSearchResultNumberVerify().getText().replaceAll("[^0-9]", "");
        int actualHappyNumber=Integer.parseInt(resultString);
        int expectedHappyNumber=expectedHappySearchNumber.size();
        System.out.println("actualHappyNumber = " + actualHappyNumber);
        System.out.println("expectedHappyNumber = " + expectedHappyNumber);
        Assert.assertEquals("Search function failed!",expectedHappyNumber,actualHappyNumber);
    }

    @Given("Navigate to lely-techdocs")
    public void navigateToLelyComTechdocs() {
        GWD.getDriver().get("https://www.lely.com/techdocs/");
        GWD.getDriver().manage().window().maximize();
        dc.findAndClick("acceptCookies");
    }

    @When("Select {string} from dropdown menu")
    public void selectFromDropdownMenu(String arg0) {
        dc.waitAndSelect("luna/eur/");
    }

    @And("Verify that catalog can be seen")
    public void verifyThatCatalogCanBeSeen() {
        dc.findAndContainsText("catalogVerify","LUNA EUR");
    }

    @Then("click to view this document")
    public void clickToViewThisDocument() {
        dc.findAndClick("viewDocument");
    }

    String mainWindowId= driver.getWindowHandle();
    @And("verify that document opened on a new tab")
    public void verifyThatDocumentOpenedOnANewTab() {
        String mainWindowId= driver.getWindowHandle();
        driver.getWindowHandles().forEach(tab->driver.switchTo().window(tab));
        String newTabID= driver.getWindowHandle();
        Assert.assertFalse(mainWindowId.equalsIgnoreCase(newTabID));
    }

    @Then("return to previous tab and download the document")
    public void returnToPreviousTabAndDownloadTheDocument() {
        driver.close();
        driver.switchTo().window(mainWindowId);
        dc.findAndClick("downloadDocumentButton");
    }





    @And("Verifies document is downloaded")
    public void verifiesDocumentIsDownloaded() {
        File file = new File("C:\\Users\\ozyur\\Downloads\\D-S032VT_-.pdf");//!!!file extension must seen in the Downloads file or delete ".pdf"
        GWD.wait(3);
        Assert.assertTrue(file.exists());




    }
}
