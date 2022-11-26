import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PudraTest {

    WebDriver driver;

    @Test
    public void openPage() {
        // TODO GIVEN
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String url = "https://pudra.by/";
        String xpath = "//div[@class='navbar-free-shipping-title']";
        String expected = "Стань постоянным клиентом и получай кешбэк от покупок до 30%";

        // TODO WHEN
        driver.get(url);
        By byXpath = By.xpath(xpath);
        WebElement element = driver.findElement(byXpath);
        Util.waiter();
        String actual = element.getText();

        // TODO THEN
        Assert.assertEquals(expected, actual);
        driver.quit();
    }
}
