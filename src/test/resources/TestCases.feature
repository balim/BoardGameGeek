Feature: Assessment

  Scenario: Open page
    #WEB Open the game collection of a user.
    Given Open selenium webdriver
    When  Open page 'https://www.boardgamegeek.com'
    And   Fill textbox '#login_username' as 'celikgumusdag'
    And   Fill textbox '#login_password' as '12345678'
    And   Click element '.loginbox>input'
    Then  I see element '.mt5>a' text is 'celikgumusdag'