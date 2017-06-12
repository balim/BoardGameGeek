package Helpers;

import org.openqa.selenium.chrome.ChromeDriver;

@SuppressWarnings("ALL")
public class ChromeDriverManager extends DriverManager {
    @Override
    public void createDriver() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
    }
}
