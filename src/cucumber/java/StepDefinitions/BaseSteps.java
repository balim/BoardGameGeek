package StepDefinitions;

import Base.Base;
import Helpers.DriverManager;
import Helpers.DriverManagerFactory;
import Helpers.DriverType;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

public class BaseSteps extends Base {

    public BaseSteps(WebDriver driver) {
        super(driver);
    }

    public BaseSteps() {
        super();
        //empty constructor
    }

    @Before
    public void OpenDriver() {
        try {
            DriverManager driverManager;
            driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
            // driverManager = DriverManagerFactory.getManager(DriverType.FIREFOX);
            driver = driverManager.getDriver();
        } catch (Throwable ex) {
            System.out.println("Error: " + ex);
        }
    }

    @After
    public void CloseDriver() {
        driver.close();
        driver.quit();
    }
}