Feature: Get All Employee Statuses /employeeStatus.php

Background: 
    Given user generates token

  @SyntaxHRMSGetAllEmployeeStatuses
  Scenario: Retrieving all employee statuses using /employeeStatus.php 
    Given user calls employeeStatus API
    When User retrieves response for  all employee Status API
    Then status code is 200 for employee Status API
    Then user validates all employee statuses are returned
