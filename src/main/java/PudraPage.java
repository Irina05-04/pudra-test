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
    public final String RESULT_SEARCH_TEXT = "Крем для рук FarmStay с черным жемчугом Hand Cream Black Pearl - 100 гр";
    public final String RESULT_PRODUCT_CODE = "J0001S";
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
    public String checkProductCode() {
        clickProduct();
        By byProductCodeResult = By.xpath(xpathProductCode);
        WebElement elementProductCode = driver.findElement(byProductCodeResult);
        return elementProductCode.getText();
    }
}
