package Helpers;

import org.openqa.selenium.ie.InternetExplorerDriver;

@SuppressWarnings("ALL")
public class IEDriverManager extends DriverManager {
    @Override
    public void createDriver() {
        System.setProperty("webdriver.chrome.driver", "driver/IEDriverServer.exe");
        driver = new InternetExplorerDriver();
    }
}