
Feature: Login

  Scenario: Successful login with valid credentials
    Given I open the SauceDemo login page
    When I enter username "performance_glitch_user"
    And I enter password "secret_sauce"
    And I click the login button
    Then I should be logged in successfully

  Scenario: Login with invalid credentials
    Given I open the SauceDemo login page
    When I enter username "wrong_user"
    And I enter password "wrong_password"
    And I click the login button
    Then I should see the login error message "Epic sadface: Username and password do not match any user in this service"

  Scenario: Login with empty username and password
    Given I open the SauceDemo login page
    When I enter username ""
    And I enter password ""
    And I click the login button
    Then I should see the login error message "Epic sadface: Username is required"

Scenario: Login with a very long username
    Given I open the SauceDemo login page
    When I enter a username with 500 characters
    And I enter password "secret_sauce"
    And I click the login button
    Then I should see the login error message "Epic sadface: Username and password do not match any user in this service"