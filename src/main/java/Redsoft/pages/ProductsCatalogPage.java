package Redsoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsCatalogPage {

    private WebDriver driver;

    private By productBuyButton = By.xpath("(//div[@class='btn']/a[@class='btn-buy small'])[1]");

    public ProductsCatalogPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductCardPage getFirstProduct() {
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .elementToBeClickable(productBuyButton)).click();
        return new ProductCardPage(driver);
    }

}
