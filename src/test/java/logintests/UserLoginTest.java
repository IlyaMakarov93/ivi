package logintests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import pageobjectmodel.HomePage;
import pageobjectmodel.ProfilePage;

@RunWith(Parameterized.class)
public class UserLoginTest {
    protected static final String URL = "https://www.ivi.tv/";
    private final String emailOrPhone;
    private final String password;
    private WebDriver driver;

    public UserLoginTest(String emailOrPhone, String password) {
        this.emailOrPhone = emailOrPhone;
        this.password = password;
    }

    @Parameterized.Parameters
    public static Object[][] parameters() {
        return new Object[][]{
                {"ipost.mim@gmail.com", "Makarov@93"}
        };
    }

    @Before
    public void setUp() {
        driver = new SafariDriver();
        driver.manage().window().maximize();
        driver.get(URL);
    }

    @Test
    public void loginTest() throws InterruptedException {
        HomePage homePageIVI = new HomePage(driver);
        homePageIVI.clickButtonLoginInProfile();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickButtonLoginOrRegistration();
        profilePage.fillingInputsProfileForLogin(emailOrPhone, password);
        String actual = profilePage.getTextEmailProfile();
        Assert.assertEquals(emailOrPhone, actual);
    }

    @After
    public void cleanUp() {
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.logoutProfile();
        driver.quit();
    }
}

