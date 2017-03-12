import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by oleksandr on 04.03.2017.
 */
public class LoginMethods {
    private WebDriver driver;

    public LoginMethods(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement findElement(String s) {
        return driver.findElement(By.xpath(s));
    }
    /* public WebElement getTitle(String s){
        return driver.getTitle(s);
    } */    //getTitle assert, need do!

    public void provideEmail(String data) {
        WebElement emailField = driver.findElement(By.xpath(LoginVar.MAIL));
        emailField.sendKeys(data);
    }

    public void providePass(String data) {
        WebElement passwordField = driver.findElement(By.xpath(LoginVar.PASS));
        passwordField.sendKeys(data);
    }

    public void pressButton(String locator) {
        WebElement buttonClick = driver.findElement(By.xpath(locator));
        buttonClick.click();
    }


}
