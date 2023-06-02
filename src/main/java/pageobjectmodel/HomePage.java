package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class HomePage {
    private final WebDriver driver;
    private static final By BUTTON_LOGIN_IN_PROFILE = By.xpath("//*[@title='Войти в профиль']");
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickButtonLoginInProfile(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(BUTTON_LOGIN_IN_PROFILE));
        driver.findElement(BUTTON_LOGIN_IN_PROFILE).click();
    }
}
