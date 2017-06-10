Feature: Assessment

  Scenario: Open page
    #WEB Open the game collection of a user.
    Given Open selenium webdriver
    When  Open page 'https://www.boardgamegeek.com'
    And   Fill textbox '#login_username' as 'celikgumusdag'
    And   Fill textbox '#login_password' as '12345678'
    And   Click element '.loginbox>input'
    Then  Verify element '.mt5>a' text is 'celikgumusdag'
    When  Open page 'https://boardgamegeek.com/collection/user/celikgumusdag'
    #WEB Go to the page of one of the games (chosen at random)
    And   Open one of the game page randomly
    #API Check the information about the game - look for poll results about Language Dependence.
    And   Check most voted results in the API
    #WEB Verify that the most voted Language Dependence level is presented on the game's page.
    Then Verify element '.feature-description>span>span' text is equal with the API