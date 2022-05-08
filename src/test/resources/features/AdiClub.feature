Feature: User can use the Adidas membership
  program “adiClub” to earn points with every sports activity I complete on the apps.

  @REQ-ADICLUB-1 @SetPerAndLogOutFromApp @Regression
  Scenario Outline: Register new user in an adiClub country US
    Given User navigate to registration screen
    When User fill mandatory fields for new registration with <fName> <lName> <gender> <email> <password> <month> <day> <year>
    And User fill required additional steps
    Then User validate that he registered successfully <fName>
    Examples:
      | fName         | lName         | gender | email      | password         | month | day | year |
      | TaskFName     | TaskLName     | Male   | Runtastic  | Runtastic_Auto17 | Jun   | 17  | 1989 |

  @REQ-ADICLUB-2 @LogOutFromApp @Regression
  Scenario: User check his points and level from profile tab
    Given I have existing UserName and password
    When User set the permissions
    And User go to profile tab
    Then User make sure he has 50 points point and on LEVEL 1

  @REQ-ADICLUB-3 @LogOutFromApp @Regression
  Scenario: User check adiClub pass from show more details on his profile
    Given I have existing UserName and password
    When User set the permissions
    And User go to profile tab
    And User go to show more screen
    And User go to adiClub pass screen
    Then User validate that his adiClub pass displayed ADIUS30271038408

  @REQ-ADICLUB-4 @LogOutFromApp @Regression
  Scenario: User check how to earn points from show more details on his profile
    Given I have existing UserName and password
    When User set the permissions
    And User go to profile tab
    And User go to show more screen
    And User go to how to earn points screen
    Then User validate the is in how to earn points screen HOW TO EARN POINTS

  @REQ-ADICLUB-5 @LogOutFromApp @Regression
  Scenario: User check his points history from show more details on his profile
    Given I have existing UserName and password
    When User set the permissions
    And User go to profile tab
    And User go to show more screen
    And User go to check points history details screen
    Then User validate his history MAY 1, 2022