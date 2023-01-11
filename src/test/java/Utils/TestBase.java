package Utils;

import PageObject.HubPage;
import PageObject.LoginPage;
import org.junit.After;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestBase {
    public ChromeDriver driver;
    public static final String MAIN_URL="http://riisz.ru";
    public static final String USERNAME ="frolov";
    public static final String PASSWORD = "1";

    public static final int TIMEOUT_IN_SECONDS = 10;
    public HubPage hubPage;


    public void getDriverAndLogin () {
        System.setProperty("webdriver.chrome.driver", "driver/yandexdriver.exe");
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT_IN_SECONDS));
        driver.get(MAIN_URL);
        LoginPage loginPage=new LoginPage(driver);
        hubPage = loginPage.loginAs(USERNAME,PASSWORD);
    }
    @After
    public void logout () {
        driver.close();
        driver.quit();
    }
    protected String getCurrentDateString(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyy");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
}
