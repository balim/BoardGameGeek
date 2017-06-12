package StepDefinitions;

import Base.Base;
import Helpers.API;
import cucumber.api.java.en.When;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

public class APISteps extends Base {

    public APISteps(WebDriver driver) {
        super(driver);
    }

    public APISteps() {
        super();
        //empty constructor
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
}