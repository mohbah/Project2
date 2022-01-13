Feature: Register Shopper Account

  Scenario: Creating a new shopper account
    Given : Shopper is on registration page
    When : Shopper enters username
    When : Shopper enters password
    When : Shopper enters name
    When : Shopper enters zipcode
    When : Shopper enters age
    When The shopper clicks the shopper register button
    Then : Shopper get alert that account creation was successful