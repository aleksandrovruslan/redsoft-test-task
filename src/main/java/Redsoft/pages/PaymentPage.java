package Redsoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage {

    private WebDriver driver;

    private By cardOnlineRadio = By.xpath("//input[@id='edit-commerce-payment-payment-method-sg-sberbank-paymentcommerce-payment-sg-sberbank-payment']/following-sibling::label");
    private By placeOrderButton = By.xpath("//input[@id='edit-continue']");

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void placeOrder() {
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .elementToBeClickable(cardOnlineRadio)).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .elementToBeClickable(placeOrderButton)).click();
    }

}
