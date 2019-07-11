package Redsoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage {

    private WebDriver driver;
    private String homeLink = "https://shop.saint-gobain.ru/";

    private By cityButtonClose = By.xpath("//div/span[@class=" +
            "'btn btn_yes  js-location-message__close']");
    private By catalog = By.xpath("//li[@class='item menu-1']");
    private By multiComfortButton = By.xpath("//li[@class='item menu-5']" +
            "/a[contains(text(), 'КОМПЛЕКСНЫЕ РЕШЕНИЯ')]");
    private By complexCatalogButton = By.id("ui-id-7");
    private By complexCatalogList = By.xpath("//div[@id='ui-id-8']/ul/li/a");
    private By cartButton = By.xpath("//div[@class='b-cart']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        driver.get(homeLink);
    }

    public HomePage cityConfirm() {
        try {
            new WebDriverWait(driver, 10).until(ExpectedConditions
                    .elementToBeClickable(cityButtonClose)).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public ProductsCatalogPage getCatalog() {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(catalog));
        driver.findElement(catalog).click();
        return new ProductsCatalogPage(driver);
    }

    public MultiComfortPage getMultiComfort() {
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .elementToBeClickable(multiComfortButton)).click();
        return new MultiComfortPage(driver);
    }

    public HomePage openComplexCatalog() {
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .elementToBeClickable(complexCatalogButton)).click();
        return this;
    }

    public List<String> getComplexSolutionList() {
        openComplexCatalog();
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .presenceOfElementLocated(complexCatalogList));
        return driver.findElements(complexCatalogList).stream()
                .map(e -> e.getText()).collect(Collectors.toList());
    }

    public ComplexSolutionCardPage getComplexSolution(String name) {
        By position = By.xpath("//div[@id='ui-id-8']/ul/li/a[contains(text(), '" + name + "')]");
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .visibilityOfElementLocated(position)).click();
        return new ComplexSolutionCardPage(driver);
    }

    public CartPage getCart() {
        new WebDriverWait(driver, 10).until(ExpectedConditions
                .elementToBeClickable(cartButton)).click();
        return new CartPage(driver);
    }

}
