Feature: Get All Employees /getAllEmployees.php

Background: 
    Given user generates token

  @SyntaxHRMSGetAllEmployees
  Scenario: Retrieving all employees using /getAllEmployees.php 
    Given user calls getAllEmployees API
    When User retrieves response for getAllEmployees API
    Then status code is 200 for getAllEmployees API
    Then user validates all employees are retrieved