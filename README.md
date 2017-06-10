# Board Game Geek Assessment

Practical Task:
------------
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

How to start?
------------
First you need to install gradle to your operating system.

More information about how to install gradle: https://gradle.org/install


Clone repository
````
git clone https://github.com/celikgumusdag/BoardGameGeek.git
````

Change your directory as root of the project
````
cd BoardGameGeek
````

Build
````
gradlew build
````

Running to automation with cucumber
````
gradlew cucumber
````

Help
------------
If you got any questions don't hesitate to contact with me: [celikgumusdag@gmail.com](mailto:celikgumusdag@gmail.com)

License
------------
This repository is open source software provided under the Apache License 2.0. 

This documentation and other similar content use the Creative Commons Attribution 3.0 Unported license. 

Most libraries and tools in the ecosystem are also open source, but they may use different licenses.
