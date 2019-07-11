package Redsoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeliveryPage {

    private WebDriver driver;

    private By selectManually = By.xpath("//div[@class='radio-label' " +
            "and contains(text(), 'Вручную')]");
    private By addressField = By.id("edit-customer-profile-shipping-string-address");
    private By addressListFirstElement = By.xpath("(//ul[@id='ui-id-9']/li)[1]");
    private By calculateButton = By.id("edit-customer-profile-shipping-delivery-submit-1");
    private By continueButton = By.id("edit-continue");

    public DeliveryPage(WebDriver driver) {
        this.driver = driver;
    }

    public DeliveryPage selectManually() {
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .elementToBeClickable(selectManually)).click();
        return this;
    }

    public DeliveryPage setAddress(String address) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(addressField));
        driver.findElement(addressField).sendKeys(address);
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .presenceOfElementLocated(addressListFirstElement)).click();
        return this;
    }

    public DeliveryPage calculate() {
        new WebDriverWait(driver, 30).until(ExpectedConditions
                .elementToBeClickable(calculateButton)).click();
        return this;
    }

    public BuyerInfoPage continueToBuyerInfo() {
        new WebDriverWait(driver, 30).until(ExpectedConditions
                .elementToBeClickable(continueButton)).click();
        return new BuyerInfoPage(driver);
    }

}
