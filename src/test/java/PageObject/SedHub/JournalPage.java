package PageObject.SedHub;

import PageObject.FilterGroup;
import PageObject.Header;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utils.PageObject;

import java.time.Duration;
import java.util.List;

public class JournalPage extends PageObject {


    private  WebDriver driver;
    public FilterGroup filterGroup;
    public JournalDocumentWindow documentWindow;

    public Header header;

    @FindBy(xpath = "//div[@data-bread-crumb-id='111625']")
    WebElement BreadCrumbJournal;

    @FindBy(xpath = "//div[@class='systemNameBlock']/p[@class = 'systemName text-line-2']")
    WebElement Title;
    @FindBy(xpath = "//div[@class='systemNameBlock']/p[contains(@class, 'systemNameFooter')]")
    WebElement TitleFooter;
    @FindBy(xpath = "//div[@data-cms-id ='111632']")
    WebElement DocumentsTable;
    @FindBy(xpath = "//div[@class='vue_table vue_table_border_add']/../div[@class='vue__table__block-name' and text()='Хронология']")
    WebElement ChronologyTable;
    @FindBy(xpath = "//div[@cmsid= '111629']")
    WebElement ButtonsPanel;

    @FindBy(xpath = "//div[@class='container-row']//div[@data-nc = 'ed_type_name']")
    private WebElement FirstTableElement;

    @FindBy(xpath = "//button[@title='Найти']")
    private WebElement SearchButton;

    @FindBy(xpath = "//div[@cmsid = '116092']//*[@data-icon='file-signature']")
    private WebElement DownloadListButton;

    @FindBy(xpath = "//button[@data-cms-id='121285']")
    private WebElement DownloadPdfButton;

    @FindBy(xpath = "//div[@data-cms-id='111629']//button[@data-cms-id = '112090']")
    private WebElement UnloadButton;

    @FindBy(xpath = "//button[@title = 'Подсчитать количество записей']")
    private WebElement CalcButton;
    @FindBy(xpath = "//img[@src = 'http://riisz.ru/platform/assets/trash_red.png']")
    private WebElement TrashBin;
    @FindBy(xpath = "//span[text() = 'Да']")
    private WebElement YesButton;

    @FindBy(xpath = "//div[contains(@class,'vue_table__body')]//span[@class = 'el-checkbox__inner']")
    private  List<WebElement> Checkboxes;

    @FindBy(xpath = "//img[@src='http://riisz.ru/platform/assets/semd_sign.png']")
    private WebElement SignDocumentButton;

    @FindBy(xpath = "//button[@data-cms-id='112168']")
    private WebElement AcceptDocumentButton;

    @FindBy(xpath = "//div[@data-nc = 'filename']//span[@class = 'vue_td-w-100']")
    List<WebElement> FileNames;
    @FindBy(xpath ="//button[@title = 'Зарегистрировать новый документ']")
    private WebElement RegistrationButton;

    @FindBy(xpath = "//img[@src = 'http://riisz.ru/platform/assets/semd_edit.png']")
    private WebElement EditDocumentButton;

    @FindBy(xpath = "//div[contains(@class,'vue_table__header')]//div[@data-nc = 'filename']")
    WebElement FileNameHeader;

    @FindBy(xpath = "//button[@data-cms-id='112368']")
    WebElement DownloadFileButton;
    @FindBy(xpath = "//button[@title = 'Очистить форму']")
    private WebElement BackspaceButton;
    @FindBy(xpath = "//button[@data-cms-id='112169']")
    private WebElement SendForCheckButton;

    @FindBy(xpath ="//button[@data-cms-id='112097']")
    private WebElement SaveDocumentButton;
    @FindBy(xpath ="//button[@data-cms-id='112167']")
    private WebElement RejectDocumentButton;
    @FindBy(xpath ="//button[@data-cms-id ='111645']")
    private WebElement RequestClarificationButton;
    @FindBy(xpath ="//button[@data-cms-id ='112273']")
    private WebElement ApproveDocumentButton;
    @FindBy(xpath ="//button[@data-cms-id ='112275']")
    private WebElement RejectDocumentAfterSigning;
    @FindBy(xpath ="//button[@data-cms-id ='112408']")
    private WebElement SignDocumentByHeadButton;
    @FindBy(xpath ="//button[@title ='Подписать']")
    private WebElement AcceptButton;


    public JournalPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        header = new Header(driver);
        filterGroup = new FilterGroup(driver);
        //header.checkContents();//заголовок, который содержит пиктограмму подсистемы //маил информер //имя пользователя //кнопка log out //кнопка меню Избранное
        //checkSpecificContent(); //хлебную крошку, наименование
        filterGroup.checkClearFilters(); //фильтр группа
    }



    public  void deleteElement() {
        TrashBin.click();
        YesButton.click();
    }


    public void checkSpecificContent() {
        Assert.assertTrue(BreadCrumbJournal.isEnabled());//хлебная крошка
        Assert.assertTrue(Title.isEnabled());
        Assert.assertTrue(TitleFooter.isEnabled());//наименование
        Assert.assertTrue(DocumentsTable.isEnabled());//Таблица Документы //TODO (с данными)
        Assert.assertTrue(ChronologyTable.isEnabled());//Таблица Хронология //
        checkChronologyTableHasData(); // (с данными)
        Assert.assertTrue(ButtonsPanel.isEnabled());//панель с кнопками//
    }


    public void clickFirstTableElement() {
        FirstTableElement.click();
    }

    public void clickSearch() {
        SearchButton.click();
    }

    public void checkTableFileNameForDocAndDocx() {
        waitToAppear(FileNames.get(0),driver);
        for (WebElement fileName:FileNames) {
            String text = fileName.getText();
            System.out.println(text);
            //Assert.assertTrue(text.endsWith(".doc") || text.endsWith(".docx"));
        }
    }

    public void clickDownloadList() {
        DownloadListButton.click();
    }

    public void clickDownloadPdf() {
        //button[@title='Отрыть документ в виде pdf со встроенными штампиками о наличии подписей']
        DownloadPdfButton.click();
    }

    public void clickUnloadButton() {
        UnloadButton.click();
    }

    public void clickCalcButton() {
        CalcButton.click();
    }

    public void SelectTableElementCheckBoxes(int amount) {
        int i = 0;
            for(WebElement checkBox:Checkboxes){
                waitToAppear(checkBox,driver);
                checkBox.click();
                if(i==amount){
                    break;
                }
                i++;
            }
    }

    public void signDocument() {
        SignDocumentButton.click();
        AcceptButton.click();
    }

    public JournalDocumentWindow clickRegistrationDocument() {
        RegistrationButton.click();
        return new JournalDocumentWindow(driver);
    }


    public void clickEditDocument() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(EditDocumentButton));
        EditDocumentButton.click();
    }

    public void clickSignDocument() {
        SignDocumentButton.click();
    }

    public void clickYesButton() {
        YesButton.click();
    }

    public void checkEveryStatusIsSigned() {
        /*int attempts =0;
        while(attempts<100) {
            try {
                List<WebElement> statuses = driver.findElements(new By.ByXPath("//div[@class = 'container-row']//div[@data-nc = 'cur_status_name']"));
                for (WebElement status : statuses) {
                    Assert.assertEquals("Подписан ЛПУ", status.getText());
                }
            } catch (StaleElementReferenceException ignored) {
                attempts++;
            }
        }
        if (attempts==100) {
            throw new RuntimeException("checkEveryStatusIsSigned() atempt is exceeded");
        }*/
    }

    public void checkChronologyTableHasData() {
        List<WebElement> statuses = driver.findElements(new By.ByXPath("//div[@data-nc = 'ed_status_name_']"));
        Assert.assertTrue(statuses.size()>1);
    }
    public void selectFirstTableElement(){

    }

    public void scrollAndClickFileDownload() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", FileNameHeader);
        DownloadFileButton.click();
    }

    public void clickBackspaceButton() {
        BackspaceButton.click();
    }

    public void AcceptDocument() {
        AcceptDocumentButton.click();
        SaveDocumentButton.click();
    }

    public void sendForCheck() {
        SendForCheckButton.click();
        SaveDocumentButton.click();
    }

    public void rejectDocument() {
        RejectDocumentButton.click();
        SaveDocumentButton.click();
    }

    public void requestClarification() {
        RequestClarificationButton.click();
        SaveDocumentButton.click();
    }

    public void approveDocument() {
        ApproveDocumentButton.click();
        SaveDocumentButton.click();
    }

    public void rejectDocumentAfterSigning() {
        RejectDocumentAfterSigning.click();
        new WebDriverWait(driver,Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(SaveDocumentButton));
        SaveDocumentButton.click();
    }

    public void signDocumentByHead() {
        SignDocumentByHeadButton.click();
        AcceptButton.click();
    }
}
