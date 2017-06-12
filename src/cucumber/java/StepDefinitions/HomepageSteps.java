package StepDefinitions;

import Base.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomepageSteps extends Base {

    public HomepageSteps(WebDriver driver) {
        super(driver);
    }

    public HomepageSteps() {
        super();
        //empty constructor
    }

    @Given("^Open selenium webdriver$")
    public void OpenDriver() {
        driver.manage().window().maximize();
    }

    @When("^Open page '(.*)'$")
    public void OpenPage(String url) {
        driver.get(url);
    }

    @When("^Click element '(.*)'$")
    public void ClickElement(String css) {
        driver.findElement(By.cssSelector(css)).click();
    }

    @When("^Fill textbox '(.*)' as '(.*)'$")
    public void FillTextbox(String css, String text) {
        driver.findElement(By.cssSelector(css)).clear();
        driver.findElement(By.cssSelector(css)).sendKeys(text);
    }

    @Then("^Verify element '(.*)' text is '(.*)'$")
    public void CheckText(String css, String expected) throws InterruptedException {
        Thread.sleep(1000);
        String actual = driver.findElement(By.cssSelector(css)).getText();
        Assert.assertEquals(expected, actual);
    }
}