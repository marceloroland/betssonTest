Feature: Login functionality

  Scenario: Login with valid credentials
    Given the user is on the login screen
    When the user logs in with username "standard_user" and password "secret_sauce"
    Then the user should be logged in successfully

  Scenario: Login with invalid credentials
    Given the user is on the login screen
    When the user logs in with username "wrong_user" and password "wrong_pass"
    Then the user should see the login error message "Username and password do not match any user in this service."
