package PageObject.SiszlCrimeaHub;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utils.PageObject;
import java.util.ArrayList;
import java.util.List;

public class AccountingPage extends PageObject {
    private WebDriver driver;

    //------------TABLE-------------
    @FindBy(xpath = "//div[@id = '117040']//div[contains(@class, 'vue_table__tr')]")
    private List<WebElement> TableElements;

    //------------FILTER------------
    @FindBy(xpath = "//*[name()='svg' and @data-icon = 'filter']")
    private WebElement FilterButton;

    @FindBy(xpath = "//input[@id='input121064__Constructor_component17']")
    private WebElement SurnameInput;

    @FindBy(xpath = "//input[@id='input121064__Constructor_component18']")
    private WebElement NameInput;
    @FindBy(xpath = "//input[@id ='input121064__Constructor_component19']")
    private WebElement SecondNameInput;

    @FindBy(xpath = "//*[@src = \"http://riisz.ru/platform/assets/buttons/header_search.png\"]")
    private WebElement SearchButton;
    public AccountingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void inputFilterData(String name, String surname, String secondName) {
        FilterButton.click();
        SurnameInput.sendKeys(surname);
        NameInput.sendKeys(name);
        SecondNameInput.sendKeys(secondName);
        SearchButton.click();;
    }
    public List<List<String>> getFullNames() {
        //WebElement Table = driver.findElement(new By.ByXPath("//div[@id = '117040']"));
        //new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.not(ExpectedConditions.stalenessOf(TableElements.get(0))));
        List<List<String>> TableFullNameStrings = new ArrayList<List<String>>();
        List<WebElement> Table = TableElements;
        for(int x=0; x<TableElements.size(); x++)
        {
            List<String> TableFullNameString = new ArrayList<String>();
            TableFullNameString.add(driver.findElement(new By.ByXPath("//div[@id = '117040']//div[@tabindex = \""+x+ "\"]//div[@data-nc = 'surname_']")).getText());
            TableFullNameString.add(driver.findElement(new By.ByXPath("//div[@id = '117040']//div[@tabindex = \""+x+ "\"]//div[@data-nc = 'name_']")).getText());
            TableFullNameString.add(driver.findElement(new By.ByXPath("//div[@id = '117040']//div[@tabindex = \""+x+ "\"]//div[@data-nc = 'secname_']")).getText());
            TableFullNameStrings.add(TableFullNameString);
            System.out.println(TableFullNameString.get(0)+" "+TableFullNameString.get(1) + " "+ TableFullNameString.get(2));//DEBUG
        }
        return TableFullNameStrings;
    }



}
