package Redsoft;

import Redsoft.pages.HomePage;
import Redsoft.pages.OrderPage;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;

public class StandardOrderWithDeliveryCostTest extends WebDriverSettings {

    private HomePage homePage;

    private String address = "Россия, Московская область, Балашиха , микрорайон Железнодорожный, Пролетарская улица, 2к2";
    private String email = "test@mail.ru";
    private String name = "testName";
    private String lastName = "testLastName";
    private String phoneNamber = "88000000000";

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
                .setPhoneNumber(phoneNamber).approvePersonalData();
        OrderPage order = new OrderPage(driver);
        double productPrice = order.getProductsPrice();
        double deliveryPrice = order.getDeliveryPrice();
        double sumPrice = order.getSumPrice();
        assertTrue(Math.abs(sumPrice - productPrice - deliveryPrice) < 0.01);
    }

}
