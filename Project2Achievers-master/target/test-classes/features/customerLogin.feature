Feature: Customer Login

  Scenario: as a customer i want to login into site
    Given The customer is on the login page
    When The customer enters username into username input box
    When The customer enters password into password input box
    When The customer clicks the login button
    Then The customer is redirected to the Customer Dashboard


