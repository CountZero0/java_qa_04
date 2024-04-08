package praktikum;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.hamcrest.MatcherAssert;
import praktikum.pages.MainPage;
import praktikum.pages.OrderPage;


import static org.hamcrest.CoreMatchers.containsString;


@RunWith(Parameterized.class)
public class OrderTest {
    @Rule
    public DriverRule driverRule = new DriverRule();
    private final String name;
    private final String secondName;

    private final String number;
    private final String date;
    private final String address;

    private final String rentalPeriod;
    private final String buttonChoose;
    private final int metroPoint;


    public OrderTest(String buttonChoose, String name, String secondName, String address,int metroPoint, String number, String date, String rentalPeriod) {
        this.buttonChoose = buttonChoose;
        this.name = name;
        this.secondName = secondName;
        this.address = address;
        this.metroPoint = metroPoint;
        this.number = number;
        this.date = date;
        this.rentalPeriod = rentalPeriod;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderData() {
        return new Object[][] {
                {"Up","Константин", "Давыдочкин", "Охотный ряд 2", 4, "+79994442211", "28", "двое суток"},
                {"Down", "Максим", "Лисицын", "Охотный ряд 4", 9, "+79134135699", "01", "сутки"},
        };
    }

    @Test
    public void orderTest() {
        OrderPage objOrderPage = new OrderPage(driverRule.getDriver());
        MainPage objMainPage = new MainPage(driverRule.getDriver());

        objMainPage.open();
        objMainPage.clickCookie();

        if ("Up".equals(buttonChoose)) {
            objMainPage.clickOrderUpButton();
        } else objMainPage.clickOrderDownButton();

        objOrderPage.makeOrder(name, secondName, address, metroPoint, number, date, rentalPeriod);
        MatcherAssert.assertThat(objOrderPage.headerOrderConfirm(), containsString("Заказ оформлен"));

    }












}
