@regression
Feature: Creating User Registration

  Scenario: user registration
    Given I am navigated to home page
    When I click on registration
    And I register the user
    Then I should see user registration successful
    When I logout from the application
    And I click on registration
    And I try to register with the same user created above
    Then I should see error as user is already exists