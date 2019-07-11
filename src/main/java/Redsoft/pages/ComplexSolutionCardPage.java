package Redsoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComplexSolutionCardPage {

    private WebDriver driver;

    private By addToCartButton = By.xpath("//button[@class='btn-buy' and contains(text(), 'В корзину')]");
    private String cartTitle = "Ваша корзина | Интернет-магазин Saint-Gobain";

    public ComplexSolutionCardPage(WebDriver driver) {
        this.driver = driver;
    }

    public CartPage addToCart() {
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .elementToBeClickable(addToCartButton)).click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.titleIs(cartTitle));
        return new CartPage(driver);
    }

}
