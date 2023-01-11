package AnalyticsHub;

import PageObject.Header;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportPage {
    WebDriver driver;
    @FindBy(xpath = "//div[@class='modal__container']/div[@class='modal__header']//span[text() = 'Отчет в разрезе организаций и документов']")
    WebElement ReportWindow;
    @FindBy(xpath = "//img[@src='http://riisz.ru/platform/assets/accept_search.png']")
    WebElement AcceptButton;
    @FindBy(xpath = "//img[@src='http://riisz.ru/platform/assets/Cancel1.png']")
    WebElement CancelButton;

    @FindBy(xpath ="//span[text()= 'Наименование организации']/../../..//i")
    WebElement NameActionMenu;

    @FindBy(xpath ="//span[text() = 'Дата по']/../../..//input")
    WebElement DateMax;
    public ReportPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void checkContents(){
        Assert.assertTrue(ReportWindow.isEnabled());
        Assert.assertTrue(AcceptButton.isEnabled());
        Assert.assertTrue(CancelButton.isEnabled());
    }

    public void chooseFromList(String name) {
        clickNameActionMenu();
        driver.findElement(new By.ByXPath("//li[*]/span[text() = '"+name+"']")).click();
        ReportWindow.click();
    }
    public void clickNameActionMenu() {
        NameActionMenu.click();
    }
    public void setDateMax(String date){
        DateMax.sendKeys(date);
    }
    public void clickAcceptButton() {
        AcceptButton.click();
    }
}
