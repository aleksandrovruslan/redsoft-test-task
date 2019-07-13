package Redsoft;

import Redsoft.pages.HomePage;
import Redsoft.pages.OrderPage;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;

public class StandardOrderWithDeliveryCostTest extends WebDriverSettings {

    private HomePage homePage;

    @Override
    @Before
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver).cityConfirm();
    }

    @Test
    public void standardOrder() {
        homePage.getCatalog().getFirstProduct().setAmount(1).addProductToCart()
                .selectDelivery().calculate().selectManually()
                .setAddress(address).calculate().continueToBuyerInfo()
                .setEmail(email).setName(name).setName(name).setLastName(lastName)
                .setPhoneNumber(phoneNumber).approvePersonalData();
        OrderPage order = new OrderPage(driver);
        double productPrice = order.getProductsPrice();
        double deliveryPrice = order.getDeliveryPrice();
        double sumPrice = order.getSumPrice();
        assertTrue(Math.abs(sumPrice - productPrice - deliveryPrice) < 0.01);
    }

}
