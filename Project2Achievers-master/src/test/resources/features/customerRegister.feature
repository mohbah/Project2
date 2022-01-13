Feature: Register Customer Account

  Scenario: create a customer account
    Given The customer is on the registration page
    When The customer enters a unique username
    When The customer enters unique password
    When The customer enters their name
    When The customer enters their zipcode
    When The customer clicks the customer register button
    Then The customer is alerted of account creation success