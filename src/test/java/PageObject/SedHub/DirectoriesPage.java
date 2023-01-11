package PageObject.SedHub;

import PageObject.Header;
import PageObject.SedHub.DirectoriesHub.DocumentTypesPage;
import PageObject.SedHub.DirectoriesHub.ProcessingPage;
import PageObject.SedHub.DirectoriesHub.StatusesPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utils.PageObject;

public class DirectoriesPage extends PageObject {

    private WebDriver driver;
    public Header header;

    @FindBy(xpath ="//div[@data-cms-id = '111655']")
    WebElement TypesButton;
    @FindBy(xpath = "//div[@data-cms-id = '111656']")
    WebElement StatusesButton;
    @FindBy(xpath = "//div[@data-cms-id = '111657']")
    WebElement ProcessingButton;
    @FindBy(xpath = "//div[@data-cms-id = '111626']")
    WebElement AnalyticsButton;
    @FindBy(xpath = "//div[@class='imc_copyright']")
    WebElement Copyright;



    public DirectoriesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        header = new Header(driver);
    }

    public void checkContents() {
        Assert.assertTrue(TypesButton.isEnabled());
        Assert.assertTrue(StatusesButton.isEnabled());
        Assert.assertTrue(ProcessingButton.isEnabled());
        Assert.assertTrue(Copyright.isEnabled());

    }

    public DocumentTypesPage clickTypes() {
        TypesButton.click();
        return new DocumentTypesPage(driver);
    }

    public StatusesPage clickStatuses() {
        StatusesButton.click();
        return new StatusesPage(driver);
    }
    public ProcessingPage clickProcessingButton(){
        ProcessingButton.click();
        return new ProcessingPage(driver);
    }

    public AnalyticsPage clickAnalytics() {
        AnalyticsButton.click();
        return new AnalyticsPage(driver);
    }
}
