package Redsoft;

import Redsoft.pages.HomePage;
import org.junit.Test;

import java.util.List;

public class OrderPickupAndCashlessPaymentTest extends WebDriverSettings {

    @Test
    public void pickupAndCashlessPayment() {
        HomePage homePage = new HomePage(driver).cityConfirm();
        List<String> complexSolutions = homePage.getComplexSolutionList();
        complexSolutions.stream().limit(1).forEach(solution ->
                homePage.openComplexCatalog().getComplexSolution(solution)
                        .addToCart().getHomePage());
        homePage.getCart().pickup().setEmail(email).setName(name)
                .setName(name).setLastName(lastName)
                .setPhoneNumber(phoneNumber).approvePersonalData()
                .nextStep().placeOrder();
    }

}
