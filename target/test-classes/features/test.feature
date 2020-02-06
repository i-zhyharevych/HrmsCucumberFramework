@tag
Feature: Test
  Background:
    Given I do something before every Scenario in this feature file
    
  @tag1
  Scenario: Test1
    When I do some step
    And another step
      | a | b |
      | c | d |
      | e | f |
      | g | h |
    Then I validate the outcomes
      | Header1  | Header2  | Header3  |
      | Data 1.1 | Data 1.2 | Data 1.3 |
      | Data 2.1 | Data 2.2 | Data 2.3 |
  @tag2
  Scenario Outline: Title of your scenario outline
    When I check for the <value> in step
    Then I verify that for value <value>, the result "<status>"
    Examples: 
      | name  | value | status  |
      | name1 |     5 | Success |
      | name2 |     7 | Fail    |