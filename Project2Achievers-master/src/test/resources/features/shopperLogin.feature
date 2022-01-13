Feature: ShopperLogin

  Scenario: as a shopper i want to login into site
    Given The shopper is on the login page
    When The shopper enters username into username input box
    When The shopper enters password into password input box
    When The shopper clicks the login button
    Then The shopper is redirected to the Shopper Dashboard