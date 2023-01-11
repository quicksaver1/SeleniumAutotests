package PageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utils.PageObject;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class LoginPage extends PageObject {

    private WebDriver driver;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;
    @FindBy(xpath = "//input[@type='text']")
    private WebElement loginInput;
    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//img[@data-name = 'FavoritesBar']")
    private WebElement favoritesBar;
    @FindBy(xpath = "//p[text()='Сбросить параметры']")
    private WebElement resetParametersButton;
    @FindBy(xpath = "//p[text()='Сбросить кэш бэка']")
    private WebElement resetBackCacheButton;
    @FindBy(xpath = "//button/span[text()='Да']")
    private WebElement yesButton;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public HubPage loginAs(String username, String password) {
        loginInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
        resetCache();
        return new HubPage(driver);
    }

    public void resetCache(){
        favoritesBar.click();
        resetParametersButton.click();
        clickYesButton();
        waitToAppear(favoritesBar,driver);
        favoritesBar.click();
        waitFavoritesBarToShow();
        resetBackCacheButton.click();
        clickYesButton();
    }

    private void clickYesButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(yesButton));
        yesButton.click();
    }

    private void waitFavoritesBarToShow(){
        int attempts = 0;
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(favoritesBar));
        favoritesBar.click();
        /*while(attempts <10) {
            try {
                favoritesBar.click();
                break;
            }
            catch (StaleElementReferenceException ignored) {
            }
            attempts++;
        }
        if(attempts == 10){
            throw new RuntimeException("clickFavoritesBarUntilShow exceeded attempts threshold");
        }*/
    }

}
