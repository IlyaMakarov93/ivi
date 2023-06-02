package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    private final WebDriver driver;
    private static final By BUTTON_LOGIN_OR_REGISTRATION = By.xpath("//*[text()='Войти или зарегистрироваться']");
    private static final By INPUT_EMAIL_OR_PHONE = By.xpath("//*[@data-test='input_login']");
    private static final By BUTTON_CONTINUE = By.xpath("//*[@data-test='button_continue']");
    private static final By INPUT_PASSWORD = By.xpath("//*[@data-test='input_password']");
    private static final By EMAIL_PROFILE = By.xpath("//*[@class='profileUserInfo__infoText']");
    private static final By BUTTON_LOGOUT = By.xpath("//*[text()='Выйти']");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButtonLoginOrRegistration() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(BUTTON_LOGIN_OR_REGISTRATION));
        driver.findElement(BUTTON_LOGIN_OR_REGISTRATION).click();
    }

    public void fillingInputEmailOrPhone(String emailOrPhone) throws InterruptedException {
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(INPUT_EMAIL_OR_PHONE));
        driver.findElement(INPUT_EMAIL_OR_PHONE).sendKeys(emailOrPhone);
    }

    public void clickButtonContinue() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(BUTTON_CONTINUE));
        driver.findElement(BUTTON_CONTINUE).click();
    }

    public void fillingInputsProfileForLogin(String emailOrPhone, String password) throws InterruptedException {
        fillingInputEmailOrPhone(emailOrPhone);
        clickButtonContinue();
        fillingInputPassword(password);
        clickButtonContinue();
    }

    public void fillingInputPassword(String password) throws InterruptedException {
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(INPUT_PASSWORD));
        driver.findElement(INPUT_PASSWORD).sendKeys(password);
    }

    public String getTextEmailProfile() throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(EMAIL_PROFILE));
        return driver.findElement(EMAIL_PROFILE).getText();
    }

    public void logoutProfile() {
        WebElement element = driver.findElement(BUTTON_LOGOUT);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(BUTTON_LOGOUT));
        driver.findElement(BUTTON_LOGOUT).click();
    }
}
