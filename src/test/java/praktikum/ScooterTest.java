package praktikum;


import org.junit.Rule;
import org.junit.Test;

import praktikum.pages.*;


public class ScooterTest {
    private final String INVALID_ORDER_NUMBER = "123";
    @Rule
    public DriverRule driverRule = new DriverRule();

    @Test
    public void invalidOrderNumber() {


        MainPage objMainPage = new MainPage(driverRule.getDriver());
        objMainPage.open();
        objMainPage.clickCookie();
        objMainPage.clickOrderStatus();
        objMainPage.enterOrderNumber(INVALID_ORDER_NUMBER);

        StatusPage statusPage = objMainPage.clickOnGo();
        statusPage.checkNotFound();
    }
}
