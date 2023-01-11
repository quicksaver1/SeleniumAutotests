package PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utils.PageObject;

import java.awt.*;


public class FilterGroup extends PageObject {
    private WebDriver driver;

    @FindBy(xpath = "//div[@data-elem-id = 'Element#22']//input")
    private WebElement FileNameInput;
    @FindBy(xpath = "//div[@data-elem-id = 'Element#5']//i[contains(@class,'el-select__caret')]")
    private WebElement StatusSelectCaret;
    @FindBy(xpath = "//div[@data-elem-id = 'Element#20']//i[contains(@class,'el-select__caret')]")
    private WebElement RedactorTypeCaret;

    @FindBy(xpath = "//div[@data-elem-id = 'Element#3']//i[contains(@class,'el-select__caret')]")
    private WebElement SenderTypeCaret;
    @FindBy(xpath = "//div[@data-elem-id='Element#23']//*[contains(@class,'el-checkbox')]")
    private WebElement ReceiverCheckBox;
    @FindBy(xpath = "//div[@data-elem-id='Element#10']//span[@class='el-input__suffix']")
    private WebElement documentTypeSelectCaret;
    @FindBy(xpath ="//div[@data-elem-id='Element#10']//input")
    private WebElement DocumentTypeInput;
    @FindBy(xpath = "//div[@data-elem-id='Element#1']//i[contains(@class, 'el-select__caret')]")
    private WebElement SenderSelectCaret;
    @FindBy(xpath = "//div[@data-elem-id='Element#1']//input")
    private WebElement SenderInput;
    @FindBy(xpath = "//div[@data-elem-id='Element#3']//input")
    private WebElement SenderTypeInput;
    @FindBy(xpath ="//div[@data-elem-id='Element#14']//input")
    private WebElement ResponsiblePersonInput;
    @FindBy(xpath = "//div[@data-elem-id='Element#13']//input")
    private WebElement ReceiversInput;
    @FindBy(xpath = "//div[@data-elem-id='Element#16']//input")
    private WebElement ReceiverTypeInput;
    @FindBy(xpath = "//div[@data-elem-id='Element#5']//input")
    private WebElement DocumentStatusInput;
    @FindBy(xpath = "//div[@data-elem-id='Element#20']//input")
    private WebElement RedactorTypeInput;
    @FindBy(xpath = "//div[@data-elem-id='Element#15']//input")
    private WebElement DocumentNumberInput;
    @FindBy(xpath = "//div[@data-elem-id='Element#24']//input")
    private WebElement ReportingPeriodInput;
    @FindBy(xpath = "//div[@data-elem-id='Element#6']//input")
    private WebElement DocumentDateBeginInput;
    @FindBy(xpath = "//div[@data-elem-id='Element#7']//input")
    private WebElement DocumentDateEndInput;
    @FindBy(xpath = "//div[@data-elem-id='Element#8']//input")
    private WebElement DownloadDocumentBeginInput;
    @FindBy(xpath = "//div[@data-elem-id='Element#9']//input")
    private WebElement DownloadDocumentEndInput;
    @FindBy(xpath = "//div[@data-elem-id='Element#18']//input")
    private WebElement LastChangeBeginInput;
    @FindBy(xpath = "//div[@data-elem-id='Element#19']//input")
    private WebElement LastChangeEndInput;
    @FindBy(xpath ="//div[@data-elem-id='Element#21']//input")
    private WebElement DocumentIdInput;
    @FindBy(xpath ="//div[@data-elem-id='Element#10']//i" )
    private WebElement DocumentTypeCaret;


    public FilterGroup(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setFileName(String fileName){
        FileNameInput.sendKeys(fileName);
    }

    public void setStatus(String status) {
        StatusSelectCaret.click();
        driver.
                findElement(new By.ByXPath("//div[contains(@class, 'dropdown_list_111630_Element5 vue_field-dropdown_list')]//span[text() = '"+status+"']")).
                click();
    }

    public void chooseRedactorType(String RedType) {
        RedactorTypeCaret.click();
        driver.
                findElement(new By.ByXPath("//li/span[text()='"+RedType+"']")).click();
    }

    public void chooseSenderType(String SenderType) {
        SenderTypeCaret.click();
        driver.findElement(new By.ByXPath("//li/span[text()='"+SenderType+"']")).click();

    }

    public void checkReceiveBox() {
        ReceiverCheckBox.click();
    }

    public void SetDocumentType(String fullString) {
        documentTypeSelectCaret.click();
        driver.findElement(new By.ByXPath("//div[@class = 'infinite-list']//*[contains(text(),'"+fullString+"')]")).click();
    }
    public void SetDocumentType(String searchString, String fullString) {
        DocumentTypeCaret.click();
        DocumentTypeInput.sendKeys(searchString);
        SetDocumentType(fullString);
    }

    public void chooseSender(String fullString ){
        SenderSelectCaret.click();
        driver.findElement(new By.ByXPath("//div[@class = 'infinite-list']//*[contains(text(),'"+fullString+"')]")).click();
    }
    public void chooseSender(String searchString, String fullString ) {
        SenderInput.sendKeys(searchString);
        chooseSender(fullString);
    }

    public void checkClearFilters() {
        Assert.assertEquals("", SenderInput.getText());
        Assert.assertEquals("", SenderTypeInput.getText());
        Assert.assertEquals("", ResponsiblePersonInput.getText());
        Assert.assertEquals("", ReceiversInput.getText());
        Assert.assertEquals("", ReceiverTypeInput.getText());
        Assert.assertEquals("", DocumentTypeInput.getText());
        Assert.assertEquals("", DocumentStatusInput.getText());
        Assert.assertEquals("", RedactorTypeInput.getText());
        Assert.assertEquals("", DocumentNumberInput.getText());
        Assert.assertEquals("", ReportingPeriodInput.getText());
        Assert.assertEquals("", DocumentDateBeginInput.getText());
        Assert.assertEquals("", DocumentDateEndInput.getText());
        Assert.assertEquals("", DownloadDocumentBeginInput.getText());
        Assert.assertEquals("", DownloadDocumentEndInput.getText());
        Assert.assertEquals("", LastChangeBeginInput.getText());
        Assert.assertEquals("", LastChangeEndInput.getText());
        Assert.assertEquals("", DocumentIdInput.getText());
        Assert.assertEquals("", FileNameInput.getText());
    }
}
