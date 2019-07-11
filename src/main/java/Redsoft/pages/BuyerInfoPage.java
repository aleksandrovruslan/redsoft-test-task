package Redsoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuyerInfoPage {

    private WebDriver driver;

    private By emailField = By.id("edit-customer-profile-billing-field-customer-recepient-email-und-0-value");
    private By nameField = By.id("edit-customer-profile-billing-field-user-first-name-und-0-value");
    private By lastNameField = By.id("edit-customer-profile-billing-field-user-last-name-und-0-value");
    private By phoneNumberField = By.id("edit-customer-profile-billing-field-user-phone-und-0-value");
    private By approvePersonalDataCheckbox = By.id("uniform-edit-customer-profile-billing-agreement");
    private By nextStepButton = By.id("edit-continue");

    public BuyerInfoPage(WebDriver driver) {
        this.driver = driver;
    }

    public BuyerInfoPage setEmail(String email) {
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .presenceOfElementLocated(emailField));
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public BuyerInfoPage setName(String name) {
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .presenceOfElementLocated(nameField));
        driver.findElement(nameField).sendKeys(name);
        return this;
    }

    public BuyerInfoPage setLastName(String lastName) {
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .presenceOfElementLocated(lastNameField));
        driver.findElement(lastNameField).sendKeys(lastName);
        return this;
    }

    public BuyerInfoPage setPhoneNumber(String phoneNumber) {
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .presenceOfElementLocated(phoneNumberField));
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
        return this;
    }

    public BuyerInfoPage approvePersonalData() {
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .elementToBeClickable(approvePersonalDataCheckbox)).click();
        return this;
    }

    public PaymentPage nextStep() {
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .elementToBeClickable(nextStepButton)).click();
        return new PaymentPage(driver);
    }

}
