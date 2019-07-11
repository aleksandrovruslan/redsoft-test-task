package Redsoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    private WebDriver driver;
    private String homeLink = "https://shop.saint-gobain.ru/";

    private By deliveryRadioButton = By.xpath("//input[@id='edit-delivery-type-0']/parent::*");
    private By calculateDeliveryButton = By.id("edit-checkout");
    private By pickupRadio = By.xpath("//input[@id='edit-delivery-type-1']/parent::div");
    private By pechatnikiPoint = By.xpath("//input[@id='edit-pickup-78']/preceding-sibling::div[@class='fake-radio']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public CartPage selectDelivery() {
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .elementToBeClickable(deliveryRadioButton)).click();
        return this;
    }

    public DeliveryPage calculate() {
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .elementToBeClickable(calculateDeliveryButton)).click();
        return new DeliveryPage(driver);
    }

    public BuyerInfoPage pickup() {
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .elementToBeClickable(pickupRadio)).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .elementToBeClickable(pechatnikiPoint)).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .elementToBeClickable(calculateDeliveryButton)).click();
        return new BuyerInfoPage(driver);
    }

    public HomePage getHomePage() {
        driver.get(homeLink);
        return new HomePage(driver);
    }

}
