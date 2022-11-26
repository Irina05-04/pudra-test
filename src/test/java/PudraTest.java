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
    public void openPage() {

        // TODO WHEN
        String actual = page.getPage();


        // TODO THEN
        Assert.assertEquals(page.RESULT_PAGE, actual);
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
    @Test
    public void emptyFildsRegistr() {

        // TODO WHEN
        page.checkEmptyFields();
        String actual = page.findErrorEmailRequire();
        String actualPsw = page.findErrorPasswordRequire();

        // TODO THEN
        Assert.assertEquals(page.RESULT_ERROR_MAIL_REQUIRE, actual);
        Assert.assertEquals(page.RESULT_ERROR_PSW_REQUIRE, actualPsw);
    }
    @Test
    public void EncorrectValue() {

        // TODO WHEN
        page.SubmitDate("lala@gmail.com", "01234");
        String actual = page.findErrorMessageEncorrectDate();


        // TODO THEN
        Assert.assertEquals(page.RESULT_ENCORRECT_DATE, actual);
    }
    @Test
    public void CorrectValue() {

        // TODO WHEN
        page.SubmitDate(page.CORRECT_LOGIN , page.CORRECT_PSW);
        page.clickProfileBtn();
        String actual = page.findMyProfile();

        // TODO THEN
        Assert.assertEquals(page.CORRECT_RESULTS, actual);
    }
}
