package PageObject;


import PageObject.SedHub.DirectoriesPage;
import PageObject.SedHub.JournalPage;
import PageObject.SedHub.SignatoriesPage;
import Utils.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SedPage extends PageObject {
    private WebDriver driver;

    public Header header;

    @FindBy(xpath = "//div[@data-cms-id='111625']")
    WebElement JournalButton;
    @FindBy(xpath = "//div[@data-cms-id='111654']")
    WebElement DirectoryButton;
    @FindBy(xpath = "//div[@data-cms-id='116001']")
    WebElement SignatoriesButton;
    @FindBy(xpath = "//div[@data-cms-id='111626']")
    WebElement AnalyticsButton;
    @FindBy(xpath = "//div[@class='imc_copyright']")
    WebElement Copyright;


    public SedPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        header = new Header(driver);
    }

    //Журнал Документов
    public JournalPage goToJournalPage() {
        JournalButton.click();
        return new JournalPage(driver);
    }

    public void checkContents() {
        Assert.assertTrue(JournalButton.isEnabled());
        Assert.assertTrue(DirectoryButton.isEnabled());
        Assert.assertTrue(SignatoriesButton.isEnabled());
        Assert.assertTrue(AnalyticsButton.isEnabled());
        Assert.assertTrue(Copyright.isEnabled());
    }

    public DirectoriesPage goToDirectories() {
        DirectoryButton.click();
        return new DirectoriesPage(driver);
    }

    public SignatoriesPage goToSignatories() {
        SignatoriesButton.click();
        return new SignatoriesPage(driver);
    }


}
