Feature: Validating Syntax /getOneEmployee.php HRMS API

  Background: 
    Given user generates token

  #This is the only homework Assignment
  @APITEST
  Scenario: Retrieving created Employee using /getOneEmployee.php API
    Given user calls getOneEmployee API
    When User retrieves response from getOneEmployee
    Then status code is 200 for getting one employee
    Then user validates created employee exists
