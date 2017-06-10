package StepDefinitions;

import Helpers.API;
import cucumber.api.java.After;
import cucumber.api.java.en.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Random;

public class Steps {

    static WebDriver driver;
    static String LanguageDependence;

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

    @Then("^Verify element '(.*)' text is '(.*)'$")
    public void CheckText(String css, String expected) throws InterruptedException {
        Thread.sleep(1000);
        String actual = driver.findElement(By.cssSelector(css)).getText();
        Assert.assertEquals(expected, actual);
    }
    @Then("^Verify element '(.*)' text is equal with the API$")
    public void CheckLanguageDependence(String css) throws InterruptedException {
        Thread.sleep(1000);
        String actual = driver.findElement(By.cssSelector(css)).getText();
        Assert.assertEquals(LanguageDependence, actual);
    }

    @When("^Open one of the game page randomly$")
    public void OpenGame() {
        int count = driver.findElements(By.cssSelector("#collectionitems tr")).size();
        int randomElement = new Random().nextInt(count - 1) + 2;
        ClickElement("#collectionitems tr:nth-of-type(" + randomElement + ") td:nth-of-type(1) a");
    }

    @When("^Check most voted results in the API$")
    public void CheckMostVoted() throws Exception {
        String currentUrl = driver.getCurrentUrl();
        int slashIndex = currentUrl.lastIndexOf('/');
        String gameId = currentUrl.substring(36, slashIndex);

        String geekItemPollResponse = API.CallAPI("https://boardgamegeek.com/geekitempoll.php?action=view&itempolltype=languagedependence&objectid=" + gameId + "&objecttype=thing");

        JSONObject jsonObject = new JSONObject(geekItemPollResponse);
        String pollId = jsonObject.getJSONObject("poll").getString("pollid");

        String geekPollResponse = API.CallAPI("https://boardgamegeek.com/geekpoll.php?action=results&pollid=" + pollId);

        jsonObject = new JSONObject(geekPollResponse);
        JSONArray results = jsonObject.getJSONArray("pollquestions").getJSONObject(0).getJSONObject("results").getJSONArray("results");
        for (int i = 0; i < results.length(); i++) {
            if (results.getJSONObject(i).getBoolean("max") == true) {
                LanguageDependence = results.getJSONObject(i).getString("columnbody");
            }
        }
    }

    @After
    public void CloseDriver() {
        driver.close();
        driver.quit();
    }

}
