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
import org.w3c.dom.html.HTMLInputElement;

public class DocumentTypesPage extends PageObject {
    private WebDriver driver;
    public Header header;

    @FindBy(xpath = "//div[@data-id='111752']")
    WebElement DocumentTypesTable;

    @FindBy(xpath ="//div[@data-id='111753']")
    WebElement ButtonPanel;

    @FindBy(xpath = "//div[contains(@class,'routerLink') and text()='Справочники']")
    WebElement DirectoriesBreadCrumb;
    @FindBy(xpath ="//div[@data-elem-id='Element#1']//input")
    private WebElement NameField;
    @FindBy(xpath = "//div[@data-cms-id ='111751']//button[@title='Найти']")
    private WebElement SearchButton;

    @FindBy(xpath ="//div[@data-cms-id ='111751']//button[@title='Очистить форму']")
    private WebElement ClearTextButton;
    @FindBy(xpath = "//div[@data-id ='111753']//button[@title ='Добавить позицию справочника']")
    private WebElement AddButton;

    @FindBy(xpath = "//button/span[text()='Нет']")
    private WebElement NoButton;

    public DocumentTypesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        header = new Header(driver);
    }

    public void checkContents() {
        Assert.assertTrue(DocumentTypesTable.isEnabled());
        Assert.assertTrue(ButtonPanel.isEnabled());
    }

    public DirectoriesPage clickDirectoriesBreadCrumb() {
        DirectoriesBreadCrumb.click();
        return new DirectoriesPage(driver);
    }

    public void inputName(String name){
        NameField.sendKeys(name);
    }
    public void clickSearch() {
        SearchButton.click();
    }

    public void clickClearText() {
        ClearTextButton.click();
    }

    public void clickAdd() {
        AddButton.click();
    }

    public void clickNo() {
        NoButton.click();
    }

    public void inputNewCell(String name) {
        Actions actions = new Actions(driver);
        actions.doubleClick(driver.findElement(By.xpath("//div[contains(@class,'vue_table__element-focus-true')]/div[@data-nc = 'name']"))).perform();
        driver.findElement(By.xpath("//div[contains(@class,'vue_table__tr')]//input")).sendKeys(name);
    }
}
