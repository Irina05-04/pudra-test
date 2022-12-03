package by.bsu.fsc.Derecha;

import by.bsu.fsc.Derecha.domain.SearchData;
import by.bsu.fsc.Derecha.domain.User;
import by.bsu.fsc.Derecha.pages.BasePage;
import by.bsu.fsc.Derecha.pages.PudraPage;
import by.bsu.fsc.Derecha.steps.PudraStep;
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
    PudraStep step;

    @Before
    public void beforeMethod(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        page = new PudraPage(driver);
        step = new PudraStep(driver);
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
        page.fillSearchInputAndSend(SearchData.SEARCH_PRODUCT);
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
        step.checkEmptyFields();
        String actual = page.findErrorEmailRequire();
        String actualPsw = page.findErrorPasswordRequire();

        // TODO THEN
        Assert.assertEquals(page.RESULT_ERROR_MAIL_REQUIRE, actual);
        Assert.assertEquals(page.RESULT_ERROR_PSW_REQUIRE, actualPsw);
    }
    @Test
    public void EncorrectValue() {
        String login = User.generateEncorrectLogin();
        String psw = User.generateEncorrectPsw();

        // TODO WHEN
        step.SubmitDate(login, psw);
        String actual = page.findErrorMessageEncorrectDate();


        // TODO THEN
        Assert.assertEquals(page.RESULT_ENCORRECT_DATE, actual);
    }
    @Test
    public void CorrectValue() {

        // TODO WHEN
        step.SubmitDate(User.CORRECT_LOGIN , User.CORRECT_PSW);
        page.clickProfileBtn();
        String actual = page.findMyProfile();

        // TODO THEN
        Assert.assertEquals(User.CORRECT_RESULTS, actual);
    }
}
