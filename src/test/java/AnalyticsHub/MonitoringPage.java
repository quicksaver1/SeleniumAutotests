package AnalyticsHub;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MonitoringPage {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='modal__container']/div[@class='modal__header']//span[text() = 'Мониторинг выставления/подписания МО по типам документов']")
    WebElement MonitoringWindow;

    @FindBy(xpath = "//img[@src='http://riisz.ru/platform/assets/accept_search.png']")
    WebElement AcceptButton;

    @FindBy(xpath = "//img[@src='http://riisz.ru/platform/assets/Cancel1.png']")
    WebElement CancelButton;

    @FindBy(xpath = "//button[@title='Закрыть']")
    WebElement CloseButton;
    @FindBy(xpath ="//span[text() = 'Дата по']/../../..//input")
    WebElement DateMax;

    @FindBy(xpath ="//i[@class = 'el-select__caret el-input__icon el-icon-']")
    WebElement NameActionMenu;
    public MonitoringPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkContents() {
        Assert.assertTrue(MonitoringWindow.isEnabled());
        Assert.assertTrue(AcceptButton.isEnabled());
        Assert.assertTrue(CancelButton.isEnabled());
    }

    public void closeWindow() {
        CloseButton.click();
    }
    public void setDateMax(String date){
        DateMax.sendKeys(date);
    }


    public void clickNameActionMenu() {
        NameActionMenu.click();
    }

    public void chooseFromList(String name) {
        clickNameActionMenu();
        driver.findElement(new By.ByXPath("//li[*]/span[text() = '"+name+"']")).click();
        MonitoringWindow.click();
    }
    public void clickAcceptButton() {
        AcceptButton.click();
    }
    public void clickCancelButton() {
        CancelButton.click();
    }
}
