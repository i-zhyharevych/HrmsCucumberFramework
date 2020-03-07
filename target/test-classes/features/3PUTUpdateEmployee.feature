Feature: Validating Syntax /updateEmployee.php HRMS API

  Background: 
    Given user generates token

  @SyntaxHRMSAPIEndToEnd1
  Scenario: Updating created employee using /updateEmployee.php API
    Given user calls updateEmployee
    When User retrieves response for updateEmployee API
    Then status code is 200 for updateEmployee API
    Then user verifies employee name was updated
    Then user validates employee was updated


