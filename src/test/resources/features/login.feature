Feature: Login

  @login
  Scenario: Successful login
    Given User is on Home Page
    When User clicks on Login icon
    And User enters valid data
    And User clicks on Anmelden button
    And User clicks on User status
    Then User verifies his name is displayed
