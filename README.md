# Board Game Geek Assessment

### Practical Task:
 
Create an acceptance test for [BoardGameGeek](http://www.boardgamegeek.com) service covering the following scenario:
````
1.    WEB Open the game collection of a user.
2.    WEB Go to the page of one of the games (chosen at random).
3.    API Check the information about the game - look for poll results about Language Dependence.
4.    WEB Verify that the most voted Language Dependence level is presented on the game's page.
````

Note: Write test in human-friendly language (Cucumber/Spock) and simply runnable from command line (use Gradle as project build tool). 
Java/Groovy programming language should be used under the hood. 
Test is expected to run on both Windows and GNU/Linux OS.

Important: Please don't use any external libraries to handle BoardGameGeek API calls (like bgg4j). 
Your task is to test the API, not some BGG-specific library. 
However, you can (and are encouraged to) use a library to make REST calls/testing easier.
