package Utils;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageObject {
    public void waitToAppear(WebElement element , WebDriver driver){
        int attempts =0;
        while(attempts < 1000) {
            try {
                new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element));
                break;
            } catch (StaleElementReferenceException ignored) {
            }
            attempts++;
        }
        if(attempts == 100){
            throw new RuntimeException("waitToAppear exceeded attempts threshold");
        }
    }
}
