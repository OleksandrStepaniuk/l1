import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by admin_alex
 * Guide for start test: Carpspot folder => find testng.xml file => click right and run => good luck
 */

public class LoginTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//lib/chromedriver.exe");
        //System.setProperty("webdriver.firefox.driver", "//lib/geckodriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void first() {

        LoginMethods login = new LoginMethods(driver);
        LoginVar var = new LoginVar();
        driver.get("http://carpspot.ua/");
        login.pressButton(LoginVar.VOITI);

        Assert.assertTrue(login.findElement(var.MAIL).isDisplayed(),
                "Error, email not displayed");
        Assert.assertTrue(login.findElement(var.PASS).isDisplayed(),
                "Error, pass not displayed");
        Assert.assertTrue(login.findElement(var.VXOD).isDisplayed(),
                "Error, button not displayed");

        login.provideEmail("alexstepalina@gmail.com");
        login.providePass("Fkbyf1107");
        login.pressButton(LoginVar.VXOD);
        login.pressButton(LoginVar.USERDATA);
        // Assert.assertEquals("Учетная запись номер 902863", login.getTitle());
    }
}
