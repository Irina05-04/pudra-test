import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PudraPage {

    WebDriver driver;
    public final String URL = "https://aloespace.by/";
    private String xpathSearchName = "//input[@id='search_input']";
    private String xpathButtonSearch = "//button[@class='ty-search-magnifier']";
    private String xpathResults = "//a[@class='product__title']";
    private String xpathProduct = "//form[@name='product_form_411']";
    private String xpathProductCode = "//span[@id='product_code_411']";

    private String xpathpRrofileBtn = "//div[@class='profile__btn ']";
    private String xpathEnterBtn = "//a[@data-ca-target-id='login_block917']";
    private String xpathSubmitForm = "//button[@name='dispatch[auth.login]']";
    private String xpathErrorMailRequire = "//span[@id='login_popup917_error_message']";
    private String xpathErrorPasswordRequire = "//span[@id='psw_popup917_error_message']";
    private String xpathLogin = "//input[@name='user_login']";
    private String xpathPsw = "//input[@name='password']";
    private String xpathEncorrectDate = "//div[@class='ty-login-form__wrong-credentials-container']";
    private String xpathMyProfile = "//li[@class='ty-account-info__item  ty-account-info__name ty-dropdown-box__item']";

    public final String RESULT_SEARCH_TEXT = "Крем для рук FarmStay с черным жемчугом Hand Cream Black Pearl - 100 гр";
    public final String RESULT_PRODUCT_CODE = "J0001S";

    public final String RESULT_ERROR_MAIL_REQUIRE = "Поле E-mail обязательное.";
    public final String RESULT_ERROR_PSW_REQUIRE = "Поле Пароль обязательное.";
    public final String RESULT_ENCORRECT_DATE = "Вы ввели неверный логин или пароль. Пожалуйста, попробуйте еще раз.";
    public final String CORRECT_LOGIN = "irisha.dieriecha@mail.ru";
    public final String CORRECT_PSW = "1z2x3c4v5b6n";
    public final String CORRECT_RESULTS = "Ирина Дереча";

    public PudraPage(WebDriver driver){
        this.driver = driver;
    }

    public void printSearch(String name) {
        By bySearchName = By.xpath(xpathSearchName);
        WebElement elementInputName = driver.findElement(bySearchName);
        elementInputName.sendKeys(name);
    }
    public void selectButtonSearch(){
        By byButtonSearch = By.xpath(xpathButtonSearch);
        WebElement elementButtonSearch = driver.findElement(byButtonSearch);
        elementButtonSearch.click();
    }
    public void fillSearchInputAndSend(String name){
        printSearch(name);
        selectButtonSearch();
    }
    public String getResults() {
        By byResults = By.xpath(xpathResults);
        List<WebElement> elementResults = driver.findElements(byResults);
        return elementResults.get(0).getText();
    }
    public void clickProduct() {
        By byProductResult = By.xpath(xpathProduct);
        WebElement elementProductClick = driver.findElement(byProductResult);
        elementProductClick.click();
    }
    public String findProductCode(){
        By byProductCodeResult = By.xpath(xpathProductCode);
        WebElement elementProductCode = driver.findElement(byProductCodeResult);
        return elementProductCode.getText();
    }
    public String checkProductCode() {
        clickProduct();
        return findProductCode();
    }

    public void clickProfileBtn() {
        By byProfileBtn = By.xpath(xpathpRrofileBtn);
        WebElement elementProfileBtn = driver.findElement(byProfileBtn);
        elementProfileBtn.click();
    }
    public void clickEnterBtn() {
        By byEnterBtn = By.xpath(xpathEnterBtn);
        WebElement elementEnterBtn = driver.findElement(byEnterBtn);
        elementEnterBtn.click();
    }
    public void clickEnterSubmit() {
        By bySubmitForm = By.xpath(xpathSubmitForm);
        WebElement elementSubmitForm = driver.findElement(bySubmitForm);
        elementSubmitForm.click();
    }
    public void goLogIn() {
        clickProfileBtn();
        clickEnterBtn();
    }
    public void checkEmptyFields() {
        goLogIn();
        clickEnterSubmit();
    }
    public String findErrorEmailRequire() {
        By byErrorMailRequire = By.xpath(xpathErrorMailRequire);
        WebElement elementErrorMailRequire = driver.findElement(byErrorMailRequire);
        return elementErrorMailRequire.getText();
    }
    public String findErrorPasswordRequire() {
        By byErrorPswRequire = By.xpath(xpathErrorPasswordRequire);
        WebElement elementErrorPswRequire = driver.findElement(byErrorPswRequire);
        return elementErrorPswRequire.getText();
    }

    public void printLogin(String login) {
        By byLoginInput = By.xpath(xpathLogin);
        WebElement elementLoginInput= driver.findElement(byLoginInput);
        elementLoginInput.sendKeys(login);
    }
    public void printPsw(String password) {
        By byPswInput = By.xpath(xpathPsw);
        WebElement elementPswInput = driver.findElement(byPswInput);
        elementPswInput.sendKeys(password);
    }
    public void SubmitDate(String login, String password) {
        goLogIn();
        printLogin(login);
        printPsw(password);
        clickEnterSubmit();
    }
    public String findErrorMessageEncorrectDate(){
        By byErrorMessageEncorrectDate = By.xpath(xpathEncorrectDate);
        WebElement elementErrorMessageEncorrectDate = driver.findElement(byErrorMessageEncorrectDate);
        return elementErrorMessageEncorrectDate.getText();
    }

    public String findMyProfile(){
        By byMyProfile = By.xpath(xpathMyProfile);
        WebElement elementMyProfile = driver.findElement(byMyProfile);
        return elementMyProfile.getText();
    }
}
