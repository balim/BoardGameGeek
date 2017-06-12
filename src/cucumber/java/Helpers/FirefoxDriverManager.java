package Helpers;

import org.openqa.selenium.firefox.FirefoxDriver;

@SuppressWarnings("ALL")
public class FirefoxDriverManager extends DriverManager {
    @Override
    public void createDriver() {
        driver = new FirefoxDriver();
    }
}
