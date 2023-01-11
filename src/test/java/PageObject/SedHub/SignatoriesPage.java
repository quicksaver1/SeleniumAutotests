package PageObject.SedHub;

import PageObject.Header;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utils.PageObject;
import java.util.zip.ZipEntry;

public class SignatoriesPage extends PageObject {

    public Header header;
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='vue__table__block-name' and text() = 'Таблица уполномоченных подписантов']/../div[contains(@class, 'vue_table')]")
    private WebElement SignatoriesTable;
    @FindBy(xpath ="//div[@cmsid='116004']")
    WebElement ButtonPanel;


    public SignatoriesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        header = new Header(driver);
    }

    public void checkContents() {
        Assert.assertTrue(SignatoriesTable.isEnabled());
        Assert.assertTrue(ButtonPanel.isEnabled());
    }
}
