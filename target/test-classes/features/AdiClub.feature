Feature: User can use the Adidas membership
  program “adiClub” to earn points with every sports activity I complete on the apps.

  @REQ-ADICLUB-1 @SetPerAndLogOutFromApp
  Scenario Outline: Register new user in an adiClub country US
    Given User navigate to registration screen
    When User fill mandatory fields for new registration with <fName> <lName> <gender> <email> and <password>
    And User fill required additional steps
    Then User validate that he registered successfully <fName>
    Examples:
      | fName         | lName         | gender | email      | password         |
      | TaskFName     | TaskLName     | Male   | Runtastic  | Runtastic_Auto17 |

  @REQ-ADICLUB-2 @LogOutFromApp
  Scenario: User check his points and level from profile tab
    Given I have existing UserName and password
    When User set the permissions
    And User go to profile tab
    Then User make sure he have 50 points point and on LEVEL 1

  @REQ-ADICLUB-3 @LogOutFromApp
  Scenario: User check adiClub pass from show more details on his profile
    Given I have existing UserName and password
    When User set the permissions
    And User go to profile tab
    And User go to show more screen
    And User go to adiClub pass screen
    Then User validate that his adiClub pass displayed ADIUS30271038408

  @REQ-ADICLUB-4 @LogOutFromApp
  Scenario: User check how to earn points from show more details on his profile
    Given I have existing UserName and password
    When User set the permissions
    And User go to profile tab
    And User go to show more screen
    And User go to how to earn points screen
    Then User validate the is in how to earn points screen HOW TO EARN POINTS

