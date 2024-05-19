package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.EnvConfig;

import java.time.Duration;



public class MainPage {
    private final WebDriver driver;

    private final By cookieButton = By.className("App_CookieButton__3cvqF");
    private final By goButton = By.cssSelector("[class*=Header_Button__]");
    private final By orderField = By.cssSelector(".Input_Input__1iN_Z");
    private final By orderStatusField = By.className("Header_Link__1TAG7");
    private final By orderUpButton = By.xpath(".//div[2]/button[1]");

    private final By orderDownButton = By.xpath(".//div[5]/button");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOrderUpButton() {
        driver.findElement(orderUpButton).click();
    }

    public void clickOrderDownButton() {
        driver.findElement(orderDownButton).click();
    }

    public StatusPage clickOnGo() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(goButton));
        driver.findElement(goButton).click();

        return new StatusPage(driver);
    }

    public void clickCookie() {
        driver.findElement(cookieButton).click();
    }

    public void enterOrderNumber(String orderNumber) {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(orderField));
        driver.findElement(orderField).sendKeys(orderNumber);
    }

    public void clickOrderStatus() {
        driver.findElement(orderStatusField).click();
    }

    public void open() {
        driver.get(EnvConfig.BASE_URL);
    }

    public void clickFaqElement(int questionNumber) {
        WebElement element = driver.findElement(By.xpath(".//div[@id='accordion__heading-" +
                questionNumber + "']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public String textFaqAnswer(int answerNumber) {
        By answer = By.xpath(".//div[@id='accordion__panel-" + answerNumber + "']");
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOf(driver.findElement(answer)));
        return driver.findElement(answer).getText();
    }

}
