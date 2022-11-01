package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DialogContent extends Parent{

    public DialogContent()
    {
        PageFactory.initElements(GWD.getDriver(), this);
    }
    @FindBy(id = "cookienotice-button-accept")
    private WebElement acceptCookies;

    @FindBy(xpath = "//*[@class=\"header-navigation-button\"]")
    private WebElement mainSearchButton;

    @FindBy(xpath = "//*[@class=\"global-search-container__title\"]")
    private WebElement searchWelcoming;

    @FindBy(id = "global-search")
    private WebElement searchBox;

    @FindBy(xpath = "//*[@class=\"button button-tertiary\"]")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@class=\"page\"]")
    public List<WebElement> pageList;

    @FindBy(xpath = "(//li[@class=\"page page-active\"]//following-sibling::li)[1]")
    private WebElement nextButton;

    @FindBy(css = "[class='item item-with-image'] [class='item-description'] :nth-child(1)")
    public List<WebElement>openedPageHappyList;

    @FindBy(css = "[class='search-results-title']")
    private WebElement searchResultNumberVerify;

    @FindBy(id = "id_q")
    private WebElement menu;

    @FindBy(css = "[class='result-item-title']")
    private WebElement catalogVerify;

    @FindBy(linkText = "View this document")
    private WebElement viewDocument;

    @FindBy(css = "ul[class=\"result-list item-list\"]>li:nth-of-type(2) p")
    private WebElement downloadDocumentButton;

    WebElement myElement;

    public void findAndClick(String strElement)
    {
        switch (strElement)
        {
            case "acceptCookies" : myElement =acceptCookies; break;
            case "mainSearchButton" : myElement =mainSearchButton; break;
            case "searchButton" : myElement =searchButton; break;
            case "nextButton" : myElement =nextButton; break;
            case "viewDocument" : myElement =viewDocument; break;
            case "downloadDocumentButton" : myElement =downloadDocumentButton; break;

        }
        clickFunction(myElement);
    }

    public void findAndSend(String strElement, String value)
    {
        switch (strElement)
        {
            case "searchBox" : myElement =searchBox; break;
        }
        sendKeysFunction(myElement, value);
    }

    public void findAndContainsText(String strElement, String text)
    {
        switch (strElement)
        {
            case "searchWelcoming" : myElement =searchWelcoming; break;
            case "catalogVerify" : myElement =catalogVerify; break;
        }
        verifyContainsText(myElement,text);
    }

    public void waitAndSelect(String string)
    {
        Select ddmenu=new Select(menu);
        GWD.wait(1);
        ddmenu.selectByValue(string);
    }

    public WebElement getSearchResultNumberVerify()
    {
        return searchResultNumberVerify;
    }

    public WebElement getMenu()
    {
        return menu;
    }
}
