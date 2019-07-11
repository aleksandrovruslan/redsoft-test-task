package Redsoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductCardPage {

    private WebDriver driver;

    private By amountInput = By.xpath("//input[@id='spinner']");
    private By addToCartButton = By.xpath("//span[@title=" +
            "'Добавить товар в корзину' and contains(text(), 'в корзину')]");

    public ProductCardPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductCardPage setAmount(int amount) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(amountInput));
        driver.findElement(amountInput).clear();
        driver.findElement(amountInput).sendKeys(String.valueOf(amount));
        return this;
    }

    public CartPage addProductToCart() {
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .elementToBeClickable(addToCartButton)).click();
        return new CartPage(driver);
    }

}
