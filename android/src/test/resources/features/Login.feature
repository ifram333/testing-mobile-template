@Android @LogIn
Feature: Log in
  The purpose of this feature is to cover all the possible scenarios related to the log in functionality.

  Background:
    Given The app loads the "login" page
    
  Scenario: 01. Log in the app
    Given The Login screen is displayed
    When I fill the username "bob@example.com"
    And I fill the password "10203040"
    And I click the login button
    Then The Products screen is displayed

  Scenario: 02. Try to log in with the locked user
    Given The Login screen is displayed
    When I fill the username "alice@example.com"
    And I fill the password "10203040"
    And I click the login button
    Then The user message "Sorry, this user has been locked out." is displayed

  Scenario: 03. Try to log in with invalid credentials
    Given The Login screen is displayed
    When I fill the username "ivan@example.com"
    And I fill the password "10203040"
    And I click the login button
    Then The user message "Provided credentials do not match any user in this service." is displayed

  Scenario: 04. Validate that the username is required
    Given The Login screen is displayed
    When I click on the Login button
    Then The username is required message is displayed

  Scenario: 05. Validate that the password is required
    Given The Login screen is displayed
    When I fill the username "ivan@example.com"
    And I click on the Login button
    Then The password is required message is displayed