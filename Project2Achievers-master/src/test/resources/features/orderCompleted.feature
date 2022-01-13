Feature:A Shopper should be able to select and  mark an order complete.


  Scenario:As a shopper I want to update a shopping list completed upon delivery.
    Given A Shopper is now on the current order page.
    When The Shopper clicks on the Select List Button.
    When The Shopper clicks on the back button
    When The Shopper clicks on the complete button.
    Then The order should be complete.