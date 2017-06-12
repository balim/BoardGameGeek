package Base;

import org.openqa.selenium.WebDriver;

public abstract class Base {
    protected static WebDriver driver;
    protected static String LanguageDependence;

    public Base(WebDriver driver) {
        this.driver = driver;
    }

    public Base() {
        //empty constructor
    }
}