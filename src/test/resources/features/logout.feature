Feature: Logout functionality

Scenario: Logout after successful login
  Given the user is on the login screen
  When the user logs in with username "standard_user" and password "secret_sauce"
  And the user should be logged in successfully
  And the user opens the menu and taps logout
  Then the user should be returned to the login screen
