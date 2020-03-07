Feature: Get All Job Titles /jobTitle.php

Background: 
    Given user generates token

  @SyntaxHRMSGetAllJobTitles
  Scenario: Retrieving all job titles using /jobTitle.php 
    Given user calls jobTitle API
    When User retrieves response for jobTitle API
    Then status code is 200 for jobTitle API
    Then user validates all job titles are retrieved
