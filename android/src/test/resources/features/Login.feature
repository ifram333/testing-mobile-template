@Android @LogIn
Feature: Log in
  The purpose of this feature is to cover all the possible scenarios related to the log in functionality.

  Scenario Outline: 01. Log in the app with the user "<username>"
    Given The Log In screen is displayed
    When I log in the app with the user "<username>" and password "<password>"
    Then The Products screen is displayed

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
      | problem_user  | secret_sauce |

  Scenario: 02. Try to log in with the locked user
    Given The Log In screen is displayed
    When I try to log in the app with the user "locked_out_user" and password "secret_sauce"
    Then The locked out user message is displayed

  Scenario: 03. Validate that the username is required
    Given The Log In screen is displayed
    When I click on the LOGIN button without filling the username input
    Then The username is required message is displayed

  Scenario: 04. Validate that the password is required
    Given The Log In screen is displayed
    When I fill the username input
    And I click on the LOGIN button
    Then The password is required message is displayed

  Scenario: 05. Click the standard_user label
    Given The Log In screen is displayed
    When I click on the standard user label
    Then The username input is filled with the value standard_user

  Scenario: 06. Click the locked_out_user label
    Given The Log In screen is displayed
    When I click on the locked out user label
    Then The username input is filled with the value locked_out_user

  Scenario: 07. Click the problem_user label
    Given The Log In screen is displayed
    When I click on the problem user label
    Then The username input is filled with the value problem_user