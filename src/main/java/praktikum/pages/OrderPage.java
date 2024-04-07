package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class OrderPage {
    private WebDriver driver;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By nameField = By.xpath("//input[@placeholder= '* Имя']");

    private final By secondNameField = By.xpath(".//input[@placeholder= '* Фамилия']");

    private final By addressField = By.xpath(".//div[3]/input");


    private final By metroStationField = By.xpath(".//div[4]/div/div/input");

    private final By phoneNumberField = By.xpath(".//div[5]/input");

    private final By nextButton = By.xpath(".//div[2]/div[3]/button");

    private final By dateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By dateTab = By.xpath(".//div[@class='react-datepicker__day react-datepicker__day--003']");

    private final By periodField = By.xpath(".//div[@class='Dropdown-placeholder']");

    private final By orderButton = By.xpath(".//div[2]/div[3]/button[2]");

    private final By yesButton = By.xpath(".//div[5]/div[2]/button[2]");

    private final By orderConfirmedTitle = By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']");

    public void setName(String name) {
        driver.findElement(nameField).clear();
        driver.findElement(nameField).sendKeys(name);
    }

    public void setSecondName(String secondName) {
        driver.findElement(secondNameField).clear();
        driver.findElement(secondNameField).sendKeys(secondName);

    }

    public void setAddress(String address) {
        driver.findElement(addressField).clear();
        driver.findElement(addressField).sendKeys(address);
    }

    public void setDate() {
        driver.findElement(dateField).click();
        driver.findElement(dateTab).click();
    }

    public void clickMetro(int metroPoint) {
        driver.findElement(metroStationField).click();
        driver.findElement(By.xpath(".//li[@data-index='" + metroPoint + "']")).click();
    }

    public void setNumber(String number) {
        driver.findElement(phoneNumberField).clear();
        driver.findElement(phoneNumberField).sendKeys(number);
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void clickYesButton() {
        driver.findElement(yesButton).click();
    }
    public void clickRentalPeriod(String rentalPeriod) {
        driver.findElement(periodField).click();
        driver.findElement(By.xpath(".//div[text()='"+ rentalPeriod + "']")).click();
    }

    public String headerOrderConfirm() {
        return driver.findElement(orderConfirmedTitle).getText();
    }

    public void makeOrder(String name, String secondName, String address, int metroPoint,
                          String number, String rentalPeriod) {
        setName(name);
        setSecondName(secondName);
        setAddress(address);
        clickMetro(metroPoint);
        setNumber(number);
        clickNextButton();
        setDate();
        clickRentalPeriod(rentalPeriod);
        clickOrderButton();
        clickYesButton();
    }

}











