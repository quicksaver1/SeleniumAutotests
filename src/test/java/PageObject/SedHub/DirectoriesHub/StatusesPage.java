package PageObject.SedHub.DirectoriesHub;

import PageObject.Header;
import PageObject.SedHub.DirectoriesPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utils.PageObject;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StatusesPage extends PageObject {
    private  WebDriver driver;

    public Header header;

    @FindBy(xpath = "//div[@data-cms-id ='111782']")
    WebElement DocumentTypesTable;

    @FindBy(xpath = "//div[@data-id='111783']")
    WebElement ButtonsPanel;

    @FindBy(xpath = "//div[contains(@class,'routerLink') and text()='Справочники']")
    WebElement DirectoriesBreadCrumb;

    @FindBy(xpath ="//div[@data-id='111782']//div[contains(@class, 'header')]//div[@data-nc = 'id']")
    WebElement StatusCodeColumnHeader;

    @FindBy(xpath = "//div[@data-id='111783']//button")
    WebElement SaveButton;

    @FindBy(xpath = "//div[@tabindex ='0']/div[@data-nc ='status_name']")
    WebElement TableElement;


    public StatusesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        header = new Header(driver);
    }

    public void checkContents() {
        Assert.assertTrue(DocumentTypesTable.isEnabled());
        Assert.assertTrue(ButtonsPanel.isEnabled());
    }

    public DirectoriesPage clickDirectoriesBreadCrumb(){
        DirectoriesBreadCrumb.click();
        return new DirectoriesPage(driver);
    }

    public void clickStatusCode() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(StatusCodeColumnHeader));
        StatusCodeColumnHeader.click();
    }

    public void clickSaveButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(SaveButton));
        SaveButton.click();
    }

    public void inputTableElement(String input) {
        Actions actions = new Actions(driver);
        actions.doubleClick(TableElement).perform();
        driver.findElement(By.xpath("//div[@tabindex ='0']//input")).sendKeys(input);
        driver.findElement(By.xpath("//div[@tabindex ='1']/div[@data-nc ='status_name']")).click();
    }
}
