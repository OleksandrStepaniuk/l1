import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by oleksandr on 12.03.2017.
 */
public class ProductMethods {
    private WebDriver driver;

    public ProductMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void pressButton(String locator) {
        WebElement buttonClick = driver.findElement(By.xpath(locator));
        buttonClick.click();    //
    }
}
