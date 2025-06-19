Feature: Complete purchase flow with validations and logout

  Scenario: Complete purchase flow with validations and logout

    Given the user is on the login screen
    When the user logs in with username "standard_user" and password "secret_sauce"
    Then the user should be logged in successfully

    And the user stores the title and price of the first product
    And the user taps add to cart on the stored product
    Then the mini cart icon should show 1 item

    When the user taps the mini cart icon
    Then the user should be on the cart screen
    And the product in the cart should have the same title and price

    When the user taps the checkout button
    And the user fills in checkout info with:
      | firstName | lastName | postalCode |
      |           | Silva     | 12345     |
    And the user taps the continue button
    Then an error message "First Name is required" should be displayed

    When the user fills in the first name as "João"
    And the user taps the continue button
    Then the user should be on the checkout overview screen
    And the product in the overview should match the selected product
    And the total price should be correct

    When the user taps the finish button
    Then a message "THANK YOU FOR YOU ORDER" should be displayed

    When the user taps back home
    And the user opens the menu and taps logout
    Then the user is on the login screen
