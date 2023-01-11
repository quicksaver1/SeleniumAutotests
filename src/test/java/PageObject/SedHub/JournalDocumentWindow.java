package PageObject.SedHub;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utils.PageObject;
import org.w3c.dom.html.HTMLInputElement;

public class JournalDocumentWindow extends PageObject {
    private final WebDriver driver;
    @FindBy(xpath = "//div[@data-elem-id='Element#10']//input[@type='file']")
    private WebElement FileInput;
    @FindBy(xpath ="//div[@data-elem-id='Element#3']//input")
    private static WebElement DateInput;
    @FindBy(xpath ="//div[@data-elem-id='Element#1']//i")
    private WebElement fileTypeCaret;
    @FindBy(xpath ="//div[@data-id='112062']//button[@title='Сохранить']")
    private WebElement SaveButton;
    @FindBy(xpath = "//div[@data-elem-id='Element#2']//textarea")
    private WebElement DescriptionInput;
    @FindBy(xpath = "//button[@data-cms-id = '115457']")
    private WebElement EditSaveButton;

    public JournalDocumentWindow (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void SetDate(String currentDateString) {
        DateInput.sendKeys(currentDateString);
    }
    public void clickUploadFile(String file) {
        FileInput.sendKeys(file);
    }

    public void SetType(String fileType) {
        fileTypeCaret.click();
        driver.findElement(new By.ByXPath("//div[@class='infinite-list']//span[text()='"+fileType+"']")).click();
    }

    public void clickSaveButton() {
        SaveButton.click();
    }

    public void clickEditSaveButton() {
        EditSaveButton.click();
    }
    public void setDescription(String description) {
        DescriptionInput.sendKeys(description);
    }
}
