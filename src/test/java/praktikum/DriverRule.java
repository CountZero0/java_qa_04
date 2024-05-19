package praktikum;


import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.time.Duration;

import static praktikum.EnvConfig.DEFAULT_TIMEOUT;


public class DriverRule extends ExternalResource {
    private WebDriver driver;

    @Override
    protected void before() throws Throwable {
        initDriver();

    }

    @Override
    protected void after() {
        driver.quit();
    }
    public void initDriver() {
        if ("firefox".equals(System.getProperty("browser"))) {
            initFirefox();
        }
        else {
            initChrome();
        }
    }

    private void initFirefox() {
        var opts = new FirefoxOptions().configureFromEnv();
        driver = new FirefoxDriver(opts);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(DEFAULT_TIMEOUT));
    }

    private void initChrome() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(DEFAULT_TIMEOUT));
    }

    public WebDriver getDriver() {
        return driver;
    }
}