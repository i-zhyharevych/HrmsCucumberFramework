Feature: Login

  Background: 
    Given I open browser and navigate to the HRMS

  @smoke
  Scenario: Valid login
    When I enter valid username and valid password
    And I click on login button
    Then I successfully logged in
    And I close browser

  @regression
  Scenario: Invalid Login
    When I enter valid username and invalid password
    And I click on login button
    Then I see error message
    And I close browser

  @regression
  Scenario Outline: Invalid Credentials
    When I enter "<username>" and "<password>"
    And I click on login button
    Then I see "<errorMessage>"
    And I close browser

    Examples: 
      | username |  | password   |  | errorMessage             |
      | Admin    |  | Syntx@123  |  | Invalid credentials      |
      | ghjnjnk  |  | Syntax@123 |  | Invalid credentials      |
      |          |  | Syntax@123 |  | Username cannot be empty |
      | Admin    |  |            |  | Password cannot be empty |
      |          |  |            |  | Username cannot be empty |
