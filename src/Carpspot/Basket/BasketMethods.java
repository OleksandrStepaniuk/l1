import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by admin_alex on 3/13/2017.
 */
public class BasketMethods {
    private WebDriver driver;

    public BasketMethods(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findElement(String s) {
        return driver.findElement(By.xpath(s));
    }

    public void pressButton(String locator) {
        WebElement buttonClick = driver.findElement(By.xpath(locator));
        buttonClick.click();
    }
}
