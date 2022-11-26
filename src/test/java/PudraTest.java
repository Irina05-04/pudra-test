import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PudraTest {

    WebDriver driver;
    PudraPage page;

    @Before
    public void beforeMethod(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        page = new PudraPage(driver);
        driver.get(page.URL);
    }

    @After
    public void afterMethod(){
        driver.quit();
    }

    @Test
    public void searchProduct() {

        // TODO WHEN
        page.fillSearchInputAndSend("крем для рук");
        String actual = page.getResults();


        // TODO THEN
        Assert.assertEquals(page.RESULT_SEARCH_TEXT, actual);
    }
    @Test
    public void checkProduct() {

        // TODO WHEN
        page.fillSearchInputAndSend("крем для рук");
        String actual = page.checkProductCode();

        // TODO THEN
        Assert.assertEquals(page.RESULT_PRODUCT_CODE, actual);
    }


}
