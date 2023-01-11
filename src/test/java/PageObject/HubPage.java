package PageObject;

import PageObject.SiszlCrimeaHub.SiszlCrimeaPage;
import Utils.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HubPage extends PageObject {
    private WebDriver driver;

    @FindBy(xpath = "//div[@data-cms-id='122787']")
    private WebElement siszlCrimeaButton;

    @FindBy(xpath ="//div[@data-cms-id='113921']")
    private  WebElement SEDButton;
    @FindBy(xpath ="//a[@id='userLogout']")
    private WebElement logoutButton;

    public HubPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SiszlCrimeaPage goToSiszlCrimea(){
        siszlCrimeaButton.click();
        return new SiszlCrimeaPage(driver);
    }

    public SedPage goToSED() {
        SEDButton.click();
        return new SedPage(driver);
    }


    public void clickLogout() {
        logoutButton.click();
    }
}
