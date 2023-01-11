package PageObject.SedHub.DirectoriesHub;

import PageObject.Header;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utils.PageObject;
import org.w3c.dom.html.HTMLInputElement;

public class ProcessingPage extends PageObject {

    private WebDriver driver;
    public Header header;

    @FindBy(xpath = "//div[@data-cms-id='111788']")
    WebElement DocumentTypesTable;

    @FindBy(xpath ="//div[@data-id='111789']")
    WebElement ButtonPanel;
    @FindBy(xpath = "//div[@data-elem-id = 'Element#1']//input")
    private WebElement AdTypeInput;

    @FindBy(xpath = "//div[@data-elem-id = 'Element#1']//i[contains(@class,'caret')]")
    private WebElement AdTypeSelectCaret;

    @FindBy(xpath = "//div[@data-cms-id = '111788']//div[contains(@class,'vue_table__header')]//div[@data-nc ='npp']")
    private WebElement NppColumn;

    @FindBy(xpath = "//div[@data-cms-id ='111787']//button[@title='Очистить форму']")
    private WebElement ClearText;
    @FindBy(xpath = "//div[@data-cms-id ='111787']//button[@title='Найти']")
    private WebElement SearchButton;

    @FindBy(xpath = "//div[@data-id ='111789']//button[@title='Добавить позицию справочника']")
    private WebElement AddButton;
    @FindBy(xpath = "//span[contains(text(), 'Нет')]")
    private WebElement NoButton;

    public ProcessingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        header = new Header(driver);
    }

    public void checkContents() {
        Assert.assertTrue(DocumentTypesTable.isEnabled());
        Assert.assertTrue(ButtonPanel.isEnabled());
    }

    public void inputAdType(String searchString, String fullString) {
        AdTypeInput.sendKeys(searchString);
        AdTypeSelectCaret.click();
        driver.findElement(new By.ByXPath("//div[@class = 'infinite-list']//*[text()='"+fullString+"']")).click();
        AdTypeSelectCaret.click();
    }

    public void clickNppColumn() {
        NppColumn.click();
    }

    public void clickClearText() {
        ClearText.click();
    }


    public void clickSearch() {
        SearchButton.click();
    }

    public void clickAdd() {
        AddButton.click();
    }

    public void clickNo() {
        NoButton.click();
    }
}
