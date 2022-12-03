package by.bsu.fsc.Derecha.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    WebDriver driver;

    public final String URL = "https://aloespace.by/";

    public WebElement findElementByXpath(String xpath){
        By byElement = By.xpath(xpath);
        WebElement element = driver.findElement(byElement);
        return element;
    }

}
