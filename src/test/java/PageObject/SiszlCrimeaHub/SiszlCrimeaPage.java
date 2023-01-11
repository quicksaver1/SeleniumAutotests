package PageObject.SiszlCrimeaHub;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utils.PageObject;
public class SiszlCrimeaPage extends PageObject {
    private WebDriver driver;

    @FindBy(xpath = "//p[@title = 'Информационная система ТФОМС Республики Крым']")
    private WebElement SiszlCrimeaTitle;
    @FindBy(xpath = "//div[@class='ref_button']//*[contains(text(),'Учет документов ЗЛ')]")
    private WebElement AccountingButton;
    public SiszlCrimeaPage(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
    }
    public AccountingPage goToAccounting() {
        AccountingButton.click();
        return new AccountingPage(driver);
    }

}
