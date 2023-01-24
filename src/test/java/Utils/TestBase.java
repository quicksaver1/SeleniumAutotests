package Utils;

import PageObject.HubPage;
import PageObject.LoginPage;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TestBase {
    public ChromeDriver driver;
    public static final String MAIN_URL="http://riisz.ru";
    public static final String USERNAME ="frolov";
    public static final String PASSWORD = "1";
    String driverPath;
    String binaryPath;

    public static final int TIMEOUT_IN_SECONDS = 10;
    public HubPage hubPage;


    public void getDriverAndLogin () {
        ChromeOptions chromeOptions = new ChromeOptions();

        String os = System.getProperty("os.name").toLowerCase();
        driverPath = "driver/win/yandexdriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        if(os.contains("nux")){
            chromeOptions.setBinary("driver/unix/yandexdriver");
            driver = new ChromeDriver(chromeOptions);
        } else if (os.contains("windows")) {
            driver = new ChromeDriver();
        }
        else {
            throw new RuntimeException("unrecognized Os - " + os);
        }
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
