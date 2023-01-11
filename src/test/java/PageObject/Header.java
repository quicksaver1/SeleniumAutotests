package PageObject;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utils.PageObject;

import static Utils.TestBase.MAIN_URL;

public class Header extends PageObject {
    private WebDriver driver;
    @FindBy(xpath = "//img[@id = 'logo_href']")
    WebElement Pictogram;
    @FindBy(xpath = "//div[contains(@class,'messageInformData')]")
    WebElement MailInformer;
    @FindBy(xpath = "//div[contains(@class, 'container_header')]//p[@class='fio']")
    WebElement Fio;
    @FindBy(xpath = "//div[contains(@class, 'container_header')]//a[@id='userLogout']")
    WebElement LogoutButton;
    @FindBy(xpath = "//img[@data-name = 'FavoritesBar']")
    WebElement favoritesBar;
    @FindBy(xpath ="//div[@class ='routerLink' and text() = 'Главная']")
    WebElement BreadCrumb;

    public Header(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void checkContents() {
        Assert.assertTrue(Pictogram.isEnabled());//заголовок, который содержит пиктограмму подсистемы//
        Assert.assertTrue(MailInformer.isEnabled());//маил информер
        Assert.assertTrue(Fio.isEnabled());//имя пользователя
        Assert.assertTrue(LogoutButton.isEnabled());//кнопка log out
        Assert.assertTrue(favoritesBar.isEnabled());//кнопка меню Избранное
        //Assert.assertTrue(BreadCrumb.isEnabled());//Хлебная крошка "Главная"
    }
    public void clickPictogram(){
        Pictogram.click();
    }
    public void clickBreadCrumb() {
        BreadCrumb.click();
    }
}
