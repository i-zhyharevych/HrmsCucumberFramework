@sprint2 @addemployee
Feature: Add Employee

  Background: 
    Given I am logged into HRMS
    And I navigated to Add Employee Page

  @hello
  Scenario: Add new Employee
    When I add "Yvonne", "S" and "Smith"
    And I click Save
    Then I see Employee has been succesfully added

  @regression
  Scenario Outline: Add new Employee with different data
    When I add "<FirstName>", "<MiddleName>" and "<LastName>"
    And I click Save
    Then I see Employee with "<FirstName>", "<MiddleName>" and "<LastName>" is displayed

    Examples: 
      | FirstName | MiddleName | LastName |
      | James     |            | Smith    |
      | Jane      | J          | Smith    |
      | Sasha     | J          | Smith    |
      | David     | J          | Smith    |

  @regression
  Scenario: Add one Employee and Modify Employee Details
    When I enter employee details
      | FirstName | MiddleName | LastName |
      | Mary      | J          | Smith    |
    And I click Save
    Then I am able to modify Employee Details
      | DriverLisence | ExpirationDate | SSN         | SIN     | Gender | MaritalStatus | Nationality | DOB        |
      | Bhjkn4        | 2021-12-08     | 123-45-6789 | 7687687 | Male   | Single        | Slovenian   | 1980-10-10 |
      | VFFF77        | 2018-12-08     | yiy-45-6789 | uyiy    | Female | Married       | Ukrainian   | 1980-10-10 |

  @regression
  Scenario: Add Employee without employee id
    When I add "Anna", "Maria" and "McGriffin"
    And I delete employee id
    And I click Save
    Then I see employee without employee id is being added

  @regression
  Scenario: Add Employee negative scenario
    When I click Save
    Then I see required error message next to the first and last name

  @regression
  Scenario Outline: AddEmployee and Login Credentials
    When I add "Anna", "Maria" and "McGriffin"
    And I click on create login checkbox
    And I enter "<username>", "<password>" and "<confirmPassword>"
    When I click Save
    Then I see Employee has been succesfully added

    Examples: 
      | username        |  | password    |  | confirmPassword |
      | studentStudent7 |  | Syntax@1234 |  | Syntax@1234     |
