package Redsoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MultiComfortPage {

    private WebDriver driver;
    private String link = "https://shop.saint-gobain.ru/multicomfort";

    private By comfortBuyButton = By.xpath("(//div[@class='b-tarif__name' and text()='Comfort']/following-sibling::*)[2]");
    private By areaField = By.xpath("//input[@class='field_text js-calc__fld']");
    private By calculateButton = By.xpath("//div[text()='рассчитать']");
    private By calculationResultField = By.xpath("//th[contains(text(), 'Общая Стоимость материалов для ремонта составит примерно:')]/following-sibling::*");
    private By addToCartButton = By.xpath("//a[text()='Добавить в корзину']");

    public MultiComfortPage(WebDriver driver) {
        this.driver = driver;
        driver.get(link);
    }

    public MultiComfortPage comfortSetBuy() {
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .elementToBeClickable(comfortBuyButton)).click();
        return this;
    }

    public MultiComfortPage setAreaSize(Double size) {
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .visibilityOfElementLocated(areaField));
        driver.findElement(areaField).clear();
        driver.findElement(areaField).sendKeys(Keys.HOME);
        driver.findElement(areaField).sendKeys(size.toString());
        return this;
    }

    public double calculate() {
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .elementToBeClickable(calculateButton)).click();
        String value = driver.findElement(calculationResultField).getText();
        value = value.replace(".", "").replace(",", ".").replaceAll("[^0-9.]", "");
        return Double.valueOf(value);
    }

    public CartPage addToCart() {
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .elementToBeClickable(addToCartButton)).click();
        return new CartPage(driver);
    }

}
