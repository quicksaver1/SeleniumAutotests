package PageObject.SedHub;

import AnalyticsHub.MonitoringPage;
import AnalyticsHub.ReportPage;
import PageObject.Header;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utils.PageObject;

public class AnalyticsPage extends PageObject {
    WebDriver driver;

    public Header header;

    @FindBy(xpath = "//div[@data-cms-id='111772']")
    WebElement MonitoringButton;
    @FindBy(xpath = "//div[@data-cms-id='112277']")
    WebElement ReportButton;
    @FindBy(xpath = "//div[@class='imc_copyright']")
    WebElement Copyright;
    public AnalyticsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        header = new Header(driver);
    }

    public void checkContents() {
        Assert.assertTrue(MonitoringButton.isEnabled());
        Assert.assertTrue(ReportButton.isEnabled());
        Assert.assertTrue(Copyright.isEnabled());
    }

    public MonitoringPage clickMonitoring() {
        MonitoringButton.click();
        return new MonitoringPage(driver);
    }

    public ReportPage clickReportButton(){
        ReportButton.click();
        return new ReportPage(driver);
    }
}
