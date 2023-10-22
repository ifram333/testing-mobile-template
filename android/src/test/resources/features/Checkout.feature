@Android @Checkout
Feature: Checkout
  The purpose of this feature is to cover all the possible scenarios related to the checkout functionality.

  Background:
    Given The app loads the "login" page
    And I log in to the app with username "bob@example.com" and password "10203040"

  Scenario: 01. Validate checkout shipping address error messages
    Given The Checkout Shipping Address screen is displayed
    When I click the to payment button
    Then The checkout shipping address error messages are displayed

  Scenario: 02. Validate checkout payment error messages
    Given The Checkout Shipping Address screen is displayed
    And I fill the shipping address information "Tester Automation", "904 Street", "House 2", "Pembroke", "Florida", "33029" and "USA"
    And I click the to payment button
    And The Checkout Payment screen is displayed
    When I click the review order button
    Then The checkout payment error messages are displayed
