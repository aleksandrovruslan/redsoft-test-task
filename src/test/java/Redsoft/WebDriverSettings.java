package Redsoft;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSettings {

    protected WebDriver driver;

    protected String address = "Россия, Московская область, Балашиха , микрорайон Железнодорожный, Пролетарская улица, 2к2";
    protected String email = "test@mail.ru";
    protected String name = "testName";
    protected String lastName = "testLastName";
    protected String phoneNumber = "88000000000";

    static {
        System.setProperty("webdriver.chrome.driver", getDriverPath());
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    private static String getDriverPath() {
        String driverPath = "src/test/resources/";
        String osName = System.getProperty("os.name");

        if (osName.contains("Linux")) {
            driverPath += "chromedriver_linux64/chromedriver";
        } else if (osName.contains("Windows")) {
            driverPath += "chromedriver_win32/chromedriver.exe";
        } else if (osName.contains("Mac")) {
            driverPath += "chromedriver_mac64/chromedriver";
        }
        return driverPath;
    }

}
