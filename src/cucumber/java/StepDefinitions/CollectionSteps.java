package StepDefinitions;

import Base.Base;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.Random;

public class CollectionSteps extends Base {

    public CollectionSteps(WebDriver driver) {
        super(driver);
    }

    public CollectionSteps() {
        super();
        //empty constructor
    }

    @When("^Open one of the game page randomly$")
    public void OpenGame() {
        int count = driver.findElements(By.cssSelector("#collectionitems tr")).size();
        int randomElement = new Random().nextInt(count - 1) + 2;
        driver.findElement(By.cssSelector("#collectionitems tr:nth-of-type(" + randomElement + ") td:nth-of-type(1) a")).click();
    }
}