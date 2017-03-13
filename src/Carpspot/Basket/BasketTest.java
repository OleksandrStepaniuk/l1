import org.openqa.selenium.By;
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
public class BasketTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//lib/chromedriver.exe");
        //System.setProperty("webdriver.firefox.driver", "//lib/geckodriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://carpspot.ua/shop/carp/user/login/");
        driver.findElement(By.xpath(LoginVar.MAIL)).sendKeys("alexstepalina@gmail.com");
        driver.findElement(By.xpath(LoginVar.PASS)).sendKeys("Fkbyf1107");
        driver.findElement(By.xpath(LoginVar.VXOD)).click();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void third() throws InterruptedException {
        BasketMethods basket = new BasketMethods(driver);
        BasketVar var = new BasketVar();
        basket.pressButton(BasketVar.OPENBASKET);
        basket.pressButton(BasketVar.OFORMIT);
        Thread.sleep(2000);
        Assert.assertTrue(basket.findElement(BasketVar.DOSTAVKAAND).isDisplayed(),
                "Информация о доставке и оплате");
        Thread.sleep(3000);
    }
}
