package Redsoft;

import Redsoft.pages.MultiComfortPage;
import Redsoft.pages.OrderPage;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class MultiComfortTest extends WebDriverSettings {

    private MultiComfortPage multiComfortPage;
    private double size = 10.5;
    private String address = "Россия, Московская область, Балашиха" +
            ", микрорайон Железнодорожный, Пролетарская улица, 2к2";
    private String email = "test@mail.ru";
    private String name = "testName";
    private String lastName = "testLastName";
    private String phoneNumber = "88000000000";

    @Override
    @Before
    public void setUp() {
        super.setUp();
        multiComfortPage = new MultiComfortPage(driver);
    }

    @Test
    public void complexOrder() {
        double calculationResult = multiComfortPage.comfortSetBuy()
                .setAreaSize(size).calculate();
        multiComfortPage.addToCart().pickup().setEmail(email).setName(name)
                .setName(name).setLastName(lastName)
                .setPhoneNumber(phoneNumber).approvePersonalData();
        OrderPage order = new OrderPage(driver);
        double sumPrice = order.getSumPrice();
        assertTrue(Math.abs(sumPrice - calculationResult) < 0.01);
    }

}
