package StepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Steps {

    static WebDriver driver;

    @Given("^Open selenium webdriver$")
    public void OpenDriver() {
        System.out.print(System.getProperty("user.dir"));
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
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

    @Then("^I see element '(.*)' text is '(.*)'$")
    public void CheckText(String css, String expected) throws InterruptedException {
        Thread.sleep(1000);
        String actual = driver.findElement(By.cssSelector(css)).getText();
        Assert.assertEquals(expected, actual);
    }

    @After
    public void CloseDriver() {
        driver.close();
    }

}
