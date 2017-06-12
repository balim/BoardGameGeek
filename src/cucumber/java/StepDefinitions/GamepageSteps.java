package StepDefinitions;

import Base.Base;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GamepageSteps extends Base {

    public GamepageSteps(WebDriver driver) {
        super(driver);
    }

    public GamepageSteps() {
        super();
        //empty constructor
    }

    @Then("^Verify element '(.*)' text is equal with the API$")
    public void CheckLanguageDependence(String css) throws InterruptedException {
        Thread.sleep(1000);
        String actual = driver.findElement(By.cssSelector(css)).getText();
        Assert.assertEquals(LanguageDependence, actual);
    }
}