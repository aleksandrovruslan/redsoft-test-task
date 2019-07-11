package Redsoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {

    private WebDriver driver;

    private By productsPriceField = By.xpath(
            "//div[contains(text(), 'Сумма без доставки:')]/following-sibling::*");
    private By deliveryPriceField = By.xpath("//div[contains(text(), 'Доставка:')]/following-sibling::*");
    private By sumField = By.xpath("//div[contains(text(), 'итого')]/following-sibling::*");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public double getProductsPrice() {
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .presenceOfElementLocated(productsPriceField));
        String value = driver.findElement(productsPriceField).getText();
        value = value.replace(".", "").replace(",", ".").replaceAll("[^0-9.]", "");
        return Double.parseDouble(value);
    }

    public double getDeliveryPrice() {
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .presenceOfElementLocated(deliveryPriceField));
        String value = driver.findElement(deliveryPriceField).getText();
        value = value.replace(".", "").replace(",", ".").replaceAll("[^0-9.]", "");
        return Double.parseDouble(value);
    }

    public double getSumPrice() {
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .presenceOfElementLocated(sumField));
        String value = driver.findElement(sumField).getText();
        value = value.replace(".", "").replace(",", ".").replaceAll("[^0-9.]", "");
        return Double.parseDouble(value);
    }

}
