import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by oleksandr on 12.03.2017.
 */
public class ProductTest {
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
    public void second() throws InterruptedException {
        ProductMethods product = new ProductMethods(driver);
        ProductVar var = new ProductVar();
        product.pressButton(ProductVar.SNASTI);
        product.pressButton(ProductVar.RAKETACHAPTER);
        product.pressButton(ProductVar.RAKETAPRODUCT);
        product.pressButton(ProductVar.MIDIRAKETAADDTOBASKET);
        product.pressButton(ProductVar.OPENBASKET);
        Thread.sleep(2000);
        Assert.assertTrue(product.findElement(ProductVar.BASKETMIDI).isDisplayed(),
                "Product add to basket sucsess");
    }
}
