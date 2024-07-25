Feature: Login functionality
  Scenario: Successful login attempt
    Given I am on the Sample App login page
    And I fill in the User Name as "admin"
    And I fill in the Password as "pwd"
    When I click on the Log In button
    Then I see the message "Welcome, admin!"

  Scenario: Unsuccessful login attempt
    Given I am on the Sample App login page
    And I fill in the User Name as "admin"
    And I fill in the Password as "admin"
    When I click on the Log In button
    Then I see the message "Invalid username/password"